package com.example.aretusaWeb1.repository;

import com.example.aretusaWeb1.model.Feedback;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedbackRepository extends MongoRepository<Feedback, ObjectId> {

}
