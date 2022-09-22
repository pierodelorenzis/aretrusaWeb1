package com.example.aretrusaWeb1.repository;

import com.example.aretrusaWeb1.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

}
