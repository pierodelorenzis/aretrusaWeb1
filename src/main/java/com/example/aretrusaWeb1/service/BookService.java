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

    //Trova tutti i book
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    //Trova i book per ISBN
   public Optional<Book> findById(String isbn) {
        Optional<Book> foundBook = this.bookRepository.findById(isbn);
        return foundBook.isEmpty() ? Optional.empty() : foundBook;
    }

    //aggiunge un nuovo book
    public Book createBook(String name, int quantity, String description, int year, int idCollection, int page, int idEditor, int idAuthor, int pegi, float price, float currentPrice, int idBookcase, int idAisle, int idFeeback, boolean sell, int numBorrow) {
        Book toCreate = new Book();
        toCreate.setName(name.trim());
        toCreate.setQuantity(quantity);
        toCreate.setDescription(description.trim());
        toCreate.setYear(year);
        toCreate.setIdCollection(idCollection);
        toCreate.setPage(page);
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

    //Elimina un book per ISBN
    public void deleteById(String isbn) {  bookRepository.deleteById(isbn); }

    //Modifica un book
    public Book editBook (String isbn, Book newBook) {
        return bookRepository.findById(isbn)
                .map(book -> {
                    book.setName(newBook.getName());
                    book.setQuantity(newBook.getQuantity());
                    book.setDescription(newBook.getDescription());
                    book.setYear(newBook.getYear());
                    book.setIdCollection(newBook.getIdCollection());
                    book.setPage(newBook.getPage());
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
                    newBook.setIsbn(isbn);
                    return bookRepository.save(newBook);
                });
    }
}

