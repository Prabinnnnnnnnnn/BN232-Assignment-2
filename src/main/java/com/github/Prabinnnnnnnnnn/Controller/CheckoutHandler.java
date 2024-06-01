package com.github.Prabinnnnnnnnnn.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.github.Prabinnnnnnnnnn.models.*;


public class CheckoutHandler {
    private final ArrayList<Loan> loans;
    private final ArrayList<Book> books;
    private final ArrayList<Patron> patrons;

    public CheckoutHandler() {
        this.loans = new ArrayList<>();
        this.patrons = new ArrayList<>();
        this.books = new ArrayList<>();
    }

    public boolean verifyPatronForLoan(int ID) {
        for (Patron patron : patrons) {
            if (patron.getID() == ID) {
                return true;
            }
        }
        return false;
    }


    public void checkoutBook(int ID, String title, String edition) {
        if (!verifyPatronForLoan(ID)) {
            System.out.println("Patron not eligible for loan.");
            return;
        }

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

        BookCopy availableCopy = null;
        for (BookCopy copy : book.getCopies()) {
            if (copy.getStatus().equals("available")) {
                availableCopy = copy;
                break;
            }
        }

        if (availableCopy == null) {
            System.out.println("No available copies.");
            return;
        }

        Loan newLoan = new Loan(ID, new Date(), "checked out");
        newLoan.checkoutBook(availableCopy.getCopyNum());
        availableCopy.updateStatus("onLoan");
        loans.add(newLoan);
    }

    public void closeLoan(int loanID) {
        for (Loan loan : loans) {
            if (loan.getLoanID() == loanID) {
                loan.closeLoan();
                break;
            }
        }
    }

    public void beginBookReturn() {
         Scanner scanner = new Scanner(System.in);

        System.out.print("Enter patron ID: ");
        int ID = scanner.nextInt();

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter book edition: ");
        String edition = scanner.nextLine();

        returnBook(ID, title, edition);
    }
    

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

        BookCopy returnedCopy = null;
        for (BookCopy copy : book.getCopies()) {
            if (copy.getStatus().equals("onLoan")) {
                returnedCopy = copy;
                break;
            }
        }

        if (returnedCopy == null) {
            System.out.println("No on-loan copies found.");
            return;
        }

        for (Loan loan : loans) {
            if (loan.getLoanID() == ID && loan.getStatus().equals("checked out")) {
                loan.updateStatus("returned");
                returnedCopy.updateStatus("available");
                break;
            }
        }
    }

    public void endBookReturn() {
        // place
    }
}