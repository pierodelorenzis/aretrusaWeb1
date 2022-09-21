package com.example.aretrusaWeb1.view;

import com.example.aretrusaWeb1.model.Aisle;
import org.bson.types.ObjectId;

public class UiAisle {

    public ObjectId aisle;


    public UiAisle(Aisle aisle) {
        this.aisle = aisle.getAisle();
    }

    public UiAisle() {
    }

    public ObjectId getAisle() {
        return aisle;
    }

}
