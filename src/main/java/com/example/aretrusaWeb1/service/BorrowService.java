package com.example.aretrusaWeb1.service;

import com.example.aretrusaWeb1.model.Borrow;
import com.example.aretrusaWeb1.model.Genre;
import com.example.aretrusaWeb1.repository.BorrowRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    //aggiunge un nuovo borrow
    public Borrow createBorrow(Date startDate, Date endDate, Date startReservation, Date endReservation, int idCustomer, int idFeedback) {
        Borrow toCreate = new Borrow();
        toCreate.setStartDate(startDate);
        toCreate.setEndDate(endDate);
        toCreate.setStartReservation(startReservation);
        toCreate.setEndReservation(endReservation);
        toCreate.setIdCustomer(idCustomer);
        toCreate.setIdFeedback(idFeedback);
        try {
            this.borrowRepository.save(toCreate);
        }catch (Exception e){
            return null;
        }
        return toCreate;
    }

    //Elimina un borrow
    public void deleteById(ObjectId id) {
        borrowRepository.deleteById(id);
    }

    //Modifica un borrow
    public Borrow editBorrow (ObjectId id, Borrow newBorrow) {
        return borrowRepository.findById(id)
                .map(borrow -> {
                    borrow.setStartDate(newBorrow.getStartDate());
                    borrow.setEndDate(newBorrow.getEndDate());
                    borrow.setStartReservation(newBorrow.getStartReservation());
                    borrow.setEndReservation(newBorrow.getEndReservation());
                    borrow.setIdCustomer(newBorrow.getIdCustomer());
                    borrow.setIdFeedback(newBorrow.getIdFeedback());

                    return borrowRepository.save(borrow);
                })
                .orElseGet(() -> {
                    newBorrow.setIdBorrow(id);
                    return borrowRepository.save(newBorrow);
                });
    }
}
