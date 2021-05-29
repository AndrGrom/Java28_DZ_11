package com.company;

public class Address {
    private int id;
    private String city;
    private String street;
    private int houseNumber;
    private int corps;
    private int apartment;

    public Address(Integer id, String city, String street, Integer houseNumber, int corps, int apartment) {

        this.id = id;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.corps = corps;
        this.apartment = apartment;
    }

    public Address(String city, String street, Integer houseNumber, int corps, int apartment) {

        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.corps = corps;
        this.apartment = apartment;
    }

    public int getId() { return id; }
    public String getCity() { return city; }
    public String getStreet() { return street; }
    public int getHouseNumber() { return houseNumber; }
    public int getCorps() { return corps; }
    public int getApartment() { return apartment; }

    public void setId(int id) { this.id = id; }
    public void setCity(String city) { this.city = city; }
    public void setStreet(String street) { this.street = street; }
    public void setHouseNumber(int houseNumber) { this.houseNumber = houseNumber; }
    public void setCorps(int corps) { this.corps = corps; }
    public void setApartment(int apartment) { this.apartment = apartment; }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", corps=" + corps +
                ", apartment=" + apartment +
                '}';
    }
}
