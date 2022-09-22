package com.example.aretrusaWeb1.facade;

import com.example.aretrusaWeb1.model.Aisle;
import com.example.aretrusaWeb1.model.Author;
import com.example.aretrusaWeb1.service.AisleService;
import com.example.aretrusaWeb1.service.AuthorService;
import com.example.aretrusaWeb1.view.UiAisle;
import com.example.aretrusaWeb1.view.UiAuthor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AisleFacade {

    @Autowired
    private AisleService aisleService;


    //Cerca tutti i corridoi
    public List<UiAisle> findAll() {
        return aisleService.findAll().stream().map(UiAisle::new).collect(Collectors.toList());
    }

    //Trova gli UiAisle per ID
    public ResponseEntity<UiAisle> findById(ObjectId id) {
        final Optional<Aisle> byId = aisleService.findById(id);
        if (byId.isPresent()){
            return ResponseEntity.ok(new UiAisle(byId.get()));
        } else {
            return  ResponseEntity.notFound().build();
        }
    }

    //aggiunge un nuovo corridoio
    public ResponseEntity save() {
        return ResponseEntity.ok(aisleService.createAisle());
    }

    //Elimina un corridoio per ID
    public void deleteById(ObjectId id) {
        aisleService.deleteById(id);
    }

}

