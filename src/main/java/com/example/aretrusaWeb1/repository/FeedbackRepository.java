package com.example.aretrusaWeb1.repository;

import com.example.aretrusaWeb1.model.Feedback;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedbackRepository extends MongoRepository<Feedback, ObjectId> {

}
