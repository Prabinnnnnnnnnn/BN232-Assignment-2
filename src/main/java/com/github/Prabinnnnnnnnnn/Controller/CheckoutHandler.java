package com.github.Prabinnnnnnnnnn.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.github.Prabinnnnnnnnnn.models.Book;
import com.github.Prabinnnnnnnnnn.models.BookCopy;
import com.github.Prabinnnnnnnnnn.models.BookCopyStatus;
import com.github.Prabinnnnnnnnnn.models.Loan;
import com.github.Prabinnnnnnnnnn.models.LoanStatus;
import com.github.Prabinnnnnnnnnn.models.Patron;

// controller for checkout
public class CheckoutHandler {
    private final ArrayList<Loan> loans;
    private final ArrayList<Book> books;
    private final ArrayList<Patron> patrons;
    
    //constructor initialising lists
    public CheckoutHandler() {
        this.loans = new ArrayList<>();
        this.patrons = new ArrayList<>();
        this.books = new ArrayList<>();
    }
    // verfies ID of patron returns boolean value
    public boolean verifyPatronForLoan(int ID) {
        for (Patron patron : patrons) {
            if (patron.getID() == ID) {
                return true;
            }
        }
        return false;
    }

    // checks out book with title and edition
    public void checkoutBook(int ID, String title, String edition) {
        if (!verifyPatronForLoan(ID)) {
            System.out.println("Patron not eligible for loan.");
            return;
        }
        // loops through list until book is found
        Book book = null;
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title) && b.getEdition().equalsIgnoreCase(edition)) {
                book = b;
                break;
            }
        }

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        // finds available copies
        BookCopy availableCopy = null;
        for (BookCopy copy : book.getCopies()) {
            if (copy.getStatus().equals(BookCopyStatus.Available)) {
                availableCopy = copy;
                break;
            }
        }

        if (availableCopy == null) {
            System.out.println("No available copies.");
            return;
        }

        Patron patron = null;
        for (Patron tpatron : patrons) {
            if (tpatron.getID() == ID) {
                patron = tpatron;
            }
        }

        // get next loan id
        int loanID = loans.get(loans.size() - 1).getLoanID() + 1;

        Loan newLoan = new Loan(patron, loanID, new Date(), LoanStatus.Reserved);
//        newLoan.checkoutBook(availableCopy.getCopyNum());
        availableCopy.setStatus(BookCopyStatus.OnLoan);
        loans.add(newLoan);
    }
    // closes loan with ID
    public void closeLoan(int loanID) {
        for (Loan loan : loans) {
            if (loan.getLoanID() == loanID) {
                loan.closeLoan();
                break;
            }
        }
    }
    /*
    * starting process of book return
    * scanner reads input
    */

    public void beginBookReturn() {
         try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter patron ID: ");
            int ID = scanner.nextInt();

            System.out.print("Enter book title: ");
            String title = scanner.nextLine();

            System.out.print("Enter book edition: ");
            String edition = scanner.nextLine();

            returnBook(ID, title, edition);
        }
    }
    
    // returns book with title and edition
    public void returnBook(int ID, String title, String edition) {
        Book book = null;
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title) && b.getEdition().equalsIgnoreCase(edition)) {
                book = b;
                break;
            }
        }

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        // finds loaned copies
        BookCopy returnedCopy = null;
        for (BookCopy copy : book.getCopies()) {
            if (copy.getStatus().equals(BookCopyStatus.OnLoan)) {
                returnedCopy = copy;
                break;
            }
        }

        if (returnedCopy == null) {
            System.out.println("No on-loan copies found.");
            return;
        }
        // updates of loan status and copy
        for (Loan loan : loans) {
            if (loan.getLoanID() == ID && loan.getStatus().equals(LoanStatus.Reserved)) {
                loan.setStatus(LoanStatus.Returned);
                returnedCopy.setStatus(BookCopyStatus.Available);
                break;
            }
        }
    }
    // ends process
    public void endBookReturn() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter patron ID: ");
            int ID = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter book title: ");
            String title = scanner.nextLine();

            System.out.print("Enter book edition: ");
            String edition = scanner.nextLine();
            // finds Loan
            Loan foundLoan = null;
            for (Loan loan : loans) {
                if (loan.getPatron().getID() == ID && loan.getStatus().equals(LoanStatus.Returned)){
                    foundLoan = loan;
                    break;
                }
            }

            if (foundLoan == null) {
                System.out.println("No matching returned loan found.");
                return;
            }
            // sets status
            foundLoan.setStatus(LoanStatus.Returned);
            
            Book book = null;
            for (Book b : books) {
                if (b.getTitle().equalsIgnoreCase(title) && b.getEdition().equalsIgnoreCase(edition)) {
                    book = b;
                    break;
                }
            }
   
            if (book == null) {
                System.out.println("Book not found.");
                return;
            }
            // sets status to available
            for (BookCopy copy : book.getCopies()) {
                if (copy.getStatus().equals(BookCopyStatus.OnLoan)) {
                    copy.setStatus(BookCopyStatus.Available);
                    break;
                }
            }
        }

        System.out.println("Book return process completed.");
    }

        
    }