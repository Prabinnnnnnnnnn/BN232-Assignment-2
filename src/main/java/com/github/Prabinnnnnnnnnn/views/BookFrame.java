package com.github.Prabinnnnnnnnnn.views;

// Import necessary classes for GUI components

import com.github.Prabinnnnnnnnnn.Controller.NewBookController;
import com.github.Prabinnnnnnnnnn.models.Book;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookFrame extends JFrame {

    // Declare GUI components for book details and actions
    private final JTextField titleField; // Text field for the book title
    private final JTextField authorField; // Text field for the author name
    private final JTextField isbnField; // Text field for the ISBN number
    private final JTextField publicationYearField; // Text field for the publication year
    private final JTextField publisherField; // Text field for the publisher
    private final NewBookController Controller;
    private final JTextField editionField;
    private final JTextField catalogueNumberField;

    private final JButton addButton; // Button to add a new book
    private final JButton updateButton; // Button to update book details
    private final JButton deleteButton; // Button to delete a book
    private final JTable bookList; // List to display books
    private final DefaultTableModel listModel; // Model for the book list

    private void refreshFields() {
        titleField.setText("");
        authorField.setText("");
        isbnField.setText("");
        publisherField.setText("");
        publicationYearField.setText("");
        editionField.setText("");
        catalogueNumberField.setText("");
    }

    private void setFields(String title, String author, String isbn, String publicationYear, String publisher, String edition, String catalogueNumber) {
        titleField.setText(title);
        authorField.setText(author);
        isbnField.setText(isbn);
        publisherField.setText(publisher);
        publicationYearField.setText(publicationYear);
        editionField.setText(edition);
        catalogueNumberField.setText(catalogueNumber);
    }

    public BookFrame(NewBookController Controller) {
        this.Controller = Controller;
        // Set the title of the frame
        setTitle("Book Management");
        // Set the size of the frame
        setSize(500, 400);
        // Close the application when the frame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Initialize text fields
        isbnField = new JTextField(20); // 20 columns wide


        titleField = new JTextField(20); // 20 columns wide
        authorField = new JTextField(20); // 20 columns wide

        editionField = new JTextField(20); // 20 columns wide
        catalogueNumberField = new JTextField(20); // 20 columns wide
        publicationYearField = new JTextField(20); // 20 columns wide
        publisherField = new JTextField(20); // 20 columns wide

        // Initialize buttons
        addButton = new JButton("Add Book");
        updateButton = new JButton("Update Book");
        deleteButton = new JButton("Delete Book");

        // Initialize the list model and the JList for books
        final String[] columns = new String[]{"ISBN", "Title", "Author", "Edition", "Publication Year", "Publisher", "Catalogue"};
        listModel = new DefaultTableModel(columns, 0);
        bookList = new JTable(listModel) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        bookList.setCellSelectionEnabled(false);
        bookList.setRowSelectionAllowed(true);
        bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Allow only single selection

        bookList.getSelectionModel().addListSelectionListener(e -> {

            if (bookList.getSelectedRow() == -1) return;
            if (e.getValueIsAdjusting()) return;

            String title = "";
            String author = "";
            String isbn = "";
            String publicationYear = "";
            String publisher = "";
            String edition = "";
            String catalogueNumber = "";

            for (int i = bookList.getColumnCount() - 1; i >= 0; i--) {
                switch (bookList.getColumnName(i)) {
                    case "ISBN":
                        isbn = bookList.getValueAt(bookList.getSelectedRow(), i).toString();
                    case "Title":
                        title = bookList.getValueAt(bookList.getSelectedRow(), i).toString();
                    case "Author":
                        author = bookList.getValueAt(bookList.getSelectedRow(), i).toString();
                    case "Edition":
                        edition = bookList.getValueAt(bookList.getSelectedRow(), i).toString();
                    case "Publication Year":
                        publicationYear = bookList.getValueAt(bookList.getSelectedRow(), i).toString();
                    case "Publisher":
                        publisher = bookList.getValueAt(bookList.getSelectedRow(), i).toString();
                    case "Catalogue":
                        catalogueNumber = bookList.getValueAt(bookList.getSelectedRow(), i).toString();
                }
            }

            setFields(title, author, isbn, publicationYear, publisher, edition, catalogueNumber);


        });

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

        JPanel editionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        editionPanel.add(new JLabel("Edition:"));
        editionPanel.add(editionField);

        JPanel cataloguePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cataloguePanel.add(new JLabel("Catalogue Number:"));
        cataloguePanel.add(catalogueNumberField);


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
        inputPanel.add(isbnPanel);
        inputPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        inputPanel.add(titlePanel);
        inputPanel.add(authorPanel);
        inputPanel.add(editionPanel);
        inputPanel.add(cataloguePanel);
        inputPanel.add(publicationYearPanel);
        inputPanel.add(publisherPanel);
        inputPanel.add(buttonPanel);

        // Add the input panel to the top of the frame
        add(inputPanel, BorderLayout.NORTH);
        // Add the book list inside a scroll pane to the center of the frame
        add(new JScrollPane(bookList), BorderLayout.CENTER);

        addButton.addActionListener(e -> {
            bookList.clearSelection();
            bookList.getSelectionModel().setValueIsAdjusting(true);


            if (!isbnField.getText().isEmpty() &&
                    !titleField.getText().isEmpty() &&
                    !authorField.getText().isEmpty() &&
                    !editionField.getText().isEmpty() &&
                    !catalogueNumberField.getText().isEmpty() &&
                    !publisherField.getText().isEmpty() &&
                    !publicationYearField.getText().isEmpty()) {

                // All fields are filled, proceed with adding the book
                addBook();

                // Show a success message
                JOptionPane.showMessageDialog(this, "Book created successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Show a message to the user indicating that all fields must be filled
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Incomplete Fields", JOptionPane.WARNING_MESSAGE);
            }
            bookList.getSelectionModel().setValueIsAdjusting(false);

        });


        updateButton.addActionListener(e -> {
            bookList.clearSelection();
            bookList.getSelectionModel().setValueIsAdjusting(true);
            if (!isbnField.getText().isEmpty() &&
                    !titleField.getText().isEmpty() &&
                    !authorField.getText().isEmpty() &&
                    !editionField.getText().isEmpty() &&
                    !catalogueNumberField.getText().isEmpty() &&
                    !publisherField.getText().isEmpty() &&
                    !publicationYearField.getText().isEmpty()) {

                // All fields are filled, proceed with adding the book
                updateBook();

                // Show a success message
                JOptionPane.showMessageDialog(this, "Book updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Show a message to the user indicating that all fields must be filled
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Incomplete Fields", JOptionPane.WARNING_MESSAGE);
            }
            bookList.getSelectionModel().setValueIsAdjusting(false);

        });


        deleteButton.addActionListener(e -> {
            bookList.clearSelection();
            bookList.getSelectionModel().setValueIsAdjusting(true);

            if (!isbnField.getText().isEmpty()) {
                deleteBook();
                JOptionPane.showMessageDialog(this, "Book deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Incomplete Fields", JOptionPane.WARNING_MESSAGE);
            }
            bookList.getSelectionModel().setValueIsAdjusting(false);

        });


    }

    private void deleteBook() {
        Controller.getBooks().forEach(book -> {
            if (book.getIsbn().equals(isbnField.getText())) {
                Controller.deleteBook(book);
            }
        });
        updateBookList();
        refreshFields();
    }

    private void updateBook() {
        Controller.getBooks().forEach(book -> {
            if (book.getIsbn().equals(isbnField.getText())) {
                book.setAuthor(authorField.getText());
                book.setEdition(editionField.getText());
                book.setTitle(titleField.getText());
                book.setPublisher(publisherField.getText());
                book.setIsbn(isbnField.getText());
                book.setPubYear(publicationYearField.getText());
                book.setCatalogueNumber(catalogueNumberField.getText());
            }
        });
        updateBookList();
        refreshFields();
    }

    private void addBook() {
        Controller.createNewBook(titleField.getText(), authorField.getText(), editionField.getText(), publicationYearField.getText(), isbnField.getText(), publisherField.getText(), catalogueNumberField.getText());
        updateBookList();
        refreshFields();
    }

    private void updateBookList() {
        listModel.setRowCount(0);
        Controller.getBooks().forEach(book -> {
            Object[] temp = new Object[]{book.getIsbn(), book.getTitle(), book.getAuthor(), book.getEdition(), book.getPubYear(), book.getPublisher(), book.getCatalogueNumber()};
            listModel.addRow(temp);
        });
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

    public JTable getBookList() {
        return bookList;
    }

    public DefaultTableModel getListModel() {
        return listModel;
    }

    public NewBookController getController() {
        return Controller;
    }

    public JTextField getEditionField() {
        return editionField;
    }

    public JTextField getCatalogueNumberField() {
        return catalogueNumberField;
    }
}
