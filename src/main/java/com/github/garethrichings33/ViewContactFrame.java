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
    Contact contact;
    public ViewContactFrame(Contact contact) {
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

        this.contact = contact;
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
        contact.setFirstName(firstNameField.getText());
        contact.setLastName(lastNameField.getText());
        contact.setHouseNumber(houseNumberField.getText());
        contact.setStreet(streetField.getText());
        contact.setTown(townField.getText());
        contact.setPostcode(postcodeField.getText());
        contact.setPhonenumber(phoneNumberField.getText());
        contact.setEmail(emailField.getText());
        contact.setContactID(contactIDField.getText());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if(command.equals(editButtonLabel)){
            activateFields();
        }
        else if(command.equals((saveButtonLabel))){
            deactivateFields();
            saveContact();
        }
        else if(command.equals(closeButtonLabel)){
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }
}
