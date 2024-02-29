package com.github.garethrichings33;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddContactFrame extends ContactFrame implements ActionListener {
    private Contact contact;
    private Contacts contacts;
    private JButton addButton;
    private String addButtonLabel;

    public AddContactFrame(Contacts contacts) {
        super();

        addButton = new JButton();
        addButtonLabel = "Add";
        addButton.setText(addButtonLabel);
        addButton.setBounds(50, yPosition, labelWidth, elementHeight);
        addButton.addActionListener(this);
        frame.add(addButton);

        this.contacts = contacts;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if(command.equals(addButtonLabel)){
            contact = readContactData();
            contacts.addContact(contact.getFirstName(), contact);
            System.out.println(contact.getFirstName());
//            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
//            var closingEvent = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
//            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);
        }
    }

    private Contact readContactData() {
        System.out.println(firstNameField.isEditable());
        return new Contact(
            firstNameField.getText(),
                lastNameField.getText(),
                houseNumberField.getText(),
                streetField.getText(),
                townField.getText(),
                postcodeField.getText(),
                phoneNumberField.getText(),
                emailField.getText());
    }
}
