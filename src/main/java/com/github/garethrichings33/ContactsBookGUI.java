package com.github.garethrichings33;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ContactsBookGUI extends JFrame implements ActionListener {
//    JFrame frame;
    JScrollPane contactListPane;
    JPanel contactListPanel;
    JPanel controlPanel;
    JButton addContact;
    JButton deleteContact;
    JButton displayContact;
    String addContactLabel;
    String deleteContactLabel;
    String displayContactLabel;
    int buttonHeight = 30;
    int buttonWidth = 150;
    JList<String> contactsList;
    Contacts contacts;
    Color backgroundColour;

    public ContactsBookGUI() {
        contacts = new Contacts();

        backgroundColour = new Color(52, 174, 235);
        setTitle("Contacts Book");
        setSize(new Dimension(400, 400));
        setLayout(new GridLayout(2,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(backgroundColour);

        addcontactsListPanel();
        addcontrolPanel();

        //        This line must come after all components have been defined and added to the frame.
        setVisible(true);
    }

    private void addcontactsListPanel() {
        contactListPanel = new JPanel();
        contactListPanel.setLayout(new BorderLayout());
        contactListPane = new JScrollPane(new JList<String>());
        contactListPane.setPreferredSize(new Dimension(300, 300));
        contactListPanel.add(contactListPane);
        getContentPane().add(contactListPanel);
    }

    private void addcontrolPanel() {
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.setBackground(backgroundColour);
        getContentPane().add(controlPanel);
        controlPanel.add(createControlPanel());
    }

    public void updateContactsList(){
        contactsList = new JList<>(getIDsList());
        contactsList.setFont(new Font("Arial", Font.PLAIN, 14));
        contactsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel select = contactsList.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String id = contactsList.getSelectedValue();
                displayContact.setEnabled(true);
                deleteContact.setEnabled(true);
            }
        });
        contactListPane = new JScrollPane(contactsList);
        contactListPanel.removeAll();
        contactListPanel.add(contactListPane);
        contactListPanel.repaint();
        contactListPanel.revalidate();

        if(contactsList.getModel().getSize() == 0){
            displayContact.setEnabled(false);
            deleteContact.setEnabled(false);
        }

    }

    private DefaultListModel<String> getIDsList(){
        ArrayList<String> idsList = contacts.getAllContactIDs();
        final DefaultListModel<String> list = new DefaultListModel<>();
        for(String id : idsList)
            list.addElement(id);
        return list;
    }

    private JPanel createControlPanel() {
        Font buttonFont = new Font("Arial", Font.PLAIN, 14);
        var gridLayout = new GridBagLayout();
        var gbc = new GridBagConstraints();

        var panel = new JPanel(gridLayout);
        panel.setBackground(backgroundColour);

        addContact = new JButton();
        addContactLabel = "Add Contact";
        addContact.setText(addContactLabel);
        addContact.addActionListener(this);
        addContact.setSize(buttonWidth ,buttonHeight);
        addContact.setFont(buttonFont);

        deleteContact = new JButton();
        deleteContactLabel = "Delete Contact";
        deleteContact.setText(deleteContactLabel);
        deleteContact.addActionListener(this);
        deleteContact.setSize(buttonWidth, buttonHeight);
        deleteContact.setEnabled(false);
        deleteContact.setFont(buttonFont);

        displayContact = new JButton();
        displayContactLabel = "Display Contact";
        displayContact.setText(displayContactLabel);
        displayContact.addActionListener(this);
        displayContact.setSize(buttonWidth, buttonHeight);
        displayContact.setEnabled(false);
        displayContact.setFont(buttonFont);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(addContact, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(deleteContact);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(displayContact);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String id="";

        if(contactsList != null && contactsList.getSelectedIndex() != -1)
            id = contactsList.getSelectedValue();

        if(command.equals(addContactLabel)){
            new AddContactFrame(contacts, this);
        }
        else if (command.equals(deleteContactLabel)) {
            contactDelete(id);
        }
        else if (command.equals(displayContactLabel)) {
            new ViewContactFrame(id, contacts, this);
        }
    }

    private void contactDelete(String id) {
        int a = JOptionPane.showConfirmDialog(this,
                "Really delete contact: " + id + "?",
                "Confirm contact delete",
                JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            contacts.deleteContact(id);
            updateContactsList();
        }
    }
}
