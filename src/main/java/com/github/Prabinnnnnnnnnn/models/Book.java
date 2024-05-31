package com.github.Prabinnnnnnnnnn.models;

import java.util.ArrayList;

/**
 * Book contains and controls all information for a single {@code Book} instance.
 */
public class Book {
    /**
     * The title of the book
     */
    private String title;
    /**
     * The author of the book
     */
    private String author;
    /**
     * The edition number of the book
     */
    private String edition;
    /**
     * The publishing year of the book
     */
    private String pubYear;
    /**
     * The ISBN of the book
     */
    private String isbn;
    /**
     * The publisher of the book
     */
    private String publisher;
    /**
     * The internal catalogue number for the book
     */
    private int catalogueNumber;

    private ArrayList<BookCopy> copies;

    public Book(String title, String author, String edition, String pubYear, String isbn, String publisher, int catalogueNumber) {
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.pubYear = pubYear;
        this.isbn = isbn;
        this.publisher = publisher;
        this.catalogueNumber = catalogueNumber;
        this.copies = new ArrayList<>();
    }

    public Book returnBook() {
        return this;
    }

    public boolean checkForExisting(String title) {
        return this.title.equals(title);
    }

    public boolean checkForEdition(String title, String author) {
        return this.title.equals(title) && this.author.equals(author);
    }

    public void createNewCopy(BookCopy copy) {
        copies.add(copy);
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getEdition() {
        return edition;
    }
    public String getPubYear() {
        return pubYear;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getPublisher() {
        return publisher;
    }
    public int getCatalogueNumber() {
        return catalogueNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setEdition(String edition) {
        this.edition = edition;
    }
    public void setPubYear(String pubYear) {
        this.pubYear = pubYear;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setCatalogueNumber(int catalogueNumber) {
        this.catalogueNumber = catalogueNumber;
    }
}