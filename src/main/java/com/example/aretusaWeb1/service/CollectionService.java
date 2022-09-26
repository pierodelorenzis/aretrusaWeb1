package com.example.aretusaWeb1.service;

import com.example.aretusaWeb1.model.Collection;
import com.example.aretusaWeb1.repository.CollectionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CollectionService {

    @Autowired
    private CollectionRepository collectionRepository;

    //Trova tutte le collezioni
    public List<Collection> findAll() {
        return this.collectionRepository.findAll();
    }

    //Trova le collezioni per ID
    public Optional<Collection> findById(ObjectId idCollection) {
        Optional<Collection> foundCollection = this.collectionRepository.findById(idCollection);
        return foundCollection.isEmpty() ? Optional.empty() : foundCollection;
    }

    //aggiunge una nuova collezione
    public Collection createCollection(String name, Date startYear, Date endYear, int numBooks){
        Collection toCreate = new Collection();
        toCreate.setName(name.trim());
        toCreate.setStartYear(startYear);
        toCreate.setEndYear(endYear);
        toCreate.setNumBooks(numBooks);
        try {
            this.collectionRepository.save(toCreate);
        }catch (Exception e){
            return null;
        }
        return toCreate;
    }

    //Elimina una collezione
    public void deleteById(ObjectId idCollection) {
        collectionRepository.deleteById(idCollection);
    }

    //Modifica una collezione
    public Collection editCollection(ObjectId idCollection, Collection newCollection) {
        return collectionRepository.findById(idCollection)
                .map(collection -> {
                    collection.setName(newCollection.getName());
                    collection.setEndYear(newCollection.getStartYear());
                    collection.setEndYear(newCollection.getEndYear());
                    collection.setNumBooks(newCollection.getNumBooks());
                    return collectionRepository.save(collection);
                })
                .orElseGet(() -> {
                    newCollection.setIdCollection(idCollection);
                    return collectionRepository.save(newCollection);
                });
    }
}
