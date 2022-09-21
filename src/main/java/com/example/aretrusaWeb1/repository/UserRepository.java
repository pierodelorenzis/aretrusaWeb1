package com.example.aretrusaWeb1.repository;

import com.example.aretrusaWeb1.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

}
