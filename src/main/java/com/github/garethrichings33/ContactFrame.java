package com.github.garethrichings33;

import javax.swing.*;
import java.awt.*;

public class ContactFrame {
    protected final JFrame frame;
    protected final AddressBookGUI parentFrame;
    protected JTextField contactIDField;
    protected JLabel contactIDLabel;
    protected JTextField firstNameField;
    protected JLabel firstNameLabel;
    protected JTextField lastNameField;
    protected JLabel lastNameLabel;
    protected JTextField houseNumberField;
    protected JLabel houseNumberLabel;
    protected JTextField streetField;
    protected JLabel streetLabel;
    protected JTextField townField;
    protected JLabel townLabel;
    protected JTextField postcodeField;
    protected JLabel postcodeLabel;
    protected JTextField phoneNumberField;
    protected JLabel phoneNumberLabel;
    protected JTextField emailField;
    protected JLabel emailLabel;
    private JLabel errorMessage;
    protected int yPosition;
    protected final int elementHeight;
    protected final int extraFrameHeight;
    protected Font buttonFont;
    protected JPanel contactPanel;
    protected GridBagConstraints gbc;
    private Dimension fieldDimension;

    public ContactFrame(AddressBookGUI parentFrame) {
        this.parentFrame = parentFrame;

        buttonFont = new Font("Arial", Font.PLAIN, 14);

        var gridLayout = new GridBagLayout();

        frame = new JFrame();
        frame.setSize(400, 440);
        frame.setLayout(gridLayout);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        extraFrameHeight = 40;

        final int fieldWidth = frame.getWidth() - 150;
        elementHeight = 30;
        fieldDimension = new Dimension(fieldWidth, elementHeight);

        contactPanel = createContactPanel();
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.1;
        frame.add(contactPanel, gbc);

        frame.setVisible(true);
    }

    private JPanel createContactPanel() {
        var gridLayout = new GridBagLayout();
        GridBagConstraints gbcContactPanel;

        var panel = new JPanel(gridLayout);

        firstNameLabel = new JLabel("First Name: ");
        firstNameField = new JTextField();
        firstNameField.setPreferredSize(fieldDimension);

        gbcContactPanel  = new GridBagConstraints();
        gbcContactPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcContactPanel.gridx = 0;
        gbcContactPanel.gridy = 0;
        panel.add(firstNameLabel, gbcContactPanel);

        gbcContactPanel  = new GridBagConstraints();
        gbcContactPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcContactPanel.gridx = 1;
        gbcContactPanel.gridy = 0;
        panel.add(firstNameField, gbcContactPanel);

        lastNameLabel = new JLabel("Last Name: ");
        lastNameField = new JTextField();
        lastNameField.setPreferredSize(fieldDimension);

        gbcContactPanel  = new GridBagConstraints();
        gbcContactPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcContactPanel.gridx = 0;
        gbcContactPanel.gridy = 1;
        panel.add(lastNameLabel, gbcContactPanel);

        gbcContactPanel  = new GridBagConstraints();
        gbcContactPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcContactPanel.gridx = 1;
        gbcContactPanel.gridy = 1;
        panel.add(lastNameField, gbcContactPanel);

        houseNumberLabel = new JLabel("House number: ");
        houseNumberField = new JTextField();
        houseNumberField.setPreferredSize(fieldDimension);

        gbcContactPanel  = new GridBagConstraints();
        gbcContactPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcContactPanel.gridx = 0;
        gbcContactPanel.gridy = 2;
        panel.add(houseNumberLabel, gbcContactPanel);

        gbcContactPanel  = new GridBagConstraints();
        gbcContactPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcContactPanel.gridx = 1;
        gbcContactPanel.gridy = 2;
        panel.add(houseNumberField, gbcContactPanel);

        streetLabel = new JLabel("Street: ");
        streetField = new JTextField();
        streetField.setPreferredSize(fieldDimension);

        gbcContactPanel  = new GridBagConstraints();
        gbcContactPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcContactPanel.gridx = 0;
        gbcContactPanel.gridy = 3;
        panel.add(streetLabel, gbcContactPanel);

        gbcContactPanel  = new GridBagConstraints();
        gbcContactPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcContactPanel.gridx = 1;
        gbcContactPanel.gridy = 3;
        panel.add(streetField, gbcContactPanel);

        townLabel = new JLabel("Town: ");
        townField = new JTextField();
        townField.setPreferredSize(fieldDimension);

        gbcContactPanel  = new GridBagConstraints();
        gbcContactPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcContactPanel.gridx = 0;
        gbcContactPanel.gridy = 4;
        panel.add(townLabel, gbcContactPanel);

        gbcContactPanel  = new GridBagConstraints();
        gbcContactPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcContactPanel.gridx = 1;
        gbcContactPanel.gridy = 4;
        panel.add(townField, gbcContactPanel);

        postcodeLabel = new JLabel("Postcode: ");
        postcodeField = new JTextField();
        postcodeField.setPreferredSize(fieldDimension);

        gbcContactPanel  = new GridBagConstraints();
        gbcContactPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcContactPanel.gridx = 0;
        gbcContactPanel.gridy = 5;
        panel.add(postcodeLabel, gbcContactPanel);

        gbcContactPanel  = new GridBagConstraints();
        gbcContactPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcContactPanel.gridx = 1;
        gbcContactPanel.gridy = 5;
        panel.add(postcodeField, gbcContactPanel);

        phoneNumberLabel = new JLabel("Phone number: ");
        phoneNumberField = new JTextField();
        phoneNumberField.setPreferredSize(fieldDimension);

        gbcContactPanel  = new GridBagConstraints();
        gbcContactPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcContactPanel.gridx = 0;
        gbcContactPanel.gridy = 6;
        panel.add(phoneNumberLabel, gbcContactPanel);

        gbcContactPanel  = new GridBagConstraints();
        gbcContactPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcContactPanel.gridx = 1;
        gbcContactPanel.gridy = 6;
        panel.add(phoneNumberField, gbcContactPanel);

        emailLabel = new JLabel("Email address: ");
        emailField = new JTextField();
        emailField.setPreferredSize(fieldDimension);

        gbcContactPanel  = new GridBagConstraints();
        gbcContactPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcContactPanel.gridx = 0;
        gbcContactPanel.gridy = 7;
        panel.add(emailLabel, gbcContactPanel);

        gbcContactPanel  = new GridBagConstraints();
        gbcContactPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcContactPanel.gridx = 1;
        gbcContactPanel.gridy = 7;
        panel.add(emailField, gbcContactPanel);

        contactIDLabel = new JLabel("Contact ID ");
        contactIDField = new JTextField();
        contactIDField.setPreferredSize(fieldDimension);

        gbcContactPanel  = new GridBagConstraints();
        gbcContactPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcContactPanel.gridx = 0;
        gbcContactPanel.gridy = 8;
        panel.add(contactIDLabel, gbcContactPanel);

        gbcContactPanel  = new GridBagConstraints();
        gbcContactPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcContactPanel.gridx = 1;
        gbcContactPanel.gridy = 8;
        panel.add(contactIDField, gbcContactPanel);

        return panel;
    }

    protected void addErrorMessageLabel(String message){
        if(errorMessage == null) {
            errorMessage = new JLabel(message);
            gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.NONE;
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.weighty = 0.1;
            frame.add(errorMessage, gbc);
        }
        errorMessage.setVisible(true);
        frame.setSize(frame.getWidth(), frame.getHeight()+extraFrameHeight);
    }
    protected void removeErrorMessageLabel(){
        if(errorMessage != null && errorMessage.isVisible()) {
            errorMessage.setVisible(false);
            frame.setSize(frame.getWidth(), frame.getHeight() - extraFrameHeight);
        }
    }
}
