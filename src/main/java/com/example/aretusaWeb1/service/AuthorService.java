package com.example.aretusaWeb1.service;

import com.example.aretusaWeb1.aretusaWebApplication;
import com.example.aretusaWeb1.model.Author;
import com.example.aretusaWeb1.repository.AuthorRepository;
import com.example.aretusaWeb1.view.UiAuthor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    public AuthorService() {
        this.authorRepository = aretusaWebApplication.getContext().getBean(AuthorRepository.class);
    }

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
    public ServiceResult<UiAuthor> createAuthor(String name, String lastName) throws Exception {
        Author toCreate = new Author();
        if (name==null || lastName== null)
            throw new Exception("Mandatory field empty");
        List<Author> authors = findByNameAndLastname(name, lastName);
        if (!authors.isEmpty())
            throw new Exception("Entity already exist");


        toCreate.setName(name);
        toCreate.setLastName(lastName);
        try {
            UiAuthor savedUiAuthor = this.authorRepository.save(toCreate).toUiAuthor();
            return new ServiceResult(null, savedUiAuthor);
        }catch (Exception e){
            return new ServiceResult(List.of(e.getMessage()), null);
        }
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


    public List<Author> findByLastname(String lastname) {
        return authorRepository.findBylastName(lastname);
    }

    public List<Author> findByNameAndLastname(String name, String lastname) {
        return authorRepository.findBynameAndlastName(name, lastname);
    }






}

