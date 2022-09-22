package com.example.aretrusaWeb1.controller;

import com.example.aretrusaWeb1.facade.BorrowFacade;
import com.example.aretrusaWeb1.model.Borrow;
import com.example.aretrusaWeb1.view.UiBorrow;
import com.example.aretrusaWeb1.view.networkUi.BasicResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping({"/borrow"})
    public class BorrowController {
        @Autowired
        private BorrowFacade borrowFacade;

        //Mostra tutti i borrow
        @GetMapping({""})
        public List<UiBorrow> all() {
            return this.borrowFacade.findAll();
        }

        //Mostra UiBorrow per ID
        @GetMapping({"/find/{id}"})
        public BasicResponse<UiBorrow> read(@PathVariable("id") ObjectId id) {
            BasicResponse<UiBorrow> uiBorrowBasicResponse = new BasicResponse<UiBorrow>(0, "ok", borrowFacade.findById(id).getBody());
            return uiBorrowBasicResponse;
        }

        //Aggiungi nuovo genere ricevendo un JSON
        @PostMapping({"/newBorrow"})
        public BasicResponse<UiBorrow> newBorrow(@RequestBody Borrow newBorrow) {
            BasicResponse<UiBorrow> uiBorrowBasicResponse = new BasicResponse<UiBorrow>(0, "ok", (UiBorrow) borrowFacade.save(newBorrow).getBody());
            return uiBorrowBasicResponse;
        }

        //Elimina un borrow per ID inserito
        @DeleteMapping("/delete/{id}")
        void deleteBorrow(@PathVariable ObjectId id) {borrowFacade.deleteById(id);
        }

        //modifica borrow per ID inserito e ricevendo un JSON
        @PutMapping("/edit/{id}")
        Borrow editBorrow(@RequestBody Borrow newBorrow, @PathVariable ObjectId id) {
            return borrowFacade.editBorrow(id,newBorrow);
        }

    }
