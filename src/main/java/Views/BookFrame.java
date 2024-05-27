package Views;

// Import necessary classes for GUI components
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;



public class BookFrame extends JFrame {
    // Declare GUI components for book details and actions
    private JTextField titleField; // Text field for the book title
    private JTextField authorField; // Text field for the author
    private JTextField publisherField; // Text field for the publisher

    private JTextField isbnField; // Text field for the number
    private JTextField publisherYearField; // Text field for the publisher year
    private JButton addButton; // button to add book details
    private JButton deleteButton; // button to  delete book details
    private JButton updateButton; // button to update bok details
    private JList<String> bookList ; // list to display books
    private DefaultListModel<String> bookListModel;// Model for teh book list

    public BookFrame() {
        setTitle("Book Management System"); // set the title of the frame
        setSize(600, 400);// set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// close the application when the frame is closed
        setLocationRelativeTo(null);// centre the frame on the screen
        bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // select one book at a time

        //Initialize text fields
        titleField= new JTextField(20);
        authorField = new JTextField(20);
        publisherField = new JTextField(20);
        isbnField = new JTextField(20);
        publisherYearField = new JTextField(20);


        // initialize buttons
        addButton = new JButton("Add Book");
        deleteButton = new JButton("Delete Book");
        updateButton = new JButton("Update Book");


        // initializing the list model and JList for books
        bookListModel = new DefaultListModel<>();
        bookList = new JList<>(bookListModel);
        bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// allow only single selection

        // Create a panel for input fields and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));// use boxlayout for vertical arrangement

        // Create and add sub-panels for each row of input and output fields and buttons
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.add(new JLabel ("Title"));
        titlePanel.add(titleField);

        JPanel authorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        authorPanel.add(new JLabel ("Author"));
        authorPanel.add(authorField);

        JPanel publisherPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        publisherPanel.add(new JLabel ("Publisher"));
        publisherPanel.add(publisherField);

        JPanel isbnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        isbnPanel.add(new JLabel ("ISBN"));
        isbnPanel.add(isbnField);

        JPanel publisherYearPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        publisherYearPanel.add(new JLabel ("Publisher Year"));
        publisherYearPanel.add(publisherYearField);

        JPanel ButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ButtonPanel.add(addButton);
        ButtonPanel.add(deleteButton);
        ButtonPanel.add(updateButton);

        // add sub panels to the input panel
        inputPanel.add(titlePanel);
        inputPanel.add(authorPanel);
        inputPanel.add(publisherPanel);
        inputPanel.add(isbnPanel);
        inputPanel.add(publisherYearPanel);
        inputPanel.add(ButtonPanel);


        // add the input panel to teh top of the frame
        add(inputPanel, BorderLayout.NORTH);
        // add the book list inside a scroll plane to the centre of the frame
        add(new JScrollPane(bookList), BorderLayout.CENTER);

    }
//Getter methods to access the GUI components
    public JTextField getTitleField() {
        return titleField;
    }
    public JTextField getAuthorField() {
        return authorField;
    }
    public JTextField getPublisherField() {
        return publisherField;

    }
    public JTextField getIsbnField() {
        return isbnField;
    }
    public JTextField getPublisherYearField() {
        return publisherYearField;
    }
    public JButton getAddButton() {
        return addButton;
    }
    public JButton getDeleteButton() {
        return deleteButton;
    }
    public JButton getUpdateButton() {
        return updateButton;
    }
    public JList<String> getBookList() {
        return bookList;
    }
    public DefaultListModel<String> getBookListModel() {
        return bookListModel;
    }



    }






