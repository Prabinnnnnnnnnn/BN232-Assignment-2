package com.github.Prabinnnnnnnnnn.models;

import java.util.Date;

public class Loan {
    private Patron patron;
    private int loanID;
    private Date dateOfLoan;
    private LoanStatus status;
    private LoanItem item;

    public Loan(Patron patron, int loanID, Date dateOfLoan, LoanStatus status, LoanItem item) {
        this.loanID = loanID;
        this.patron = patron;
        this.dateOfLoan = dateOfLoan;
        this.status = status;
        this.item = item;
    }

    public void closeLoan() {
        this.status = LoanStatus.Closed;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public LoanItem getItem() {
        return item;
    }
    public void setItem(LoanItem item) {
        this.item = item;
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
