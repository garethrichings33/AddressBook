package com.github.garethrichings33;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class AddContactFrame extends ContactFrame implements ActionListener {
    private Contact contact;
    private Contacts contacts;
    private JButton addButton;
    private String addButtonLabel;

    public AddContactFrame(Contacts contacts, ContactsBookGUI parentFrame) {
        super(parentFrame);
        frame.setTitle("Add Contact");

        firstNameField.addCaretListener(new Caret());

        addButton = new JButton();
        addButtonLabel = "Add";
        addButton.setFont(buttonFont);
        addButton.setText(addButtonLabel);
//        addButton.setBounds(20, yPosition, labelWidth, elementHeight);
        addButton.addActionListener(this);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty= 0.1;
        frame.add(addButton, gbc);

        this.contacts = contacts;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if(command.equals(addButtonLabel)){
            try {
                contact = readContactData();
                contacts.addContact(contact.getContactID(), contact);
                parentFrame.updateContactsList();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
            catch (ContactIDExistsException excp){
                addErrorMessageLabel(excp.getMessage());
            }
            catch (IllegalArgumentException excp){}
        }
    }

    private Contact readContactData() throws IllegalArgumentException{

        return new Contact(
            firstNameField.getText(),
                lastNameField.getText(),
                houseNumberField.getText(),
                streetField.getText(),
                townField.getText(),
                postcodeField.getText(),
                phoneNumberField.getText(),
                emailField.getText(),
                contactIDField.getText());
    }

    private class Caret implements CaretListener {
        @Override
        public void caretUpdate(CaretEvent e) {
            contactIDField.setText(firstNameField.getText());
        }
    }
}
