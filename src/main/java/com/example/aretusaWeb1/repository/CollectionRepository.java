package com.example.aretusaWeb1.repository;


import com.example.aretusaWeb1.model.Collection;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CollectionRepository extends MongoRepository<Collection, ObjectId> {

}
