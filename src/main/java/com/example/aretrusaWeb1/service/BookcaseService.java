package com.example.aretrusaWeb1.service;


import com.example.aretrusaWeb1.model.Author;
import com.example.aretrusaWeb1.model.BookCase;
import com.example.aretrusaWeb1.repository.BookcaseRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookcaseService {

    @Autowired
    private BookcaseRepository bookcaseRepository;


    //Trova tutti i BookCase
    public List<BookCase> findAll() {
        return this.bookcaseRepository.findAll();
    }


    //Trova i BookCase per ID
    public Optional<BookCase> findById(ObjectId id) {
        Optional<BookCase> foundBookCase = this.bookcaseRepository.findById(id);
         return foundBookCase.isEmpty() ? Optional.empty() : foundBookCase;
    }

    public BookCase createBookcase(ObjectId IdAisle){
        BookCase toCreate = new BookCase();
        toCreate.setIdAisle(IdAisle);
        try {
            this.bookcaseRepository.save(toCreate);
        }catch (Exception e){
            return null;
        }
        return toCreate;
    }

    public BookCase editBookcase(ObjectId id, BookCase newBookcase) {
        return bookcaseRepository.findById(id)
                .map(bookCase -> {
                    bookCase.setIdAisle(newBookcase.getIdAisle());
                    return bookcaseRepository.save(bookCase);
                })
                .orElseGet(() -> {
                    newBookcase.setBookcase(id);
                    return bookcaseRepository.save(newBookcase);
                });
    }

    public void deleteById(ObjectId id) {
        bookcaseRepository.deleteById(id);
    }

}
