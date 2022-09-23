package com.example.aretrusaWeb1.view;

import com.example.aretrusaWeb1.model.Aisle;
import org.bson.types.ObjectId;

public class UiAisle {

    public ObjectId aisle;
    public String name;


    public UiAisle(Aisle aisle) {
        this.aisle = aisle.getAisle();
        this.name = aisle.getName();
    }

    public UiAisle() {
    }

    public ObjectId getAisle() {
        return aisle;
    }
    public String getName(){ return  name; }

}
