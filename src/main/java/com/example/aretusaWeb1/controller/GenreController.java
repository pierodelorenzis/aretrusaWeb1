package com.example.aretusaWeb1.controller;


import com.example.aretusaWeb1.facade.GenreFacade;
import com.example.aretusaWeb1.model.Genre;
import com.example.aretusaWeb1.view.UIGenre;
import com.example.aretusaWeb1.view.networkUi.BasicResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/genre"})
public class GenreController {
    @Autowired
    private GenreFacade genreFacade;

    //Mostra tutti i generi
    @GetMapping({""})
    public List<UIGenre> all() {
        return this.genreFacade.findAll();
    }

    //Mostra UiGenre per ID inserito
    @GetMapping({"/find/{id}"})
    public BasicResponse<UIGenre> read(@PathVariable("id") ObjectId idGenre) {
        BasicResponse<UIGenre> uiGenreBasicResponse = new BasicResponse<UIGenre>(0, "ok", genreFacade.findById(idGenre).getBody());
        return uiGenreBasicResponse;
    }

    //Aggiungi nuovo genere ricevendo un JSON
    @PostMapping({"/newGenre"})
    public BasicResponse<UIGenre> newGenre(@RequestBody Genre newGenre) {
        BasicResponse<UIGenre> uiGenreBasicResponse = new BasicResponse<UIGenre>(0, "ok", (UIGenre) genreFacade.save(newGenre).getBody());
        return uiGenreBasicResponse;
    }

    //Elimina un genere per ID inserito
    @DeleteMapping("/delete/{id}")
    void deleteGenre(@PathVariable ObjectId idGenre) {genreFacade.deleteById(idGenre);
    }

    //Sostituisce Genere per ID inserito e ricevendo un JSON
    @PutMapping("/edit/{id}")
    Genre editGenre (@RequestBody Genre newGenre, @PathVariable ObjectId idGenre) {
        return genreFacade.editGenre(idGenre,newGenre);
    }

}

