package com.example.aretusaWeb1.service;

import com.example.aretusaWeb1.model.Genre;
import com.example.aretusaWeb1.repository.GenreRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<Genre> findById(ObjectId idGenre) {
        Optional<Genre> foundGenre = this.genreRepository.findById(idGenre);
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
    public void deleteById(ObjectId idGenre) {
        genreRepository.deleteById(idGenre);
    }

    //Modifica un genere
    public Genre editGenre(ObjectId idGenre, Genre newGenre) {
        return genreRepository.findById(idGenre)
                .map(genre -> {
                    genre.setName(newGenre.getName());
                    return genreRepository.save(genre);
                })
                .orElseGet(() -> {
                    newGenre.setId(idGenre);
                    return genreRepository.save(newGenre);
                });
    }

}

