package com.example.aretrusaWeb1.controller;

import com.example.aretrusaWeb1.facade.AisleFacade;
import com.example.aretrusaWeb1.view.UiAisle;
import com.example.aretrusaWeb1.view.networkUi.BasicResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/aisle"})
public class AisleController {
    @Autowired
    private AisleFacade aisleFacade;

    //Mostra tutti i corridoi
    @GetMapping({""})
    public List<UiAisle> all() {
        return this.aisleFacade.findAll();
    }

    //Mostra UiAisle per ID inserito
    @GetMapping({"/find/{id}"})
    public BasicResponse<UiAisle> read(@PathVariable("id") ObjectId id) {
        BasicResponse<UiAisle> uiAisleBasicResponse = new BasicResponse<UiAisle>(0, "ok", aisleFacade.findById(id).getBody());
        return uiAisleBasicResponse;
    }

    //Aggiungi nuovo autore ricevendo un JSON
    @PostMapping({"/newAisle"})
    public BasicResponse<UiAisle> newAisle() {
        BasicResponse<UiAisle> uiAisleBasicResponse = new BasicResponse<UiAisle>(0, "ok", (UiAisle) aisleFacade.save().getBody());
        return uiAisleBasicResponse;
    }

    //Elimina un corridoio per ID inserito
    @DeleteMapping("/delete/{id}")
    void deleteAisle(@PathVariable ObjectId id) {
        aisleFacade.deleteById(id);
    }

}
