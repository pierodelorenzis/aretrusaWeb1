package com.example.aretrusaWeb1.view;

import com.example.aretrusaWeb1.model.Genre;

public class UIGenre {

    public String name;

    public UIGenre (){

    }

    public UIGenre(Genre genre ) {
        this.name = genre.getName();
    }

    public String getName() {
        return name;
    }


}
