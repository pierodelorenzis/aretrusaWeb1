package com.example.aretusaWeb1.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Book {

    @Id
    private ObjectId idBook;
    @Indexed(unique = true)
    private String isbn;
    private String name;
    private int quantity;
    private String description;
    private int year;
    private ObjectId idCollection;
    private int page;
    private String language;
    private ObjectId idEditor;
    private ObjectId idAuthor;
    private int pegi;
    private float price;
    private float currentPrice;
    private ObjectId idBookcase;
    private ObjectId idAisle;
    private ObjectId idFeeback;
    private boolean sell;
    private int numBorrow;

    public Book() {
        this.isbn = isbn;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.year = year;
        this.idCollection = idCollection;
        this.page = page;
        this.language = language;
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

    public Book(Book book) {
    }

    public ObjectId getIdBook() {
        return idBook;
    }

    public void setIdBook(ObjectId idBook) {
        this.idBook = idBook;
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

    public ObjectId getIdCollection() {
        return idCollection;
    }

    public void setIdCollection(ObjectId idCollection) {
        this.idCollection = idCollection;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public ObjectId getIdEditor() {
        return idEditor;
    }

    public void setIdEditor(ObjectId idEditor) {
        this.idEditor = idEditor;
    }

    public ObjectId getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(ObjectId idAuthor) {
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

    public ObjectId getIdBookcase() {
        return idBookcase;
    }

    public void setIdBookcase(ObjectId idBookcase) {
        this.idBookcase = idBookcase;
    }

    public ObjectId getIdAisle() {
        return idAisle;
    }

    public void setIdAisle(ObjectId idAisle) {
        this.idAisle = idAisle;
    }

    public ObjectId getIdFeeback() {
        return idFeeback;
    }

    public void setIdFeeback(ObjectId idFeeback) {
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
