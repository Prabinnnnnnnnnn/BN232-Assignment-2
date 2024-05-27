package com.github.Prabinnnnnnnnnn.views;

// Import necessary classes for GUI components
import javax.swing.*;
import java.awt.*;

public class BookFrame extends JFrame {

    // Declare GUI components for book details and actions
    private final JTextField titleField; // Text field for the book title
    private final JTextField authorField; // Text field for the author name
    private final JTextField isbnField; // Text field for the ISBN number
    private final JTextField publicationYearField; // Text field for the publication year
    private final JTextField publisherField; // Text field for the publisher
    private final JButton addButton; // Button to add a new book
    private final JButton updateButton; // Button to update book details
    private final JButton deleteButton; // Button to delete a book
    private final JList<String> bookList; // List to display books
    private final DefaultListModel<String> listModel; // Model for the book list

    public BookFrame() {
        // Set the title of the frame
        setTitle("Book Management");
        // Set the size of the frame
        setSize(500, 400);
        // Close the application when the frame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Initialize text fields
        titleField = new JTextField(20); // 20 columns wide
        authorField = new JTextField(20); // 20 columns wide
        isbnField = new JTextField(20); // 20 columns wide
        publicationYearField = new JTextField(20); // 20 columns wide
        publisherField = new JTextField(20); // 20 columns wide

        // Initialize buttons
        addButton = new JButton("Add Book");
        updateButton = new JButton("Update Book");
        deleteButton = new JButton("Delete Book");

        // Initialize the list model and the JList for books
        listModel = new DefaultListModel<>();
        bookList = new JList<>(listModel);
        bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Allow only single selection

        // Create a panel for input fields and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical arrangement

        // Create and add sub-panels for each row of input fields and buttons
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.add(new JLabel("Title:"));
        titlePanel.add(titleField);

        JPanel authorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        authorPanel.add(new JLabel("Author:"));
        authorPanel.add(authorField);

        JPanel isbnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        isbnPanel.add(new JLabel("ISBN:"));
        isbnPanel.add(isbnField);

        JPanel publicationYearPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        publicationYearPanel.add(new JLabel("Publication Year:"));
        publicationYearPanel.add(publicationYearField);

        JPanel publisherPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        publisherPanel.add(new JLabel("Publisher:"));
        publisherPanel.add(publisherField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        // Add sub-panels to the input panel
        inputPanel.add(titlePanel);
        inputPanel.add(authorPanel);
        inputPanel.add(isbnPanel);
        inputPanel.add(publicationYearPanel);
        inputPanel.add(publisherPanel);
        inputPanel.add(buttonPanel);

        // Add the input panel to the top of the frame
        add(inputPanel, BorderLayout.NORTH);
        // Add the book list inside a scroll pane to the center of the frame
        add(new JScrollPane(bookList), BorderLayout.CENTER);
    }

    // Getter methods to access the GUI components
    public JTextField getTitleField() {
        return titleField;
    }

    public JTextField getAuthorField() {
        return authorField;
    }

    public JTextField getIsbnField() {
        return isbnField;
    }

    public JTextField getPublicationYearField() {
        return publicationYearField;
    }

    public JTextField getPublisherField() {
        return publisherField;
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

    public JList<String> getBookList() {
        return bookList;
    }

    public DefaultListModel<String> getListModel() {
        return listModel;
    }
}
