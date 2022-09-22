package com.example.aretrusaWeb1.controller;


import com.example.aretrusaWeb1.facade.BookFacade;
import com.example.aretrusaWeb1.model.Book;
import com.example.aretrusaWeb1.view.UiBook;
import com.example.aretrusaWeb1.view.networkUi.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping({"/book"})
    public class BookController {

        @Autowired
        private BookFacade bookFacade;

        //Mostra tutti i book
        @GetMapping({""})
        public List<UiBook> all() {
            return this.bookFacade.findAll();
        }

        //Mostra UiBook per ID inserito
        @GetMapping({"/find/{isbn}"})
        public BasicResponse<UiBook> read(@PathVariable("isbn") String isbn) {
            BasicResponse<UiBook> uiBookBasicResponse = new BasicResponse<UiBook>(0, "ok", bookFacade.findById(isbn).getBody());
            return uiBookBasicResponse;
        }

        //Aggiungi nuovo book ricevendo un JSON
        @PostMapping({"/newBook"})
        public BasicResponse<UiBook> newBook(@RequestBody Book newBook) {
            BasicResponse<UiBook> uiBookBasicResponse = new BasicResponse<UiBook>(0, "ok", (UiBook) bookFacade.save(newBook).getBody());
            return uiBookBasicResponse;
        }

        //Elimina un book per isbn inserito
        @DeleteMapping("/delete/{isbn}")
        void deleteBook(@PathVariable String isbn) {bookFacade.deleteById(isbn);
        }

        //modifica un book per isbn inserito ricevendo un JSON
        @PutMapping("/edit/{isbn}")
        Book editBook (@RequestBody Book newBook, @PathVariable String isbn) {
            return bookFacade.editBook(isbn, newBook);
        }
}
