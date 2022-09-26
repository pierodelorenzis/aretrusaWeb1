package com.example.aretusaWeb1.repository;

import com.example.aretusaWeb1.model.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, ObjectId> {

}
