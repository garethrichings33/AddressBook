package com.github.garethrichings33;

import java.util.HashMap;

public class Contacts {
    private HashMap<String, Contact> contacts;

    public Contacts() {
        contacts = new HashMap<>();
    }

    public void addContact(String contactName, Contact contact){
        contacts.put(contactName, contact);
    }

    public void deleteContact(String contactName){
        contacts.remove(contactName);
    }

    public Contact getContact(String contactName){
        return contacts.get(contactName);
    }
}
