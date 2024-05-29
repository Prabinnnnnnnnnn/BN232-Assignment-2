package com.github.Prabinnnnnnnnnn.models;

import java.util.Date;

public class LoanItem {
    private Date dueDate;
    private Date returnedDate;

    public LoanItem(Date dueDate, Date returnedDate) {
        this.dueDate = dueDate;
        this.returnedDate = returnedDate;
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
