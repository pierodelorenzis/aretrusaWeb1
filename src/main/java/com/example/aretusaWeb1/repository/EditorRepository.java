package com.example.aretusaWeb1.repository;

import com.example.aretusaWeb1.model.Editor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EditorRepository extends MongoRepository<Editor, ObjectId> {

}
