package com.example.aretrusaWeb1.service;


import com.example.aretrusaWeb1.model.Author;
import com.example.aretrusaWeb1.model.Book;
import com.example.aretrusaWeb1.repository.BookRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    //Trova tutti i book
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    //Trova i book per id
   public Optional<Book> findById(ObjectId id) {
        Optional<Book> foundBook = this.bookRepository.findById(id);
        return foundBook.isEmpty() ? Optional.empty() : foundBook;
    }

    //Trova libro per isbn
    public List<Book> findByIsbn(String isbn) {
        return bookRepository.findAll().stream().filter(book -> book.getIsbn().equals(isbn)).map(Book::new).collect(Collectors.toList());
    }

    //aggiunge un nuovo book
    public Book createBook(String name, int quantity, String description, int year, ObjectId idCollection, int page, String language, ObjectId idEditor, ObjectId idAuthor, int pegi, float price, float currentPrice, ObjectId idBookcase, ObjectId idAisle, ObjectId idFeeback, boolean sell, int numBorrow) {
        Book toCreate = new Book();
        toCreate.setName(name.trim());
        toCreate.setQuantity(quantity);
        toCreate.setDescription(description.trim());
        toCreate.setYear(year);
        toCreate.setIdCollection(idCollection);
        toCreate.setPage(page);
        toCreate.setLanguage(language);
        toCreate.setIdAuthor(idAuthor);
        toCreate.setIdEditor(idEditor);
        toCreate.setPegi(pegi);
        toCreate.setPrice(price);
        toCreate.setCurrentPrice(currentPrice);
        toCreate.setIdBookcase(idBookcase);
        toCreate.setIdAisle(idAisle);
        toCreate.setIdFeeback(idFeeback);
        toCreate.setSell(sell);
        toCreate.setNumBorrow(numBorrow);
        try {
            this.bookRepository.save(toCreate);
        } catch (Exception e) {
            return null;
        }
        return toCreate;
    }

    //Elimina un book per id
    public void deleteById(ObjectId id) {  bookRepository.deleteById(id); }

    //Modifica un book
    public Book editBook (ObjectId id, Book newBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setName(newBook.getName());
                    book.setQuantity(newBook.getQuantity());
                    book.setDescription(newBook.getDescription());
                    book.setYear(newBook.getYear());
                    book.setIdCollection(newBook.getIdCollection());
                    book.setPage(newBook.getPage());
                    book.setLanguage(newBook.getLanguage());
                    book.setIdEditor(newBook.getIdEditor());
                    book.setIdAuthor(newBook.getIdAuthor());
                    book.setPegi(newBook.getPegi());
                    book.setPrice(newBook.getPrice());
                    book.setCurrentPrice(newBook.getCurrentPrice());
                    book.setIdBookcase(newBook.getIdBookcase());
                    book.setIdAisle(newBook.getIdAisle());
                    book.setIdFeeback(newBook.getIdFeeback());
                    book.setNumBorrow(newBook.getNumBorrow());
                    return bookRepository.save(book);
                })
                .orElseGet(() -> {
                    newBook.setIdBook(id);
                    return bookRepository.save(newBook);
                });
    }
}

