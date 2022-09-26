package com.example.aretusaWeb1.repository;

import com.example.aretusaWeb1.model.Genre;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenreRepository extends MongoRepository<Genre, ObjectId> {

}
