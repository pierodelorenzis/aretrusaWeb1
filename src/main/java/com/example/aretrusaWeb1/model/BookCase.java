package com.example.aretrusaWeb1.model;


import org.bson.types.ObjectId;

public class BookCase {

    private ObjectId bookcase;
    private ObjectId idAisle;

        public BookCase(ObjectId bookcase, ObjectId idAisle) {
        this.bookcase = bookcase;
        this.idAisle = idAisle;
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
