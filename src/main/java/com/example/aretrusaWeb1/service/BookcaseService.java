package com.example.aretrusaWeb1.service;

import com.example.aretrusaWeb1.model.Book;
import com.example.aretrusaWeb1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookcaseService {

    @Autowired
    private BookRepository bookRepository;


    //Trova tutti i Libri
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    /*
    //Trova i Libri per ID
    public Optional<Book> findById(String id) {
        Optional<Book> foundBook = this.bookRepository.findById(id);
         return bookRepository.() ? Optional.empty() : foundBook;
    }
    */

}
