package com.example.aretrusaWeb1.repository;


import com.example.aretrusaWeb1.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {

}
