package com.github.garethrichings33;

import javax.swing.*;

public class ContactFrame {
    protected final JFrame frame;
    protected final JTextField firstNameField;
    protected final JLabel firstNameLabel;
    protected final JTextField lastNameField;
    protected final JLabel lastNameLabel;
    protected final JTextField houseNumberField;
    protected final JLabel houseNumberLabel;
    protected final JTextField streetField;
    protected final JLabel streetLabel;
    protected final JTextField townField;
    protected final JLabel townLabel;
    protected final JTextField postcodeField;
    protected final JLabel postcodeLabel;
    protected final JTextField phoneNumberField;
    protected final JLabel phoneNumberLabel;
    protected final JTextField emailField;
    protected final JLabel emailLabel;
    protected int yPosition;
    protected final int labelWidth;
    protected final int elementHeight;

    public ContactFrame() {
        frame = new JFrame();
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);

        final int xLabel = 20;
        final int xField = 120;
        yPosition = 10;
        labelWidth = 100;
        final int fieldWidth = 250;
        elementHeight = 30;

        firstNameLabel = new JLabel("First Name: ");
        firstNameLabel.setBounds(xLabel, yPosition , labelWidth, elementHeight);
        firstNameField = new JTextField();
        firstNameField.setBounds(xField, yPosition, fieldWidth, elementHeight);
        yPosition += 40;

        lastNameLabel = new JLabel("Last Name: ");
        lastNameLabel.setBounds(xLabel, yPosition , labelWidth, elementHeight);
        lastNameField = new JTextField();
        lastNameField.setBounds(xField, yPosition, fieldWidth, elementHeight);
        yPosition += 40;

        houseNumberLabel = new JLabel("House number: ");
        houseNumberLabel.setBounds(xLabel, yPosition , labelWidth, elementHeight);
        houseNumberField = new JTextField();
        houseNumberField.setBounds(xField, yPosition, fieldWidth, elementHeight);
        yPosition += 40;

        streetLabel = new JLabel("Street: ");
        streetLabel.setBounds(xLabel, yPosition , labelWidth, elementHeight);
        streetField = new JTextField();
        streetField.setBounds(xField, yPosition, fieldWidth, elementHeight);
        yPosition += 40;

        townLabel = new JLabel("Town: ");
        townLabel.setBounds(xLabel, yPosition , labelWidth, elementHeight);
        townField = new JTextField();
        townField.setBounds(xField, yPosition, fieldWidth, elementHeight);
        yPosition += 40;

        postcodeLabel = new JLabel("Postcode: ");
        postcodeLabel.setBounds(xLabel, yPosition , labelWidth, elementHeight);
        postcodeField = new JTextField();
        postcodeField.setBounds(xField, yPosition, fieldWidth, elementHeight);
        yPosition += 40;

        phoneNumberLabel = new JLabel("Phone number: ");
        phoneNumberLabel.setBounds(xLabel, yPosition , labelWidth, elementHeight);
        phoneNumberField = new JTextField();
        phoneNumberField.setBounds(xField, yPosition, fieldWidth, elementHeight);
        yPosition += 40;

        emailLabel = new JLabel("Email address: ");
        emailLabel.setBounds(xLabel, yPosition , labelWidth, elementHeight);
        emailField = new JTextField();
        emailField.setBounds(xField, yPosition, fieldWidth, elementHeight);
        yPosition += 40;

        frame.add(firstNameLabel);
        frame.add(firstNameField);
        frame.add(lastNameLabel);
        frame.add(lastNameField);
        frame.add(houseNumberLabel);
        frame.add(houseNumberField);
        frame.add(streetLabel);
        frame.add(streetField);
        frame.add(townLabel);
        frame.add(townField);
        frame.add(postcodeLabel);
        frame.add(postcodeField);
        frame.add(phoneNumberLabel);
        frame.add(phoneNumberField);
        frame.add(emailLabel);
        frame.add(emailField);
    }
}
