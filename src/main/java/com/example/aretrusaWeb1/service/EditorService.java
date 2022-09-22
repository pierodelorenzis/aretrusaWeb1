package com.example.aretrusaWeb1.service;


import com.example.aretrusaWeb1.model.Editor;
import com.example.aretrusaWeb1.repository.EditorRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EditorService {

    @Autowired
    private EditorRepository editorRepository;

    //Trova tutti gli editori
    public List<Editor> findAll() {
        return this.editorRepository.findAll();
    }

    //Trova gli editori per ID
    public Optional<Editor> findById(ObjectId id) {
        Optional<Editor> foundEditor = this.editorRepository.findById(id);
        return foundEditor.isEmpty() ? Optional.empty() : foundEditor;
    }


    public Editor createEditor(String name,String city,String address,String telephone) {
        Editor toCreate = new Editor();
        toCreate.setName(name.trim());
        toCreate.setCity(city.trim());
        toCreate.setAddress(address.trim());
        toCreate.setTelephone(telephone.trim());
        try {
            this.editorRepository.save(toCreate);
        }catch (Exception e){
            return null;
        }
        return toCreate;
    }

    //Elimina un editore
    public void deleteById(ObjectId id) {
        editorRepository.deleteById(id);
    }
    //Sostituisce un editore
    public Editor editEditor(ObjectId id, Editor newEditor) {
        return editorRepository.findById(id)
                .map(editor -> {
                    editor.setName(newEditor.getName());
                    editor.setCity(newEditor.getCity());
                    editor.setAddress(newEditor.getAddress());
                    editor.setTelephone(newEditor.getTelephone());
                    return newEditor;
                })
                .orElseGet(() -> {
                    newEditor.setIdEditor(id);
                    return editorRepository.save(newEditor);
                });
    }
}

