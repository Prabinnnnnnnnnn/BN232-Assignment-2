package com.github.Prabinnnnnnnnnn.views;

// Import necessary classes for GUI components
import javax.swing.*;
import java.awt.*;

public class LoanFrame extends JFrame {

    // Declare GUI components for loan details and actions
    private final JTextField IsbnField; // Text field for the loan item
    private final JTextField PatronIDField; // Text field for who owns the loan
    private final JTextField startDateField; // Text field for the loan start date
    private final JTextField endDateField; // Text field for the loan end date
    private final JTextField statusField; // Text field for the loan status
    private final JButton addButton; // Button to add a new loan
    private final JButton updateButton; // Button to update loan details
    private final JButton deleteButton; // Button to delete a loan
    private final JList<String> loanList; // List to display loans
    private final DefaultListModel<String> listModel; // Model for the loan list

    public LoanFrame() {
        // Set the title of the frame
        setTitle("Loan Management");
        // Set the size of the frame
        setSize(500, 400);
        // Close the application when the frame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Initialize text fields
        IsbnField = new JTextField(20); // 20 columns wide
        PatronIDField = new JTextField(20); // 20 columns wide
        startDateField = new JTextField(20); // 20 columns wide
        endDateField = new JTextField(20); // 20 columns wide
        statusField = new JTextField(20); // 20 columns wide

        // Initialize buttons
        addButton = new JButton("Add Loan");
        updateButton = new JButton("Update Loan");
        deleteButton = new JButton("Delete Loan");

        // Initialize the list model and the JList for loans
        listModel = new DefaultListModel<>();
        loanList = new JList<>(listModel);
        loanList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Allow only single selection

        // Create a panel for input fields and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical arrangement

        // Create and add sub-panels for each row of input fields and buttons
        JPanel IsbnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        IsbnPanel.add(new JLabel("ISBN NUMBER:"));
        IsbnPanel.add(IsbnField);

        JPanel PatronIDPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        PatronIDPanel.add(new JLabel("Patron ID:"));
        PatronIDPanel.add(PatronIDField);

        JPanel startDatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        startDatePanel.add(new JLabel("Start Date:"));
        startDatePanel.add(startDateField);

        JPanel endDatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        endDatePanel.add(new JLabel("End Date:"));
        endDatePanel.add(endDateField);

        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusPanel.add(new JLabel("Status:"));
        statusPanel.add(statusField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        // Add sub-panels to the input panel

        inputPanel.add(IsbnPanel);
        inputPanel.add(PatronIDPanel);
        inputPanel.add(startDatePanel);
        inputPanel.add(endDatePanel);
        inputPanel.add(statusPanel);
        inputPanel.add(buttonPanel);

        // Add the input panel to the top of the frame
        add(inputPanel, BorderLayout.NORTH);
        // Add the loan list inside a scroll pane to the center of the frame
        add(new JScrollPane(loanList), BorderLayout.CENTER);

        // Action listeners for buttons
        addButton.addActionListener(e -> {
            if (!IsbnField.getText().isEmpty() &&
                    !PatronIDField.getText().isEmpty() &&
                    !startDateField.getText().isEmpty() &&
                    !endDateField.getText().isEmpty() &&
                    !statusField.getText().isEmpty()) {

                // Add loan logic here (you can modify this part based on your backend)
                String Isbn = IsbnField.getText();
                String PatronID = PatronIDField.getText();
                String startDate = startDateField.getText();
                String endDate = endDateField.getText();
                String status = statusField.getText();

                // Add to list model
                listModel.addElement(String.format("Isbn number: %s, Patron ID: %s, Start: %s, End: %s, Status: %s", Isbn, PatronID, startDate, endDate, status));

                // Show a success message
                JOptionPane.showMessageDialog(this, "Loan created successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Refresh fields
                refreshFields();
            } else {
                // Show a message to the user indicating that all fields must be filled
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Incomplete Fields", JOptionPane.WARNING_MESSAGE);
            }
        });

        updateButton.addActionListener(e -> {
            int selectedIndex = loanList.getSelectedIndex();
            if (selectedIndex != -1 && !IsbnField.getText().isEmpty() &&
                    !PatronIDField.getText().isEmpty() &&
                    !startDateField.getText().isEmpty() &&
                    !endDateField.getText().isEmpty() &&
                    !statusField.getText().isEmpty()) {

                // Update loan logic here (you can modify this part based on your backend)
                String Isbn = IsbnField.getText();
                String PatronID = PatronIDField.getText();
                String startDate = startDateField.getText();
                String endDate = endDateField.getText();
                String status = statusField.getText();

                // Update list model
                listModel.set(selectedIndex, String.format("Isbn number : %s, Patron ID: %s, Start: %s, End: %s, Status: %s", Isbn, PatronID, startDate, endDate, status));

                // Show a success message
                JOptionPane.showMessageDialog(this, "Loan updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Refresh fields
                refreshFields();
            } else {
                // Show a message to the user indicating that a loan must be selected and all fields must be filled
                JOptionPane.showMessageDialog(this, "Please select a loan and fill in all fields.", "Incomplete Fields", JOptionPane.WARNING_MESSAGE);
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedIndex = loanList.getSelectedIndex();
            if (selectedIndex != -1) {
                // Delete loan logic here (you can modify this part based on your backend)

                // Remove from list model
                listModel.remove(selectedIndex);

                // Show a success message
                JOptionPane.showMessageDialog(this, "Loan deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Refresh fields
                refreshFields();
            } else {
                // Show a message to the user indicating that a loan must be selected
                JOptionPane.showMessageDialog(this, "Please select a loan to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Listener to fill fields when a loan is clicked
        loanList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && loanList.getSelectedIndex() != -1) {
                String selectedLoan = loanList.getSelectedValue();
                fillFieldsWithLoan(selectedLoan);
            }
        });
    }

    // Method to refresh the input fields
    private void refreshFields() {
        IsbnField.setText("");
        PatronIDField.setText("");
        startDateField.setText("");
        endDateField.setText("");
        statusField.setText("");
    }

    // Method to fill the input fields with loan details
    private void fillFieldsWithLoan(String loanDetails) {
        // Assuming loanDetails are formatted as "Item: item, Owner: owner, Start: start, End: end, Status: status"
        String[] details = loanDetails.split(", ");
        IsbnField.setText(details[0].split(": ")[1]);
        PatronIDField.setText(details[1].split(": ")[1]);
        startDateField.setText(details[2].split(": ")[1]);
        endDateField.setText(details[3].split(": ")[1]);
        statusField.setText(details[4].split(": ")[1]);
    }



    }

