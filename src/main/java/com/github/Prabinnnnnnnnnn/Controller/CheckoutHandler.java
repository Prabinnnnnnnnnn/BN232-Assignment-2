package com.github.Prabinnnnnnnnnn.Controller;

import java.util.ArrayList;

import com.github.Prabinnnnnnnnnn.models.Loan;

public class CheckoutHandler {
    private final ArrayList<Loan> loans;

    public CheckoutHandler() {
        this.loans = new ArrayList<>();
    }

    public boolean verifyPatronForLoan(String ID) {
        return true;
    }

    public void checkoutBook(String bookID) {
        // place
    }

    public void closeLoan(String loanID) {
        // place
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