package com.example.aretrusaWeb1.model;

import org.bson.types.ObjectId;

public class Feedback {
    private ObjectId idFeedback;
    private int feedback;
    private int idBook;
    private ObjectId idBorrow;

    public Feedback(ObjectId idFeedback, int feedback, int idBook, ObjectId idBorrow) {
        this.idFeedback = idFeedback;
        this.feedback = feedback;
        this.idBook = idBook;
        this.idBorrow = idBorrow;
    }

    public ObjectId getIdFeedback() {
        return idFeedback;
    }

    public int getFeedback() {
        return feedback;
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

    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public void setIdBorrow(ObjectId idBorrow) {
        this.idBorrow = idBorrow;
    }
}
