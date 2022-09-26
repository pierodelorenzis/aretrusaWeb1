package com.example.aretusaWeb1.facade;

import com.example.aretusaWeb1.model.Aisle;
import com.example.aretusaWeb1.service.AisleService;
import com.example.aretusaWeb1.view.UiAisle;
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
    public ResponseEntity<UiAisle> findById(ObjectId idAisle) {
        final Optional<Aisle> byId = aisleService.findById(idAisle);
        if (byId.isPresent()){
            return ResponseEntity.ok(new UiAisle(byId.get()));
        } else {
            return  ResponseEntity.notFound().build();
        }
    }

    //aggiunge un nuovo corridoio
    public ResponseEntity save(Aisle newAisle) {
        return ResponseEntity.ok(aisleService.createAisle(newAisle.getName()));
    }

    //Elimina un corridoio per ID
    public void deleteById(ObjectId idAisle) {
        aisleService.deleteById(idAisle);
    }

}

