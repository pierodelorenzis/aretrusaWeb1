package com.example.aretrusaWeb1.service;

import com.example.aretrusaWeb1.model.Aisle;
import com.example.aretrusaWeb1.model.Borrow;
import com.example.aretrusaWeb1.repository.AisleRepository;
import com.example.aretrusaWeb1.repository.BorrowRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    //Trova tutti i prestiti
    public List<Borrow> findAll() {
        return this.borrowRepository.findAll();
    }

    //Trova i prestiti per ID
    public Optional<Borrow> findById(ObjectId id) {
        Optional<Borrow> foundBorrow = this.borrowRepository.findById(id);
        return foundBorrow.isEmpty() ? Optional.empty() : foundBorrow;
    }
}
