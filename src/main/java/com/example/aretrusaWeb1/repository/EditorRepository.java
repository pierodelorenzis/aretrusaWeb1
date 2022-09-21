package com.example.aretrusaWeb1.repository;

import com.example.aretrusaWeb1.model.Editor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EditorRepository extends MongoRepository<Editor, ObjectId> {

}
