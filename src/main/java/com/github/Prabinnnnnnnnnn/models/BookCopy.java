package com.github.Prabinnnnnnnnnn.models;

import java.util.Date;

public class BookCopy {
    private int copyNum;
    private BookCopyStatus status;
    private Date dueBack;

    public BookCopy(int copyNum, BookCopyStatus status, Date dueBack) {
        this.copyNum = copyNum;
        this.status = status;
        this.dueBack = dueBack;
    }

    public int getCopyNum() {
        return copyNum;
    }
    public void setCopyNum(int copyNum) {
        this.copyNum = copyNum;
    }

    public BookCopyStatus getStatus() {
        return status;
    }
    public void setStatus(BookCopyStatus status) {
        this.status = status;
    }

    public Date getDueBack() {
        return dueBack;
    }
    public void setDueBack(Date dueBack) {
        this.dueBack = dueBack;
    }
}
