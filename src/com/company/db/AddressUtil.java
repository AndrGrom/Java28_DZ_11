package com.company.db;
import com.company.Address;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressUtil {

    public static Address toObject(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String city = resultSet.getString("city");
        String street = resultSet.getString("street");
        int houseNumber = resultSet.getInt("house_number");
        int corps = resultSet.getInt("corps");
        int apartment = resultSet.getInt("apartment");
        return new Address(id, city, street, houseNumber, corps, apartment);
    }
}
