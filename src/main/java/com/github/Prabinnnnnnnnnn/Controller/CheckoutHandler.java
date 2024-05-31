package com.github.Prabinnnnnnnnnn.Controller;

import java.util.ArrayList;
import java.util.Date;

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


    public void checkoutBook(String bookID) {
        //place
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
        // place
    }

    public void returnBook(String bookID) {
        // place
    }

    public void endBookReturn() {
        // place
    }
}