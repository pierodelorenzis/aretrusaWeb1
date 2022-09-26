package com.example.aretusaWeb1.repository;


import com.example.aretusaWeb1.model.Author;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, ObjectId> {
}
