package com.example.aretrusaWeb1.model;


public class BookCase {

    private int bookcase;
    private int idAisle;

    public BookCase(int bookcase, int idAisle) {
        this.bookcase = bookcase;
        this.idAisle = idAisle;
    }

    public int getBookcase() {
        return bookcase;
    }

    public int getIdAisle() {
        return idAisle;
    }

    public void setBookcase(int bookcase) {
        this.bookcase = bookcase;
    }

    public void setIdAisle(int idAisle) {
        this.idAisle = idAisle;
    }
}
