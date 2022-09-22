package com.example.aretrusaWeb1.controller;


import com.example.aretrusaWeb1.facade.EditorFacade;
import com.example.aretrusaWeb1.model.Author;
import com.example.aretrusaWeb1.model.Editor;
import com.example.aretrusaWeb1.view.UiAuthor;
import com.example.aretrusaWeb1.view.UiEditor;
import com.example.aretrusaWeb1.view.networkUi.BasicResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/editor"})
public class EditorController {
    @Autowired
    private EditorFacade editorFacade;

    //Mostra tutti gli editori
    @GetMapping({""})
    public List<UiEditor> all() {
        return this.editorFacade.findAll();
    }

    //Mostra UiEditore per ID inserito
    @GetMapping({"/find/{id}"})
    public BasicResponse<UiEditor> read(@PathVariable("id") ObjectId id) {
        BasicResponse<UiEditor> uiEditorBasicResponse = new BasicResponse<UiEditor>(0, "ok", editorFacade.findById(id).getBody());
        return uiEditorBasicResponse;
    }

    //Aggiungi nuovo editore ricevendo un JSON
    @PostMapping({"/newEditor"})
    public BasicResponse<UiEditor> newEditor(@RequestBody Editor newEditor) {
        BasicResponse<UiEditor> uiEditorBasicResponse = new BasicResponse<UiEditor>(0, "ok", (UiEditor) editorFacade.save(newEditor).getBody());
        return uiEditorBasicResponse;
    }

    //Elimina un editore per ID inserito
    @DeleteMapping("/delete/{id}")
    void deleteEditor(@PathVariable ObjectId id) {editorFacade.deleteById(id);
    }

    //Sostituisce Editore per ID inserito e ricevendo un JSON
    @PutMapping("/edit/{id}")
    Editor editEditor (@RequestBody Editor newEditor, @PathVariable ObjectId id) {
        return editorFacade.editEditor(id,newEditor);
    }

}

