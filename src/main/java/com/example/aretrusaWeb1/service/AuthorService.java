package com.example.aretrusaWeb1.service;

import com.example.aretrusaWeb1.model.Author;
import com.example.aretrusaWeb1.repository.AuthorRepository;
import com.example.aretrusaWeb1.view.UiAuthor;
import com.example.aretrusaWeb1.view.networkUi.BasicResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    //Trova tutti gli autori
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    //Trova gli autori per ID
    public Optional<Author> findById(ObjectId id) {
        Optional<Author> foundAuthor = this.authorRepository.findById(id);
        return foundAuthor.isEmpty() ? Optional.empty() : foundAuthor;
    }


    //aggiunge un nuovo autore
    public Author createAuthor(String name, String lastName){
        Author toCreate = new Author();
        toCreate.setName(name.trim());
        toCreate.setLastName(lastName.trim());
        try {
            this.authorRepository.save(toCreate);
        }catch (Exception e){
            return null;
        }
        return toCreate;
    }

    //Elimina un autore
    public void deleteById(ObjectId id) {
        authorRepository.deleteById(id);
    }

    //Sostituisce un autore
    public Author editAuthor(ObjectId id, Author newAuthor) {
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

}

