package com.example.aretrusaWeb1.facade;

import com.example.aretrusaWeb1.model.Author;
import com.example.aretrusaWeb1.service.AuthorService;
import com.example.aretrusaWeb1.view.UiAuthor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AuthorFacade {

    @Autowired
    private AuthorService authorService;


    //Cerca tutti gli UiAutori
    public List<UiAuthor> findAll() {
        return authorService.findAll().stream().map(UiAuthor::new).collect(Collectors.toList());
    }

    //Trova gli UiAutori per ID
    public ResponseEntity<UiAuthor> findById(ObjectId id) {
        final Optional<Author> byId = authorService.findById(id);
        if (byId.isPresent()){
            return ResponseEntity.ok(new UiAuthor(byId.get()));
        } else {
            return  ResponseEntity.notFound().build();
        }
    }

    //aggiunge un nuovo autore
    public ResponseEntity save(Author newAuthor) {
        return ResponseEntity.ok(authorService.createAuthor(newAuthor.getName(), newAuthor.getLastName()));
    }

    //Elimina un autore per ID
    public void deleteById(ObjectId id) {
        authorService.deleteById(id);
    }

    //Sostituisce un autore
    public Author editAuthor(ObjectId id, Author newAuthor){
        return authorService.editAuthor(id, newAuthor);
    }


    public ResponseEntity<List<UiAuthor>> findByLastname(String lastname) {
        final List<Author> bylastname = authorService.findByLastname(lastname);
        if (bylastname.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(bylastname.stream().map(UiAuthor::new).collect(Collectors.toList()));
        }
    }




}

