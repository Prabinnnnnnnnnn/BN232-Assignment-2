
package com.github.Prabinnnnnnnnnn;

import com.github.Prabinnnnnnnnnn.models.Book;
import com.github.Prabinnnnnnnnnn.views.BookFrame;
import com.github.Prabinnnnnnnnnn.views.PatronFrame;
import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class Main {
    /**
     * list of all books added.
     */
    public ArrayList<Book> Books = new ArrayList<>();


    public static void main(String[] args) {
        // Create and display the BookFrame on the event dispatching thread
        SwingUtilities.invokeLater(() -> {
            BookFrame bookFrame = new BookFrame();
            bookFrame.setVisible(true); // Make the BookFrame visible
        });

        // Create and display the PatronFrame on the event dispatching thread
        SwingUtilities.invokeLater(() -> {
            PatronFrame patronFrame = new PatronFrame();
            patronFrame.setVisible(true); // Make the PatronFrame visible
        });
    }
}
