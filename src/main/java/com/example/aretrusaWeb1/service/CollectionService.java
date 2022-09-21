package com.example.aretrusaWeb1.service;

import com.example.aretrusaWeb1.model.Aisle;
import com.example.aretrusaWeb1.repository.AisleRepository;
import com.example.aretrusaWeb1.model.Collection
import com.example.aretrusaWeb1.repository.CollectionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
    public Optional<Collection> findById(ObjectId id) {
        Optional<Collection> foundCollection = this.collectionRepository.findById(id);
        return foundCollection.isEmpty() ? Optional.empty() : foundCollection;
    }
}
