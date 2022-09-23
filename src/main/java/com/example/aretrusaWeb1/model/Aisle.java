package com.example.aretrusaWeb1.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Aisle {

    @Id
    private ObjectId aisle;
    @Indexed
    private String name;


    public Aisle(String name) {
        this.name = name;
    }

    public Aisle() {

    }

    public ObjectId getAisle() {
        return aisle;
    }

    public void setAisle(ObjectId aisle) {
        this.aisle = aisle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
