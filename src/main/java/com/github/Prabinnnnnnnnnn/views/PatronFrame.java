package com.github.Prabinnnnnnnnnn.views;

// Import necessary classes for GUI components
import javax.swing.*;
import java.awt.*;

public class PatronFrame extends JFrame {

    // Declare GUI components for patron details and actions
    private final JTextField nameField; // Text field for the patron name
    private final JTextField idField; // Text field for the patron ID
    private final JTextField addressField; // Text field for the patron address
    private final JTextField phoneField; // Text field for the patron phone number
    private final JButton addButton; // Button to add a new patron
    private final JButton updateButton; // Button to update patron details
    private final JButton deleteButton; // Button to delete a patron
    private final JList<String> patronList; // List to display patrons
    private final DefaultListModel<String> listModel; // Model for the patron list

    public PatronFrame() {
        // Set the title of the frame
        setTitle("Patron Management");
        // Set the size of the frame
        setSize(500, 400);
        // Close the application when the frame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Initialize text fields
        nameField = new JTextField(20); // 20 columns wide
        idField = new JTextField(20); // 20 columns wide
        addressField = new JTextField(20); // 20 columns wide
        phoneField = new JTextField(20); // 20 columns wide

        // Initialize buttons
        addButton = new JButton("Add Patron");
        updateButton = new JButton("Update Patron");
        deleteButton = new JButton("Delete Patron");

        // Initialize the list model and the JList for patrons
        listModel = new DefaultListModel<>();
        patronList = new JList<>(listModel);

        // Set the layout manager for the frame
        setLayout(new BorderLayout());

        // Create a panel for input fields and buttons
        JPanel inputPanel = new JPanel();
        // Use a grid layout with 5 rows and 2 columns
        inputPanel.setLayout(new GridLayout(5, 2));

        // Add labels and text fields to the input panel
        inputPanel.add(new JLabel("Name:")); // Label for the name
        inputPanel.add(nameField); // Text field for the name
        inputPanel.add(new JLabel("ID:")); // Label for the ID
        inputPanel.add(idField); // Text field for the ID
        inputPanel.add(new JLabel("Address:")); // Label for the address
        inputPanel.add(addressField); // Text field for the address
        inputPanel.add(new JLabel("Phone:")); // Label for the phone number
        inputPanel.add(phoneField); // Text field for the phone number

        // Add buttons to the input panel
        inputPanel.add(addButton); // Add button
        inputPanel.add(updateButton); // Update button
        inputPanel.add(deleteButton); // Delete button

        // Add the input panel to the north region of the frame
        add(inputPanel, BorderLayout.NORTH);
        // Add the patron list inside a scroll pane to the center of the frame
        add(new JScrollPane(patronList), BorderLayout.CENTER);
    }

    // Getter methods to access the GUI components
    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getIdField() {
        return idField;
    }

    public JTextField getAddressField() {
        return addressField;
    }

    public JTextField getPhoneField() {
        return phoneField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JList<String> getPatronList() {
        return patronList;
    }

    public DefaultListModel<String> getListModel() {
        return listModel;
    }
}
