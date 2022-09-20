package com.example.aretrusaWeb1.model;

public class Book {

    private String isbn;
    private String name;
    private int quantity;
    private String description;
    private int year;
    private int idCollection;
    private int page;
    private int idEditor;
    private int idAuthor;
    private int pegi;
    private float price;
    private float currentPrice;
    private int idBookcase;
    private int idAisle;
    private int idFeeback;
    private boolean sell;
    private int numBorrow;

    public Book(String isbn, String name, int quantity, String description, int year, int idCollection, int page, int idEditor, int idAuthor, int pegi, float price, float currentPrice, int idBookcase, int idAisle, int idFeeback, boolean sell, int numBorrow) {
        this.isbn = isbn;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.year = year;
        this.idCollection = idCollection;
        this.page = page;
        this.idEditor = idEditor;
        this.idAuthor = idAuthor;
        this.pegi = pegi;
        this.price = price;
        this.currentPrice = currentPrice;
        this.idBookcase = idBookcase;
        this.idAisle = idAisle;
        this.idFeeback = idFeeback;
        this.sell = sell;
        this.numBorrow = numBorrow;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIdCollection() {
        return idCollection;
    }

    public void setIdCollection(int idCollection) {
        this.idCollection = idCollection;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getIdEditor() {
        return idEditor;
    }

    public void setIdEditor(int idEditor) {
        this.idEditor = idEditor;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public int getPegi() {
        return pegi;
    }

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getIdBookcase() {
        return idBookcase;
    }

    public void setIdBookcase(int idBookcase) {
        this.idBookcase = idBookcase;
    }

    public int getIdAisle() {
        return idAisle;
    }

    public void setIdAisle(int idAisle) {
        this.idAisle = idAisle;
    }

    public int getIdFeeback() {
        return idFeeback;
    }

    public void setIdFeeback(int idFeeback) {
        this.idFeeback = idFeeback;
    }

    public boolean isSell() {
        return sell;
    }

    public void setSell(boolean sell) {
        this.sell = sell;
    }

    public int getNumBorrow() {
        return numBorrow;
    }

    public void setNumBorrow(int numBorrow) {
        this.numBorrow = numBorrow;
    }


}
