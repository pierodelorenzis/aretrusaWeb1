package com.example.aretrusaWeb1.repository;


import com.example.aretrusaWeb1.model.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, ObjectId> {

}
