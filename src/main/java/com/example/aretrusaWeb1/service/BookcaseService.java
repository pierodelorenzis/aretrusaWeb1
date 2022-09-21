package com.example.aretrusaWeb1.service;

import com.example.aretrusaWeb1.model.BookCase;
import com.example.aretrusaWeb1.repository.BookcaseRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookcaseService {

    @Autowired
    private BookcaseRepository bookcaseRepository;

    //Trova tutti gli scaffali
    public List<BookCase> findAll() {
        return this.bookcaseRepository.findAll();
    }

    //Trova gli scaffali per ID
    public Optional<BookCase> findById(ObjectId id) {
        Optional<BookCase> foundBookcase = this.bookcaseRepository.findById(id);
        return foundBookcase.isEmpty() ? Optional.empty() : foundBookcase;
    }
}
