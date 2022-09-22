package com.example.aretrusaWeb1.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Author {
    @Id
    private ObjectId idAuthor;
    private String name;
    private String lastName;

    public Author(ObjectId idAuthor, String name, String lastName){
        this.idAuthor = idAuthor;
        this.name = name;
        this.lastName = lastName;
    }

    public Author(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }

    public Author() {
    }

    public Author(Author author) {
    }

    public ObjectId getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(ObjectId idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
