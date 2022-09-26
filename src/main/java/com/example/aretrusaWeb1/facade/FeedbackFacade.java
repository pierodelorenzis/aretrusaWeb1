package com.example.aretrusaWeb1.facade;

import com.example.aretrusaWeb1.model.Author;
import com.example.aretrusaWeb1.model.Feedback;
import com.example.aretrusaWeb1.service.AuthorService;
import com.example.aretrusaWeb1.service.FeedbackService;
import com.example.aretrusaWeb1.view.UiAuthor;
import com.example.aretrusaWeb1.view.UiFeedback;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FeedbackFacade {

    @Autowired
    private FeedbackService feedbackService;


    //Cerca tutti gli UiFeedback
    public List<UiFeedback> findAll() {
        return feedbackService.findAll().stream().map(UiFeedback::new).collect(Collectors.toList());
    }

    //Trova gli UiFeedback per ID
    public ResponseEntity<UiFeedback> findById(ObjectId id) {
        final Optional<Feedback> byId = feedbackService.findById(id);
        if (byId.isPresent()){
            return ResponseEntity.ok(new UiFeedback(byId.get()));
        } else {
            return  ResponseEntity.notFound().build();
        }
    }

    //aggiunge un nuovo feedback
    public ResponseEntity save(Feedback newFeedback) {
        return ResponseEntity.ok(feedbackService.createFeedback(newFeedback.getValue(), newFeedback.getIdBook(), newFeedback.getIdBorrow()));
    }

    //Elimina un feedback per ID
    public void deleteById(ObjectId id) {
        feedbackService.deleteById(id);
    }

    //Modifica un feeback
    public Feedback editFeedback(ObjectId id, Feedback newFeedback){
        return feedbackService.editFeedback(id, newFeedback);
    }



}
