package com.example.aretrusaWeb1.facade;

import com.example.aretrusaWeb1.model.Author;
import com.example.aretrusaWeb1.model.Borrow;
import com.example.aretrusaWeb1.service.BorrowService;
import com.example.aretrusaWeb1.view.UiAuthor;
import com.example.aretrusaWeb1.view.UiBorrow;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BorrowFacade {

    @Autowired
    private BorrowService borrowService;


    //Cerca tutti gli Uiborrow
    public List<UiBorrow> findAll() {
        return borrowService.findAll().stream().map(UiBorrow::new).collect(Collectors.toList());
    }

    //Trova gli UiBorrow per ID
    public ResponseEntity<UiBorrow> findById(ObjectId id) {
        final Optional<Borrow> byId = borrowService.findById(id);
        if (byId.isPresent()){
            return ResponseEntity.ok(new UiBorrow(byId.get()));
        } else {
            return  ResponseEntity.notFound().build();
        }
    }

    //aggiunge un nuovo borrow
    public ResponseEntity save(Borrow newBorrow) {
        return ResponseEntity.ok(borrowService.createBorrow(newBorrow.getStartDate(), newBorrow.getEndDate(), newBorrow.getStartReservation(), newBorrow.getEndReservation(), newBorrow.getIdCustomer(), newBorrow.getIdFeedback()));
    }

    //Elimina un borrow per ID
    public void deleteById(ObjectId id) {
        borrowService.deleteById(id);
    }

    //modifica un borrow
    public Borrow editBorrow(ObjectId id, Borrow newBorrow){
        return borrowService.editBorrow(id, newBorrow);
    }
}
