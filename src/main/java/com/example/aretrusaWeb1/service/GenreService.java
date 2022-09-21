package com.example.aretrusaWeb1.service;

import com.example.aretrusaWeb1.model.Author;
import com.example.aretrusaWeb1.model.Genre;
import com.example.aretrusaWeb1.repository.AuthorRepository;
import com.example.aretrusaWeb1.repository.GenreRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    //Trova tutti i Generi
    public List<Genre> findAll() {
        return this.genreRepository.findAll();
    }

    //Trova i Generi per ID
    public Optional<Genre> findById(ObjectId id) {
        Optional<Genre> foundGenre = this.genreRepository.findById(id);
        return foundGenre.isEmpty() ? Optional.empty() : foundGenre;
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

