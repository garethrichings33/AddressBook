package com.github.garethrichings33;

import java.util.HashMap;

public class Contacts {
    private HashMap<String, Contact> contacts;

    public Contacts() {
        contacts = new HashMap<>();
    }

    public void addContact(String contactID, Contact contact){
        contacts.put(contactID, contact);
    }

    public void deleteContact(String contactID){
        contacts.remove(contactID);
    }

    public Contact getContact(String contactID){
        return contacts.get(contactID);
    }
}
