package com.github.garethrichings33;

import javax.swing.*;

public class ContactsBook
{
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ContactsBookGUI();
            }
        });
    }
}
