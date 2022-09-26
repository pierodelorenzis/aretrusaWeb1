package com.example.aretusaWeb1.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Aisle {

    @Id
    private ObjectId idAisle;
    @Indexed
    private String name;


    public Aisle(String name) {
        this.name = name;
    }

    public Aisle() {

    }

    public ObjectId getIdAisle() {
        return idAisle;
    }

    public void setIdAisle(ObjectId idAisle) {
        this.idAisle = idAisle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
