package com.github.garethrichings33;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Contacts {
    private HashMap<String, Contact> contacts;

    public Contacts() {
        contacts = new HashMap<>();
    }

    public void addContact(String contactID, Contact contact) throws ContactIDExistsException {
        if(contactExists(contactID))
            throw new ContactIDExistsException();

        contacts.put(contactID, contact);
    }

    public boolean contactExists(String contactID){
        return contacts.containsKey(contactID);
    }

    public void deleteContact(String contactID){
        contacts.remove(contactID);
    }

    public Contact getContact(String contactID){
        return contacts.get(contactID);
    }

    public ArrayList<String> getAllContactIDs(){
        int numberOfContacts = contacts.size();
        ArrayList<String> contactsList = new ArrayList<>();
        int i = 0;
        for(String contactID : contacts.keySet())
            contactsList.add(contactID);

        Collections.sort(contactsList);

        return contactsList;
    }
}
