package com.example.aretrusaWeb1.service;

import com.example.aretrusaWeb1.model.Aisle;
import com.example.aretrusaWeb1.repository.AisleRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AisleService {

    @Autowired
    private AisleRepository aisleRepository;

    //Trova tutti gli autori
    public List<Aisle> findAll() {
        return this.aisleRepository.findAll();
    }

    //Trova gli autori per ID
    public Optional<Aisle> findById(ObjectId id) {
        Optional<Aisle> foundAisle = this.aisleRepository.findById(id);
        return foundAisle.isEmpty() ? Optional.empty() : foundAisle;
    }
}
