package com.example.aretusaWeb1.service;

import com.example.aretusaWeb1.model.Feedback;
import com.example.aretusaWeb1.repository.FeedbackRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    //Trova tutti i feedback
    public List<Feedback> findAll() {
        return this.feedbackRepository.findAll();
    }

    //Trova i feedback per ID
    public Optional<Feedback> findById(ObjectId id) {
        Optional<Feedback> foundFeedback = this.feedbackRepository.findById(id);
        return foundFeedback.isEmpty() ? Optional.empty() : foundFeedback;
    }


    //aggiunge un nuovo feedback
    public Feedback createFeedback(Feedback.Value value, ObjectId idBook, ObjectId idBorrow){
        Feedback toCreate = new Feedback();
        toCreate.setValue(value);
        toCreate.setIdBook(idBook);
        toCreate.setIdBorrow(idBorrow);
        try {
            this.feedbackRepository.save(toCreate);
        }catch (Exception e){
            return null;
        }
        return toCreate;
    }

    //Elimina un feedback
    public void deleteById(ObjectId id) {
        feedbackRepository.deleteById(id);
    }

    //Modifica un feedback
    public Feedback editFeedback(ObjectId id, Feedback newFeedback) {
        return feedbackRepository.findById(id)
                .map(feedback -> {
                    feedback.setValue(newFeedback.getValue());
                    feedback.setIdBook(newFeedback.getIdBook());
                    feedback.setIdFeedback(newFeedback.getIdBorrow());
                    return feedbackRepository.save(feedback);
                })
                .orElseGet(() -> {
                    newFeedback.setIdFeedback(id);
                    return feedbackRepository.save(newFeedback);
                });
    }



}
