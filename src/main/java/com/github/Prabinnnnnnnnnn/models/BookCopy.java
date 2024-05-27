package com.github.Prabinnnnnnnnnn.models;

import java.util.Date;

public class BookCopy {
    private int copyNum;
    private String status;
    private Date dueBack;

    public BookCopy(int copyNum, String status, Date dueBack) {
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

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDueBack() {
        return dueBack;
    }
    public void setDueBack(Date dueBack) {
        this.dueBack = dueBack;
    }
}
