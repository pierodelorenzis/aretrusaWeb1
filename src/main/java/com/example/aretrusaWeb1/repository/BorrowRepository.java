package com.example.aretrusaWeb1.repository;


import com.example.aretrusaWeb1.model.Borrow;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BorrowRepository extends MongoRepository<Borrow, ObjectId> {

}
