package com.github.garethrichings33;

import javax.swing.*;

public class Contact {
    private String firstName;

    private String lastName;
    private String phonenumber;
    private String email;
    private String houseNumber;
    private String street;
    private String town;
    private String postcode;
    private String contactID;

    public Contact (String firstName, String lastName, String houseNumber, String street,
                    String town, String postcode,String phonenumber, String email,
                    String contactID) throws IllegalArgumentException{
        setFirstName(firstName);
        setLastName(lastName);
        setHouseNumber(houseNumber);
        setStreet(street);
        setTown(town);
        setPostcode(postcode);
        setPhonenumber(phonenumber);
        setEmail(email);
        setContactID(contactID);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        final int maxChars = 30;
        if(firstName.length() > maxChars)
            invalidEntryMessage("first name", maxChars);
        else
            this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        final int maxChars = 50;
        if(lastName.length() > maxChars)
            invalidEntryMessage("last name", maxChars);
        else
            this.lastName = lastName;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) throws IllegalArgumentException{
        final int maxChars = 20;
        if(phonenumber.length() > maxChars ||
                (!phonenumber.isBlank() && !phonenumber.matches("^[+,0-9]{1,20}$")))
            invalidEntryMessage("phonenumber", maxChars);
        else
            this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IllegalArgumentException{
        final int maxChars = 100;
        if(email.length() > maxChars || (!email.contains("@") && !email.isBlank()))
            invalidEntryMessage("email address", maxChars);
        else
            this.email = email;
    }

    public String getContactID() {
        return contactID;
    }

    public void setContactID(String contactID) throws IllegalArgumentException{
        final int maxChars = 50;
        if(contactID.length() > maxChars || contactID.isBlank())
            invalidEntryMessage("contact ID", maxChars);
        else
            this.contactID = contactID;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        final int maxChars = 10;
        if(houseNumber.length() > maxChars)
            invalidEntryMessage("house number", maxChars);
        else
            this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        final int maxChars = 100;
        if(street.length() > maxChars)
            invalidEntryMessage("street", maxChars);
        else
            this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        final int maxChars = 50;
        if(town.length() > maxChars)
            invalidEntryMessage("town", maxChars);
        else
            this.town = town;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        final int maxChars = 10;
        if(postcode.length() > maxChars)
            invalidEntryMessage("postcode", maxChars);
        else
            this.postcode = postcode;
    }

    private void invalidEntryMessage(String field, int maxChars) throws IllegalArgumentException{
        String message = "Please enter a valid " + field + "\n(Max. " + maxChars + " characters)" ;
        String title = "Invalid " + field;
        JOptionPane.showMessageDialog(null, message,
                title, JOptionPane.PLAIN_MESSAGE);
        throw new IllegalArgumentException();
    }
}
