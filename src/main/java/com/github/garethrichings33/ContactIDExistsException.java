package com.github.garethrichings33;

public class ContactIDExistsException extends Exception{
    public ContactIDExistsException() {
        super("Contact ID already exists. Please provide a new ID.");
    }
}
