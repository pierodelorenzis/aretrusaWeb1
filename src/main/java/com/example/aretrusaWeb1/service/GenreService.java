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


    //aggiunge un nuovo Genere
    public Genre createGenre(String name) {
        Genre toCreate = new Genre();
        toCreate.setName(name.trim());
        try {
            this.genreRepository.save(toCreate);
        }catch (Exception e){
            return null;
        }
        return toCreate;
    }

    //Elimina un Genere
    public void deleteById(ObjectId id) {
        genreRepository.deleteById(id);
    }

    //Modifica un genere
    public Genre editGenre(ObjectId id, Genre newGenre) {
        return genreRepository.findById(id)
                .map(genre -> {
                    genre.setName(newGenre.getName());
                    return genreRepository.save(genre);
                })
                .orElseGet(() -> {
                    newGenre.setId(id);
                    return genreRepository.save(newGenre);
                });
    }

}

