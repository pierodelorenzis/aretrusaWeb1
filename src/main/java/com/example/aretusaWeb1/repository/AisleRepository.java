package com.example.aretusaWeb1.repository;


import com.example.aretusaWeb1.model.Aisle;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AisleRepository extends MongoRepository<Aisle, ObjectId> {

}
