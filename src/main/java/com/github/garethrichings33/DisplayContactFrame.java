package com.github.garethrichings33;

public class DisplayContactFrame extends ContactFrame{
    Contact contact;
    public DisplayContactFrame(Contact contact) {
        super();
        this.contact = contact;
        fillFields();
        deactivateFields();
    }

    private void deactivateFields() {
        firstNameField.setEditable(false);
        lastNameField.setEditable(false);
        houseNumberField.setEditable(false);
        streetField.setEditable(false);
        townField.setEditable(false);
        postcodeField.setEditable(false);
        phoneNumberField.setEditable(false);
        emailField.setEditable(false);
    }

    private void fillFields() {
        firstNameField.setText(contact.getFirstName());
        lastNameField.setText(contact.getLastName());
        houseNumberField.setText(contact.getHouseNumber());
        streetField.setText(contact.getStreet());
        townField.setText(contact.getTown());
        postcodeField.setText(contact.getPostcode());
        phoneNumberField.setText(contact.getPhonenumber());
        emailField.setText(contact.getEmail());
    }
}
