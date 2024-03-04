package com.github.garethrichings33;

import javax.swing.*;
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
    Contacts contacts;

    public ContactsBookGUI() {
        contacts = new Contacts();

        setTitle("Contacts Book");
        setSize(new Dimension(400, 400));
        setLayout(new GridLayout(2,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contactListPanel = new JPanel();
        contactListPanel.setLayout(new BorderLayout());
        contactListPane = new JScrollPane(createContactsList());
        contactListPane.setPreferredSize(new Dimension(300, 300));
        contactListPanel.add(contactListPane);
        getContentPane().add(contactListPanel);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        add(controlPanel);
        controlPanel.add(createControlPanel());

//        pack();
//        This line must come after all components have been defined and added to the frame.
        setVisible(true);
    }

    private JList<String> createContactsList() {
        JList<String> list = new JList<>(getIDsList());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return list;
    }

    public void updateContactsList(){
        JList<String> list = new JList<>(getIDsList());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contactListPane = new JScrollPane(list);
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

    private JPanel createControlPanel() {
        var gridLayout = new GridBagLayout();
        var gbc = new GridBagConstraints();

        var panel = new JPanel(gridLayout);
        panel.setBackground(new Color(52, 174, 235));
//        panel.setSize(300, 300);

        addContact = new JButton();
        addContactLabel = "Add Contact";
        addContact.setText(addContactLabel);
        addContact.addActionListener(this);
        addContact.setSize(buttonWidth ,buttonHeight);

        deleteContact = new JButton();
        deleteContactLabel = "Delete Contact";
        deleteContact.setText(deleteContactLabel);
        deleteContact.addActionListener(this);
        deleteContact.setSize(buttonWidth, buttonHeight);
        deleteContact.setEnabled(false);

        displayContact = new JButton();
        displayContactLabel = "Display Contact";
        displayContact.setText(displayContactLabel);
        displayContact.addActionListener(this);
        displayContact.setSize(buttonWidth, buttonHeight);
        displayContact.setEnabled(false);

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

        if(command.equals(addContactLabel)){
            new AddContactFrame(contacts, this);
        }
        else if (command.equals(deleteContact)) {

        }
        else if (command.equals(displayContactLabel)) {
            new ViewContactFrame("Bungle", contacts, this);
        }
    }
}
