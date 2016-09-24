package com.thomasjamesdev.thomas.sharedelementanimation;

import java.io.Serializable;

/**
 * Created by Thomas on 22/09/2016.
 */

public class Person {

    String firstName, lastName, address, phoneNumber;

    public Person(String fName, String lName,String addy,String pNumber){
        firstName = fName;
        lastName = lName;
        address = addy;
        phoneNumber = pNumber;

    }

    public static final String ADDRESS_PREFIX = "Address: ";
    public static final String PHONE_PREFIX = "Phone: ";


}
