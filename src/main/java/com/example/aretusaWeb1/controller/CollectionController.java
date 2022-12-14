package com.example.aretusaWeb1.controller;

import com.example.aretusaWeb1.facade.CollectionFacade;
import com.example.aretusaWeb1.model.Collection;
import com.example.aretusaWeb1.view.UiCollection;
import com.example.aretusaWeb1.view.networkUi.BasicResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/collection"})
public class CollectionController {

    @Autowired
    private CollectionFacade collectionFacade;

    //Mostra tutte le collezioni
    @GetMapping({""})
    public List<UiCollection> all() {
        return this.collectionFacade.findAll();
    }

    //Mostra UiCollection per ID inserito
    @GetMapping({"/find/{id}"})
    public BasicResponse<UiCollection> read(@PathVariable("id") ObjectId idCollection) {
        BasicResponse<UiCollection> uiCollectionBasicResponse = new BasicResponse<UiCollection>(0, "ok", collectionFacade.findById(idCollection).getBody());
        return uiCollectionBasicResponse;
    }

    //Aggiungi nuova collezione ricevendo un JSON
    @PostMapping({"/newCollection"})
    public BasicResponse<UiCollection> newCollection(@RequestBody Collection newCollection) {
        BasicResponse<UiCollection> uiCollectionBasicResponse= new BasicResponse<UiCollection>(0, "ok", (UiCollection) collectionFacade.save(newCollection).getBody());
        return uiCollectionBasicResponse;
    }

    //Elimina una collezione per ID inserito
    @DeleteMapping("/delete/{id}")
    void deleteCollection(@PathVariable ObjectId idCollection) {
        collectionFacade.deleteById(idCollection);
    }

    //Modifica Collection per ID inserito e ricevendo un JSON
    @PutMapping("/edit/{id}")
    Collection editCollection (@RequestBody Collection newCollection, @PathVariable ObjectId idCollection) {
        return collectionFacade.editCollection(idCollection, newCollection);
    }
}
