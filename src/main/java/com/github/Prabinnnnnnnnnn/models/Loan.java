package com.github.Prabinnnnnnnnnn.models;

import java.util.Date;

public class Loan {
    private int loanID;
    private Date dateOfLoan;
    private LoanStatus status;

    public Loan(int loanID, Date dateOfLoan, LoanStatus status) {
        this.loanID = loanID;
        this.dateOfLoan = dateOfLoan;
        this.status = status;
    }

    public void checkoutBook(int bookID) {

    }

    public int getLoanID() {
        return loanID;
    }
    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }

    public Date getDateOfLoan() {
        return dateOfLoan;
    }
    public void setDateOfLoan(Date dateOfLoan) {
        this.dateOfLoan = dateOfLoan;
    }

    public LoanStatus getStatus() {
        return status;
    }
    public void setStatus(LoanStatus status) {
        this.status = status;
    }
}
