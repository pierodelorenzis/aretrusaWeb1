package com.example.aretrusaWeb1.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Aisle {

    @Id
    private ObjectId aisle;


    public Aisle(ObjectId aisle) {
        this.aisle = aisle;
    }

    public ObjectId getAisle() {
        return aisle;
    }

    public void setAisle(ObjectId aisle) {
        this.aisle = aisle;
    }
}
