package com.example.aretrusaWeb1.facade;

import com.example.aretrusaWeb1.model.Genre;
import com.example.aretrusaWeb1.service.GenreService;
import com.example.aretrusaWeb1.view.UIGenre;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GenreFacade {

    @Autowired
    private GenreService genreService;


    //Cerca tutti gli UiGeneri
    public List<UIGenre> findAll() {
        return genreService.findAll().stream().map(UIGenre::new).collect(Collectors.toList());
    }

    //Trova gli UiGeneri per ID
    public ResponseEntity<UIGenre> findById(ObjectId idGenre) {
        final Optional<Genre> byId = genreService.findById(idGenre);
        if (byId.isPresent()){
            return ResponseEntity.ok(new UIGenre(byId.get()));
        } else {
            return  ResponseEntity.notFound().build();
        }
    }

    //aggiunge un nuovo genere
    public ResponseEntity save(Genre newGenre) {
        return ResponseEntity.ok(genreService.createGenre(newGenre.getName()));
    }

    //Elimina un genre per ID
    public void deleteById(ObjectId idGenre) {
        genreService.deleteById(idGenre);
    }

    //Sostituisce un autore
    public Genre editGenre(ObjectId idGenre, Genre newGenre){
        return genreService.editGenre(idGenre, newGenre);
    }
}

