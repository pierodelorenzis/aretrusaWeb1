package com.example.aretrusaWeb1.view;

import com.example.aretrusaWeb1.model.Aisle;

public class UiAisle {

    public int aisle;


    public UiAisle(Aisle aisle) {
        this.aisle = aisle.getAisle();
    }

    public UiAisle() {
    }

    public int getAisle() {
        return aisle;
    }

}
