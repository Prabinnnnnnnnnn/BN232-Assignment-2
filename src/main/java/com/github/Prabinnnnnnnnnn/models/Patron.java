package com.github.Prabinnnnnnnnnn.models;

import java.util.ArrayList;

public class Patron {
    private int ID;
    private String name;
    private String address;
    private String phone;
    private ArrayList<Loan> loans;

    public Patron(int ID, String name, String address, String phone) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.loans = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return null;
    }

}
