package com.example.aretrusaWeb1.repository;

import com.example.aretrusaWeb1.model.Genre;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenreRepository extends MongoRepository<Genre, ObjectId> {

}
