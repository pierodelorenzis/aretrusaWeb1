package com.example.aretusaWeb1.controller;

import com.example.aretusaWeb1.facade.AuthorFacade;
import com.example.aretusaWeb1.model.Author;
import com.example.aretusaWeb1.view.UiAuthor;
import com.example.aretusaWeb1.view.networkUi.BasicResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
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
    public BasicResponse<UiAuthor> read(@PathVariable("id") ObjectId id) {
        BasicResponse<UiAuthor> uiAuthorBasicResponse = new BasicResponse<UiAuthor>(0, "ok", authorFacade.findById(id).getBody());
        return uiAuthorBasicResponse;
    }

    //Aggiungi nuovo autore ricevendo un JSON
    @PostMapping({"/newAuthor"})
    public BasicResponse<UiAuthor> newAuthor(@RequestBody UiAuthor newAuthor) throws Exception {
        return authorFacade.save(newAuthor);
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


    @GetMapping({"/get/{lastname}"})
    public BasicResponse<List<UiAuthor>> read(@PathVariable("lastname") String lastname) {
        return authorFacade.getAuthourWithLastname(lastname);
    }



}

