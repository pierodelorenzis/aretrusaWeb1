package com.example.aretrusaWeb1.model;

import org.bson.types.ObjectId;

public class Feedback {
    private ObjectId idFeedback;
    private int value;
    private int idBook;
    private ObjectId idBorrow;

    public Feedback(ObjectId idFeedback, int value, int idBook, ObjectId idBorrow) {
        this.idFeedback = idFeedback;
        this.value = value;
        this.idBook = idBook;
        this.idBorrow = idBorrow;
    }

    public ObjectId getIdFeedback() {
        return idFeedback;
    }

    public int getValue() {
        return value;
    }

    public int getIdBook() {
        return idBook;
    }

    public ObjectId getIdBorrow() {
        return idBorrow;
    }

    public void setIdFeedback(ObjectId idFeedback) {
        this.idFeedback = idFeedback;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public void setIdBorrow(ObjectId idBorrow) {
        this.idBorrow = idBorrow;
    }
}
