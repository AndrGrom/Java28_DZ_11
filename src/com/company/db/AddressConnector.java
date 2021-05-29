package com.company.db;

import com.company.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressConnector {

    private List<Address> addressList;
    private static final String INSERT = "INSERT INTO addresses (city, street, house_number, corps, apartment) VALUES (?,?,?,?,?)";
    private static final String SELECT = "SELECT * FROM addresses";
    private static final String DELETE = "DELETE FROM addresses WHERE id = ?";
    private static final String UPDATE = "UPDATE addresses SET city = ?, street = ?, house_number = ?, corps = ?, apartment = ? WHERE id = ?";
    private static final String ADDRESS_ID = "SELECT * FROM addresses WHERE id = ?";
    public AddressConnector(List<Address> addressList) { this.addressList = addressList; }

    public void add(Address address){
        Connection connection = DbConnection.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(INSERT)){
            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setInt(3, address.getHouseNumber());
            statement.setInt(4, address.getCorps());
            statement.setInt(5, address.getApartment());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Address> readAll() {
        List<Address> items = new ArrayList<>();
        Connection connection = DbConnection.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String city = resultSet.getString("city");
                String street = resultSet.getString("street");
                int houseNumber = resultSet.getInt("house_number");
                int corps = resultSet.getInt("corps");
                int apartment = resultSet.getInt("apartment");

                Address item = new Address(id, city, street, houseNumber, corps, apartment);
                items.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public static void delete(int id){
        Connection connection = DbConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка удаления");
        }
    }

    public static boolean update(Address address){
        Connection connection = DbConnection.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(UPDATE)){
            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setInt(3, address.getHouseNumber());
            statement.setInt(4, address.getCorps());
            statement.setInt(5, address.getApartment());
            statement.setInt(6, address.getId());
            int another = statement.executeUpdate();
            return another != 0;
        } catch (SQLException e){
            System.out.println("Ошибка обновления данных");
        }
        return false;
    }

    public void addDbList() {
        for(Address address : addressList){
            new AddressConnector(addressList).add(address);
        }
    }
    public static Address AddressId(int id) {
        Connection connection = DbConnection.getConnection();
        Address res = null;
        try(PreparedStatement statement = connection.prepareStatement(ADDRESS_ID)){
            statement.setInt(1,id);
            ResultSet addressRes = statement.executeQuery();
            addressRes.next();
            res = AddressUtil.toObject(addressRes);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return res;
    }
}
