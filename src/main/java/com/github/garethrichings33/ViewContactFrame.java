package com.github.garethrichings33;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViewContactFrame extends ContactFrame implements ActionListener {
    private JButton closeButton;
    private String closeButtonLabel;
    private JButton editButton;
    private String editButtonLabel;
    private JButton saveButton;
    private String saveButtonLabel;
    private JLabel errorMessage;
    private String contactID;
    private Contact contact;
    private Contacts contacts;
    private boolean contactSaved;
    private boolean editButtonPressed;
    private Contact newContact;
    private JPanel controlPanel;

    public ViewContactFrame(String contactID, Contacts contacts, ContactsBookGUI parentFrame) {
        super(parentFrame);
        frame.setTitle("View Contact");

        controlPanel = createControlPanel();
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.1;
        frame.add(controlPanel, gbc);

        frame.addWindowListener(new FrameClosingAdapter());

        this.contactID = contactID;
        this.contacts = contacts;
        this.contact = contacts.getContact(contactID);
        fillFields();
        deactivateFields();
        addCaretListeners();
        contactSaved = true;
        editButtonPressed = false;
    }

    private JPanel createControlPanel() {
        var gridLayout = new GridBagLayout();
        var panel = new JPanel(gridLayout);
        GridBagConstraints gbc;

        editButtonLabel = "Edit";
        editButton = new JButton(editButtonLabel);
        editButton.setFont(buttonFont);
        editButton.addActionListener(this);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(editButton, gbc);

        saveButtonLabel = "Save";
        saveButton = new JButton(saveButtonLabel);
        saveButton.setFont(buttonFont);
        saveButton.addActionListener(this);
        saveButton.setEnabled(false);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(saveButton, gbc);

        closeButtonLabel = "Close";
        closeButton = new JButton(closeButtonLabel);
        closeButton.setFont(buttonFont);
        closeButton.addActionListener(this);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(closeButton, gbc);

        return panel;
    }

    private void addCaretListeners() {
        Caret caret = new Caret();
        firstNameField.addCaretListener(caret);
        lastNameField.addCaretListener(caret);
        houseNumberField.addCaretListener(caret);
        streetField.addCaretListener(caret);
        townField.addCaretListener(caret);
        postcodeField.addCaretListener(caret);
        phoneNumberField.addCaretListener(caret);
        emailField.addCaretListener(caret);
        contactIDField.addCaretListener(caret);
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
        try {
            String newContactID = contactIDField.getText();
            newContact = new Contact(firstNameField.getText(),
                lastNameField.getText(),
                houseNumberField.getText(),
                streetField.getText(),
                townField.getText(),
                postcodeField.getText(),
                phoneNumberField.getText(),
                emailField.getText(),
                newContactID);

            contacts.deleteContact(contactID);
            contacts.addContact(newContactID, newContact);
            removeErrorMessageLabel();
            contactSaved = true;
            saveButton.setEnabled(false);
        }catch(ContactIDExistsException excp){
            addErrorMessageLabel(excp.getMessage());
        }
        catch (IllegalArgumentException excp){}
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if(command.equals(editButtonLabel)){
            activateFields();
            editButtonPressed = true;
            setSaveNeeded();
        }
        else if(command.equals((saveButtonLabel))){
            saveContact();
        }
        else if(command.equals(closeButtonLabel)){
            closeFrame();
        }
    }
    private void setSaveNeeded() {
        saveButton.setEnabled(true);
        contactSaved = false;
    }
    private boolean contactChanged(){
        if(newContact == null)
            return !contactEqualsFields(contact);
        else
            return !contactEqualsFields(newContact);
    }
    private boolean contactEqualsFields(Contact currContact) {
        return firstNameField.getText().equals(currContact.getFirstName()) &&
                lastNameField.getText().equals(currContact.getLastName()) &&
                houseNumberField.getText().equals(currContact.getHouseNumber()) &&
                streetField.getText().equals(currContact.getStreet()) &&
                townField.getText().equals(currContact.getTown()) &&
                postcodeField.getText().equals(currContact.getPostcode()) &&
                phoneNumberField.getText().equals(currContact.getPhonenumber()) &&
                emailField.getText().equals(currContact.getEmail()) &&
                contactIDField.getText().equals(currContact.getContactID());
    }
    private void closeFrame() {
        parentFrame.repaint();
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
    private class FrameClosingAdapter extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            if(!contactSaved)
                checkCloseWithoutSave();
            else
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
        private void checkCloseWithoutSave(){
            int a = JOptionPane.showConfirmDialog(frame,
                    "Close without saving?",
                    "Confirm close",
                    JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION)
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            else
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }
    private class Caret implements CaretListener {
        @Override
        public void caretUpdate(CaretEvent e) {
            if(editButtonPressed && contactChanged())
                setSaveNeeded();
        }
    }
}
