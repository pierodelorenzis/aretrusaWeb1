package com.example.aretrusaWeb1.model;

import org.bson.types.ObjectId;

public class Feedback {
    private ObjectId idFeedback;
    public enum Value {
        VERYGOOD(5),
        GOOD(4),
        NOTSOBAD(3),
        BAD(2),
        VERYBAD(1);

        private int valueState;

        Value (int valueState) {
            this.valueState = valueState;
        }
    }
    private Value value;
    private ObjectId idBook;
    private ObjectId idBorrow;

    public Feedback(ObjectId idFeedback, Value value, ObjectId idBook, ObjectId idBorrow) {
        this.idFeedback = idFeedback;
        this.value = value;
        this.idBook = idBook;
        this.idBorrow = idBorrow;
    }

    public Feedback() {

    }

    public ObjectId getIdFeedback() {
        return idFeedback;
    }

    public Value getValue() {
        return value;
    }

    public ObjectId getIdBook() {
        return idBook;
    }

    public ObjectId getIdBorrow() {
        return idBorrow;
    }

    public void setIdFeedback(ObjectId idFeedback) {
        this.idFeedback = idFeedback;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public void setIdBook(ObjectId idBook) {
        this.idBook = idBook;
    }

    public void setIdBorrow(ObjectId idBorrow) {
        this.idBorrow = idBorrow;
    }
}
