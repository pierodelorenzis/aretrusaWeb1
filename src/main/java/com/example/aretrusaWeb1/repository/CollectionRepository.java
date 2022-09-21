package com.example.aretrusaWeb1.repository;


import com.example.aretrusaWeb1.model.Collection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CollectionRepository extends MongoRepository<Collection, String> {

}
