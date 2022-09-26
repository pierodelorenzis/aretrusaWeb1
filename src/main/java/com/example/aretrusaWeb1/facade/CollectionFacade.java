package com.example.aretrusaWeb1.facade;

import com.example.aretrusaWeb1.model.Collection;
import com.example.aretrusaWeb1.service.CollectionService;
import com.example.aretrusaWeb1.view.UiCollection;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectionFacade {

    @Autowired
    private CollectionService collectionService;


    //Cerca tutti le UiCollection
    public List<UiCollection> findAll() {
        return collectionService.findAll().stream().map(UiCollection::new).collect(Collectors.toList());
    }

    //Trova le UiCollection per ID
    public ResponseEntity<UiCollection> findById(ObjectId idCollection) {
        final Optional<Collection> byId = collectionService.findById(idCollection);
        if (byId.isPresent()){
            return ResponseEntity.ok(new UiCollection(byId.get()));
        } else {
            return  ResponseEntity.notFound().build();
        }
    }

    //aggiunge una nuova collezione
    public ResponseEntity save(Collection newCollection) {
        return ResponseEntity.ok(collectionService.createCollection(newCollection.getName(), newCollection.getStartYear(), newCollection.getEndYear(), newCollection.getNumBooks()));
    }

    //Elimina una collezione per ID
    public void deleteById(ObjectId idCollection) {
        collectionService.deleteById(idCollection);
    }

    //Modifica una collezione
    public Collection editCollection(ObjectId idCollection, Collection newCollection){
        return collectionService.editCollection(idCollection, newCollection);
    }



}
