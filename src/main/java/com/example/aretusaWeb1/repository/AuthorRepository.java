package com.example.aretusaWeb1.repository;


import com.example.aretusaWeb1.model.Author;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, ObjectId> {

    List<Author> findBylastName(String lastNameToSearch);

    @Query(value = "{ 'name' : ?0 ,  'lastName' : ?1 }")
    List<Author> findBynameAndlastName(String name, String lastName);

}
