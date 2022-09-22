package com.example.aretrusaWeb1.controller;

import com.example.aretrusaWeb1.facade.AuthorFacade;
import com.example.aretrusaWeb1.model.Author;
import com.example.aretrusaWeb1.view.UiAuthor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/author"})
public class AuthorController {
    @Autowired
    private AuthorFacade authorFacade;

    //Mostra tutti gli autori
    @GetMapping({""})
    public List<UiAuthor> all() {
        return this.authorFacade.findAll();
    }

    //Mostra UiAutore per ID inserito
    @GetMapping({"/find/{id}"})
    public ResponseEntity<UiAuthor> read(@PathVariable("id") ObjectId id) {
        return authorFacade.findById(id);
    }

    //Aggiungi nuovo autore ricevendo un JSON
    @PostMapping({"/newAuthor"})
    public ResponseEntity<Author> newAuthor (@RequestBody Author newAuthor) {
        return this.authorFacade.save(newAuthor);
    }

    //Elimina un autore per ID inserito
    @DeleteMapping("/delete/{id}")
    void deleteAuthor(@PathVariable ObjectId id) {
        authorFacade.deleteById(id);
    }

    //Sostituisce Autore per ID inserito e ricevendo un JSON
    @PutMapping("/edit/{id}")
    Author editAuthor (@RequestBody Author newAuthor, @PathVariable ObjectId id) {
        return authorFacade.editAuthor(id, newAuthor);
    }


}

