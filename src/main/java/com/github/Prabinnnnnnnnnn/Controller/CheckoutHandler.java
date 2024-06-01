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

    public void closeLoan(int loanID) {
        for (Loan loan : loans) {
            if (loan.getLoanID() == loanID) {
                loan.closeLoan();
                break;
            }
        }
    }

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
            if (copy.getStatus().equals(BookCopyStatus.OnLoan)) {
                returnedCopy = copy;
                break;
            }
        }

        if (returnedCopy == null) {
            System.out.println("No on-loan copies found.");
            return;
        }

        for (Loan loan : loans) {
            if (loan.getLoanID() == ID && loan.getStatus().equals(LoanStatus.Reserved)) {
                loan.setStatus(LoanStatus.Returned);
                returnedCopy.setStatus(BookCopyStatus.Available);
                break;
            }
        }
    }

    public void endBookReturn() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter patron ID: ");
            int ID = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter book title: ");
            String title = scanner.nextLine();

            System.out.print("Enter book edition: ");
            String edition = scanner.nextLine();

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