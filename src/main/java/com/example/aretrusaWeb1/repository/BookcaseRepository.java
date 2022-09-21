package com.example.aretrusaWeb1.repository;

import com.example.aretrusaWeb1.model.BookCase;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookcaseRepository extends MongoRepository<BookCase, ObjectId> {

}
