package com.example.aretrusaWeb1.service;

import com.example.aretrusaWeb1.model.Book;
import com.example.aretrusaWeb1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    //Trova tutti i libri
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    //Trova i libri per ISBN
    public Optional<Book> findById(String isbn) {
        Optional<Book> foundBook = this.bookRepository.findById(isbn);
        return foundBook.isEmpty() ? Optional.empty() : foundBook;
    }
}
