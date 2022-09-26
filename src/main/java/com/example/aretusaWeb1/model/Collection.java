package com.example.aretusaWeb1.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;



public class Collection {

    @Id
    private ObjectId idCollection;
    private String name;
    private Date startYear;
    private Date endYear;
    private int numBooks;

    public Collection() {
        this.idCollection = idCollection;
        this.name = name;
        this.startYear = startYear;
        this.endYear = endYear;
        this.numBooks = numBooks;
    }


       public ObjectId getIdCollection() {
           return idCollection;
       }

       public void setIdCollection(ObjectId idCollection) {
           this.idCollection = idCollection;
       }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public Date getStartYear() {
           return startYear;
       }

       public void setStartYear(Date startYear) {
           this.startYear = startYear;
       }

       public Date getEndYear() {
           return endYear;
       }

       public void setEndYear(Date endYear) {
           this.endYear = endYear;
       }

       public int getNumBooks() {
           return numBooks;
       }

       public void setNumBooks(int numBooks) {
        this.numBooks = numBooks;
    }
}

