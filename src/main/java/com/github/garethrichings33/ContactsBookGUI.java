package com.github.garethrichings33;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactsBookGUI implements ActionListener {
    JFrame frame;
    JButton addContact;
    JButton deleteContact;
    JButton editContact;
    JButton displayContact;
    String addContactLabel;
    String deleteContactLabel;
    String editContactLabel;
    String displayContactLabel;
    Contacts contacts;

    public ContactsBookGUI() {
        frame = new JFrame("Contacts Book");
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        addContact = new JButton();
        addContactLabel = "Add Contact";
        addContact.setText(addContactLabel);
        addContact.addActionListener(this);
        addContact.setBounds(50, 100, 150, 30);

        deleteContact = new JButton();
        deleteContactLabel = "Delete Contact";
        deleteContact.setText(deleteContactLabel);
        deleteContact.addActionListener(this);
        deleteContact.setBounds(50, 150, 150, 30);
        deleteContact.setEnabled(false);

        editContact = new JButton();
        editContactLabel = "Edit Contact";
        editContact.setText(editContactLabel);
        editContact.addActionListener(this);
        editContact.setBounds(50, 200, 150, 30);
        editContact.setEnabled(false);

        displayContact = new JButton();
        displayContactLabel = "Display Contact";
        displayContact.setText(displayContactLabel);
        displayContact.addActionListener(this);
        displayContact.setBounds(50, 250, 150, 30);

        frame.add(addContact);
        frame.add(deleteContact);
        frame.add(editContact);
        frame.add(displayContact);

        contacts = new Contacts();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if(command.equals(addContactLabel)){
            new AddContactFrame(contacts);
        }
        else if (command.equals(deleteContact)) {

        }
        else if (command.equals(editContactLabel)) {

        }
        else if (command.equals(displayContactLabel)) {
            new DisplayContactFrame(contacts.getContact("Bungle"));
        }
    }
}
