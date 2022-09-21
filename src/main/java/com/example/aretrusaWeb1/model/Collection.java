package com.example.aretrusaWeb1.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;



public class Collection {

    @Id
    private ObjectId id;
    private String name;
    private Date startYear;
    private Date endYear;
    private Integer numBooks;

    public Collection(ObjectId id, String name, Date startYear, Date endYear, Integer numBooks) {
        this.id = id;
        this.name = name;
        this.startYear = startYear;
        this.endYear = endYear;
        this.numBooks = numBooks;
    }


       public ObjectId getId() {
           return id;
       }

       public void setId(ObjectId id) {
           this.id = id;
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

       public Integer getNumBooks() {
           return numBooks;
       }

       public void setNumBooks(Integer numBooks) {
        this.numBooks = numBooks;
    }
}

