package com.example.aretrusaWeb1.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BookCase {

    @Id
    private ObjectId bookcase;
    private ObjectId idAisle;

    public BookCase(ObjectId idAisle) {
        this.idAisle = idAisle;
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
}
