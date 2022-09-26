package com.example.aretusaWeb1.view;

import com.example.aretusaWeb1.model.Genre;

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
