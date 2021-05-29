package com.company;

import com.company.db.AddressConnector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Address address1 = new Address("Minsk", "Kolasa", 56, 1,12);
        Address address2 = new Address("Brest", "Lesnaya", 19, 2,25);
        Address address3 = new Address("Grodna", "Svetlaya", 65, 3,4);
        Address address4 = new Address("Vitebsk", "Krasnaya", 22, 5,53);
        Address address5 = new Address("Gomel", "Belaya", 1, 2,17);

        List<Address> addressList = new ArrayList<>(Arrays.asList(address1,address2,address3,address4,address5));
        AddressConnector dbList = new AddressConnector(addressList);

        // 7.add
        dbList.addDbList();
        System.out.println("- add -");
        // 8.toString
        for (Address address : AddressConnector.readAll()){
            System.out.println(address.toString());
        }
        // 9.Update
        Address updateAddres1 = AddressConnector.AddressId(2);
        Address updateAddres2 = AddressConnector.AddressId(5);
        updateAddres1.setStreet("Zvetaeva");
        updateAddres2.setStreet("Kamenaya");
        AddressConnector.update(updateAddres1);
        AddressConnector.update(updateAddres2);

        // 10.toString
        System.out.println(" - Update -");
        for (Address address : AddressConnector.readAll()){
            System.out.println(address.toString());
        }

        // 11.delete
        AddressConnector.delete(1);
        AddressConnector.delete(3);

        // 12.toString
        System.out.println("- delete -");
        for (Address address : AddressConnector.readAll()){
            System.out.println(address.toString());
        }
    }
}
