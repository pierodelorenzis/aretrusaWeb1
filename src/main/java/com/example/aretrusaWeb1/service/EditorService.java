package com.example.aretrusaWeb1.service;

import com.example.aretrusaWeb1.model.Editor;
import com.example.aretrusaWeb1.model.Genre;
import com.example.aretrusaWeb1.repository.EditorRepository;
import com.example.aretrusaWeb1.repository.GenreRepository;
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


    /*aggiunge un nuovo autore
    public ResponseEntity save(Author newAuthor) {
        this.authorRepository.save(newAuthor);
        return ResponseEntity.status(201).body(newAuthor);
    }

    //Elimina un autore
    public void deleteById(ObjectId id) {
        authorRepository.deleteById(id);
    }

    //Sostituisce un autore
    public Author substituteAuthor(ObjectId id, Author newAuthor) {
        return authorRepository.findById(id)
                .map(author -> {
                    author.setName(newAuthor.getName());
                    author.setLastName(newAuthor.getLastName());
                    return authorRepository.save(author);
                })
                .orElseGet(() -> {
                    newAuthor.setIdAuthor(id);
                    return authorRepository.save(newAuthor);
                });
    }
*/
}

