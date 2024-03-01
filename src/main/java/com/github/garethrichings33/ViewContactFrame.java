package com.github.garethrichings33;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ViewContactFrame extends ContactFrame implements ActionListener {
    private final JButton closeButton;
    private final String closeButtonLabel;
    private final JButton editButton;
    private final String editButtonLabel;
    private final JButton saveButton;
    private final String saveButtonLabel;
    private JLabel errorMessage;
    private String contactID;
    private Contact contact;
    private Contacts contacts;
    public ViewContactFrame(String contactID, Contacts contacts) {
        super();
        frame.setTitle("View Contact");

        editButtonLabel = "Edit";
        editButton = new JButton(editButtonLabel);
        editButton.setBounds(20, yPosition, labelWidth, elementHeight);
        editButton.addActionListener(this);
        frame.add(editButton);

        saveButtonLabel = "Save";
        saveButton = new JButton(saveButtonLabel);
        saveButton.setBounds(120, yPosition, labelWidth, elementHeight);
        saveButton.addActionListener(this);
        frame.add(saveButton);

        closeButtonLabel = "Close";
        closeButton = new JButton(closeButtonLabel);
        closeButton.setBounds(220, yPosition, labelWidth, elementHeight);
        closeButton.addActionListener(this);
        frame.add(closeButton);

        this.contactID = contactID;
        this.contacts = contacts;
        this.contact = contacts.getContact(contactID);
        fillFields();
        deactivateFields();
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
        contactIDField.setText(contact.getContactID());
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
        contactIDField.setEditable(false);
    }
    private void activateFields() {
        firstNameField.setEditable(true);
        lastNameField.setEditable(true);
        houseNumberField.setEditable(true);
        streetField.setEditable(true);
        townField.setEditable(true);
        postcodeField.setEditable(true);
        phoneNumberField.setEditable(true);
        emailField.setEditable(true);
        contactIDField.setEditable(true);
    }
    private void saveContact() {
        String newContactID = contactIDField.getText();
        var newContact = new Contact(firstNameField.getText(),
                lastNameField.getText(), houseNumberField.getText(),
                streetField.getText(), townField.getText(),postcodeField.getText(),
                phoneNumberField.getText(),emailField.getText(),newContactID);

        contacts.deleteContact(contactID);
        try {
            contacts.addContact(newContactID, newContact);
            removeErrorMessageLabel();
        }catch(ContactIDExistsException excp){
            addErrorMessageLabel(excp.getMessage());
        }
    }

    private void printContactExistsError() {
        errorMessage = new JLabel("Contact ID already exists. Please provide a new ID.");
        int extraHeight = 40;
        errorMessage.setBounds(20, yPosition+extraHeight, longLabelWidth, elementHeight);
        frame.add(errorMessage);
        frame.setSize(frame.getWidth(), frame.getHeight()+extraHeight);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if(command.equals(editButtonLabel)){
            activateFields();
            contacts.deleteContact(contactID);
        }
        else if(command.equals((saveButtonLabel))){
            deactivateFields();
            saveContact();
        }
        else if(command.equals(closeButtonLabel)){
            saveContact();
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }
}
