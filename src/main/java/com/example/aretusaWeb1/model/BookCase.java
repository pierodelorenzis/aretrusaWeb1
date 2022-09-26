package com.example.aretusaWeb1.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BookCase {

    @Id
    private ObjectId idBookcase;

    private int number;
    private ObjectId idAisle;

    public BookCase(ObjectId idAisle, int number) {
        this.idAisle = idAisle;
        this.number = number;
    }

    public BookCase() {
    }

    public ObjectId getIdBookcase() {
        return idBookcase;
    }

    public ObjectId getIdAisle() {
        return idAisle;
    }

    public void setIdBookcase(ObjectId idBookcase) {
        this.idBookcase = idBookcase;
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
