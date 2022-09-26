package com.example.aretrusaWeb1.view;

import com.example.aretrusaWeb1.model.Aisle;
import org.bson.types.ObjectId;

public class UiAisle {

    public ObjectId idAisle;
    public String name;


    public UiAisle(Aisle aisle) {
        this.idAisle = aisle.getIdAisle();
        this.name = aisle.getName();
    }

    public UiAisle() {
    }

    public ObjectId getIdAisle() {
        return idAisle;
    }
    public String getName(){ return  name; }

}
