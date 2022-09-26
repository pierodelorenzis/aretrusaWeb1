package com.example.aretusaWeb1.service;


import com.example.aretusaWeb1.model.BookCase;
import com.example.aretusaWeb1.repository.BookcaseRepository;
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
    public Optional<BookCase> findById(ObjectId idBookcase) {
        Optional<BookCase> foundBookCase = this.bookcaseRepository.findById(idBookcase);
         return foundBookCase.isEmpty() ? Optional.empty() : foundBookCase;
    }

    public BookCase createBookcase(ObjectId IdAisle, int number){
        BookCase toCreate = new BookCase();
        toCreate.setIdAisle(IdAisle);
        toCreate.setNumber(number);
        try {
            this.bookcaseRepository.save(toCreate);
        }catch (Exception e){
            return null;
        }
        return toCreate;
    }

    public BookCase editBookcase(ObjectId idBookcase, BookCase newBookcase) {
        return bookcaseRepository.findById(idBookcase)
                .map(bookCase -> {
                    bookCase.setIdAisle(newBookcase.getIdAisle());
                    return bookcaseRepository.save(bookCase);
                })
                .orElseGet(() -> {
                    newBookcase.setIdBookcase(idBookcase);
                    return bookcaseRepository.save(newBookcase);
                });
    }

    public void deleteById(ObjectId idBookcase) {
        bookcaseRepository.deleteById(idBookcase);
    }

}
