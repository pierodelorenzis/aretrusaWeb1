package com.example.aretrusaWeb1.facade;

import com.example.aretrusaWeb1.model.Author;
import com.example.aretrusaWeb1.model.BookCase;
import com.example.aretrusaWeb1.service.AuthorService;
import com.example.aretrusaWeb1.service.BookcaseService;
import com.example.aretrusaWeb1.view.UiAuthor;
import com.example.aretrusaWeb1.view.UiBookCase;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookcaseFacade {

    @Autowired
    private BookcaseService bookcaseService;


    //Cerca tutti gli UiAutori
    public List<UiBookCase> findAll() {
        return bookcaseService.findAll().stream().map(UiBookCase::new).collect(Collectors.toList());
    }

    //Trova gli UiBookcase per ID
    public ResponseEntity<UiBookCase> findById(ObjectId id) {
        final Optional<BookCase> byId = bookcaseService.findById(id);
        if (byId.isPresent()){
            return ResponseEntity.ok(new UiBookCase(byId.get()));
        } else {
            return  ResponseEntity.notFound().build();
        }
    }

    //aggiunge un nuovo bookcase
    public ResponseEntity save(BookCase newBookcase) {
        return ResponseEntity.ok(bookcaseService.createBookcase(newBookcase.getIdAisle()));
    }

    //Elimina un bookcase per ID
    public void deleteById(ObjectId id) {
        bookcaseService.deleteById(id);
    }

    //Modifica un bookcase
    public BookCase editBookcase(ObjectId id, BookCase newBookcase){
        return bookcaseService.editBookcase(id, newBookcase);
    }

}
