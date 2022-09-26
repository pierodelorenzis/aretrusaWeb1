package com.example.aretusaWeb1.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Genre {
    @Id
    private ObjectId idGenre;
    @Indexed(unique = true)
    private String name;

    public Genre(String name) {
        this.name = name;
    }

    public Genre (){

    }

    public ObjectId getIdGenre() {
        return idGenre;
    }

    public void setId(ObjectId idGenre) {
        this.idGenre = idGenre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
