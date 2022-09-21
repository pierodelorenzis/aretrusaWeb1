package com.example.aretrusaWeb1.repository;

import com.example.aretrusaWeb1.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
