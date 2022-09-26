package com.example.aretrusaWeb1.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BookCase {

    @Id
    private ObjectId bookcase;

    private int number;
    private ObjectId idAisle;

    public BookCase(ObjectId idAisle, int number) {
        this.idAisle = idAisle;
        this.number = number;
    }

    public BookCase() {
    }

    public ObjectId getBookcase() {
        return bookcase;
    }

    public ObjectId getIdAisle() {
        return idAisle;
    }

    public void setBookcase(ObjectId bookcase) {
        this.bookcase = bookcase;
    }

    public void setIdAisle(ObjectId idAisle) {
        this.idAisle = idAisle;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
