package com.github.Prabinnnnnnnnnn.models;

import java.util.Date;

public class LoanItem {
    private Date dueDate;
    private Date returnedDate;
    private BookCopy book;

    public LoanItem(Date dueDate, Date returnedDate, BookCopy book) {
        this.dueDate = dueDate;
        this.returnedDate = returnedDate;
        this.book = book;
    }

    public BookCopy getBook() {
        return book;
    }
    public void setBook(BookCopy book) {
        this.book = book;
    }

    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public Date getReturnedDate() {
        return returnedDate;
    }
    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }
}
