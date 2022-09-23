package com.example.aretrusaWeb1.facade;


import com.example.aretrusaWeb1.model.Book;
import com.example.aretrusaWeb1.service.BookService;
import com.example.aretrusaWeb1.view.UiBook;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookFacade {

    @Autowired
    private BookService bookService;

    //Cerca tutti i books
    public List<UiBook> findAll() {
        return bookService.findAll().stream().map(UiBook::new).collect(Collectors.toList());
    }

    //Trova i books per ID
    public ResponseEntity<UiBook> findById(ObjectId id) {
        final Optional<Book> byId = bookService.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(new UiBook(byId.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //aggiunge un nuovo book
    public ResponseEntity save(Book newBook) {
        return ResponseEntity.ok(bookService.createBook(newBook.getName(), newBook.getQuantity(), newBook.getDescription(), newBook.getYear(), newBook.getIdCollection(), newBook.getPage(), newBook.getLanguage(), newBook.getIdEditor(), newBook.getIdAuthor(), newBook.getPegi(), newBook.getPrice(), newBook.getCurrentPrice(), newBook.getIdBookcase(), newBook.getIdAisle(), newBook.getIdFeeback(), newBook.isSell(), newBook.getNumBorrow()));
    }

    //Elimina un book per id
    public void deleteById(ObjectId id) {
        bookService.deleteById(id);
    }

    //Modifica un book
    public Book editBook(ObjectId id, Book newBook) {  return bookService.editBook(id, newBook);  }
}









