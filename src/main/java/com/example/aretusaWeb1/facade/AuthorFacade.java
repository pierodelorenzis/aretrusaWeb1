package com.example.aretusaWeb1.facade;

import com.example.aretusaWeb1.model.Author;
import com.example.aretusaWeb1.service.AuthorService;
import com.example.aretusaWeb1.service.ServiceResult;
import com.example.aretusaWeb1.view.UiAuthor;
import com.example.aretusaWeb1.view.networkUi.BasicResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AuthorFacade {

    @Autowired
    private AuthorService authorService;



    //Cerca tutti gli UiAutori
    public List<UiAuthor> findAll() {
        return authorService.findAll().stream().map(UiAuthor::new).collect(Collectors.toList());
    }

    //Trova gli UiAutori per ID
    public ResponseEntity<UiAuthor> findById(ObjectId id) {
        final Optional<Author> byId = authorService.findById(id);
        if (byId.isPresent()){
            return ResponseEntity.ok(new UiAuthor(byId.get()));
        } else {
            return  ResponseEntity.notFound().build();
        }
    }

    //aggiunge un nuovo autore
    public BasicResponse<UiAuthor> save(UiAuthor newAuthor) throws Exception {
        try {
            ServiceResult<UiAuthor> serviceResult = authorService.createAuthor(newAuthor.name, newAuthor.getLastName());
            if (serviceResult.getErrors()==null)
            {
                return new BasicResponse(200, "author created", serviceResult.getPayload());
            }
            else
            {
                return new BasicResponse(400, serviceResult.getErrors().get(0), null );
            }
        }
        catch (Exception exception)
        {
            return new BasicResponse(400, exception.getMessage() + " errore di facade", null);
        }

    }

    /*
    public BasicResponse<UiAuthor> addAuthor(Author newAuthor)
    {
        Author author = authorService.createAuthor(newAuthor.getName(), newAuthor.getLastName());
        BasicResponse<UiAuthor> response = new BasicResponse<UiAuthor>(200, "ok", author);
    }


     */
    //Elimina un autore per ID
    public void deleteById(ObjectId id) {
        authorService.deleteById(id);
    }

    //Sostituisce un autore
    public Author editAuthor(ObjectId id, Author newAuthor){
        return authorService.editAuthor(id, newAuthor);
    }


    public ResponseEntity<List<UiAuthor>> findByLastname(String lastname) {
        final List<Author> bylastname = authorService.findByLastname(lastname);
        if (bylastname.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(bylastname.stream().map(UiAuthor::new).collect(Collectors.toList()));
        }
    }

    public BasicResponse<List<UiAuthor>> getAuthourWithLastname(String lastname ){
        //ricerchiamo gli autori
        final List<Author> authorsFromDB = authorService.findByLastname(lastname);
        //prepariamo la risposta
        List<UiAuthor> authors = new ArrayList<>();
        authorsFromDB.forEach( author -> {
            authors.add(new UiAuthor(author));
        });
        //incapsliamo la risposta nella response
        return new BasicResponse<>(200,"tutto ok",authors);
    }




}