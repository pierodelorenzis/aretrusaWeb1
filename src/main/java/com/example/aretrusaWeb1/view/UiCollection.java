package com.example.aretrusaWeb1.view;

import com.example.aretrusaWeb1.model.Collection;

import java.util.Date;

public class UiCollection {

    public String name;
    public Date startYear;
    public Date endYear;
    public int numBooks;

    public UiCollection(Collection collection) {
        this.name = collection.getName();
        this.startYear = collection.getStartYear();
        this.endYear = collection.getEndYear();
        this.numBooks = collection.getNumBooks();
    }

    public UiCollection() {
    }

    public String getName() {
        return name;
    }



    public Date getStartYear() {
        return startYear;
    }



    public Date getEndYear() {
        return endYear;
    }

    public int getNumBooks() {
        return numBooks;
    }
}






