package com.example.aretrusaWeb1.controller;

import com.example.aretrusaWeb1.facade.BookcaseFacade;
import com.example.aretrusaWeb1.model.BookCase;
import com.example.aretrusaWeb1.view.UiBookCase;
import com.example.aretrusaWeb1.view.networkUi.BasicResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/bookcase"})
public class BookcaseController {
    @Autowired
    private BookcaseFacade bookcaseFacade;

    //Mostra tutti gli bookcase
    @GetMapping({""})
    public List<UiBookCase> all() {
        return this.bookcaseFacade.findAll();
    }

    //Mostra UiBookcase per ID inserito
    @GetMapping({"/find/{id}"})
    public BasicResponse<UiBookCase> read(@PathVariable("id") ObjectId idBookcase) {
        BasicResponse<UiBookCase> uiBookcaseBasicResponse = new BasicResponse<UiBookCase>(0, "ok", bookcaseFacade.findById(idBookcase).getBody());
        return uiBookcaseBasicResponse;
    }

    //Aggiungi nuovo bookcase ricevendo un JSON
    @PostMapping({"/newBookcase"})
    public BasicResponse<UiBookCase> newAuthor(@RequestBody BookCase newBookcase) {
        BasicResponse<UiBookCase> uiBookCaseBasicResponse = new BasicResponse<UiBookCase>(0, "ok", (UiBookCase) bookcaseFacade.save(newBookcase).getBody());
        return uiBookCaseBasicResponse;
    }

    //Elimina un bookcase per ID inserito
    @DeleteMapping("/delete/{id}")
    void deleteBookcase(@PathVariable ObjectId idBookcase) {
        bookcaseFacade.deleteById(idBookcase);
    }

    //Modifica Bookcase per ID inserito e ricevendo un JSON
    @PutMapping("/edit/{id}")
    BookCase editBookcase (@RequestBody BookCase newBookcase, @PathVariable ObjectId idBookcase) {
        return bookcaseFacade.editBookcase(idBookcase, newBookcase);
    }

}

