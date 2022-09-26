package com.example.aretusaWeb1.facade;


import com.example.aretusaWeb1.model.Editor;
import com.example.aretusaWeb1.service.EditorService;
import com.example.aretusaWeb1.view.UiEditor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EditorFacade {

    @Autowired
    private EditorService editorService;


    //Cerca tutti gli Editori
    public List<UiEditor> findAll() {
        return editorService.findAll().stream().map(UiEditor::new).collect(Collectors.toList());
    }

    //Trova gli UiEditori per ID
    public ResponseEntity<UiEditor> findById(ObjectId id) {
        final Optional<Editor> byId = editorService.findById(id);
        if (byId.isPresent()){
            return ResponseEntity.ok(new UiEditor(byId.get()));
        } else {
            return  ResponseEntity.notFound().build();
        }
    }

    //aggiunge un nuovo Editore
    public ResponseEntity save(Editor newEditor) {
        return ResponseEntity.ok(editorService.createEditor(newEditor.getName(),newEditor.getCity(),newEditor.getAddress(),newEditor.getTelephone()));
    }

    //Elimina un editore per ID
    public void deleteById(ObjectId id) {
        editorService.deleteById(id);
    }

    //Sostituisce un editore
    public Editor editEditor(ObjectId id, Editor newEditor){
        return editorService.editEditor(id,newEditor);
    }
}

