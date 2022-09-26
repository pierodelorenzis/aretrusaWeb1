package com.example.aretusaWeb1.view;


import com.example.aretusaWeb1.model.Author;

public class UiAuthor {

    public String name;
    public String lastName;

    public UiAuthor(Author author){
        this.name = author.getName();
        this.lastName = author.getLastName();
    }

    public UiAuthor(){

    }

    public String getName() {
        return name;
    }


    public String getLastName() {
        return lastName;
    }

}
