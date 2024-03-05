package com.github.garethrichings33;

import com.formdev.flatlaf.FlatDarculaLaf;

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
    int contactsPanelWidth = 300;
    int contactsPanelHeight = 300;
    JList<String> contactsList;
    Contacts contacts;

    public ContactsBookGUI() {
        try{
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        }catch(Exception ex){
            System.err.println("Failed to initialise theme. Using fallback.");
        }

        contacts = new Contacts();

        setTitle("Contacts Book");
        setSize(new Dimension(400, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addPanels();

        //        This line must come after all components have been defined and added to the frame.
        setVisible(true);
    }

    private void addPanels() {
        setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();

        createContactsListPanel();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(contactListPanel, gbc);

        createControlPanel();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(controlPanel, gbc);
    }

    private void createContactsListPanel() {
        contactListPanel = new JPanel();
        contactListPanel.setLayout(new BorderLayout());
        contactListPane = new JScrollPane(new JList<String>());
        contactListPane.setPreferredSize(new Dimension(contactsPanelWidth, contactsPanelHeight));
        contactListPanel.add(contactListPane);
    }

    public void updateContactsList(){
        contactsList = new JList<>(getIDsList());
        contactsList.setFont(new Font("Arial", Font.PLAIN, 14));
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
        addUpdatedContactsListToPanel();

        if(contactsList.getModel().getSize() == 0){
            displayContact.setEnabled(false);
            deleteContact.setEnabled(false);
        }
    }

    private void addUpdatedContactsListToPanel() {
        contactListPane = new JScrollPane(contactsList);
        contactListPane.setPreferredSize(new Dimension(contactsPanelWidth, contactsPanelHeight));
        contactListPanel.removeAll();
        contactListPanel.add(contactListPane);
        contactListPanel.repaint();
        contactListPanel.revalidate();
    }

    private DefaultListModel<String> getIDsList(){
        ArrayList<String> idsList = contacts.getAllContactIDs();
        final DefaultListModel<String> list = new DefaultListModel<>();
        for(String id : idsList)
            list.addElement(id);
        return list;
    }

    private void createControlPanel() {
        Font buttonFont = new Font("Arial", Font.PLAIN, 14);
        var gridLayout = new GridBagLayout();
        var gbc = new GridBagConstraints();

        controlPanel = new JPanel(gridLayout);

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
        controlPanel.add(addContact, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        controlPanel.add(deleteContact);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 0;
        controlPanel.add(displayContact);
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
