package com.example.aretrusaWeb1.controller;

import com.example.aretrusaWeb1.facade.FeedbackFacade;
import com.example.aretrusaWeb1.model.Feedback;
import com.example.aretrusaWeb1.view.UiFeedback;
import com.example.aretrusaWeb1.view.networkUi.BasicResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/feedback"})
public class FeedbackController {

    @Autowired
    private FeedbackFacade feedbackFacade;

    //Mostra tutti i feedback
    @GetMapping({""})
    public List<UiFeedback> all() {
        return this.feedbackFacade.findAll();
    }

    //Mostra UiFeedback per ID inserito
    @GetMapping({"/find/{id}"})
    public BasicResponse<UiFeedback> read(@PathVariable("id") ObjectId id) {
        BasicResponse<UiFeedback> uiFeedbackBasicResponse = new BasicResponse<UiFeedback>(0, "ok", feedbackFacade.findById(id).getBody());
        return uiFeedbackBasicResponse;
    }

    //Aggiungi nuovo feedback ricevendo un JSON
    @PostMapping({"/newFeedback"})
    public BasicResponse<UiFeedback> newFeedback(@RequestBody Feedback newFeedback) {
        BasicResponse<UiFeedback> uiFeedbackBasicResponse = new BasicResponse<UiFeedback>(0, "ok", (UiFeedback) feedbackFacade.save(newFeedback).getBody());
        return uiFeedbackBasicResponse;
    }

    //Elimina un feedback per ID inserito
    @DeleteMapping("/delete/{id}")
    void deleteFeedback(@PathVariable ObjectId id) {
        feedbackFacade.deleteById(id);
    }

    //Modifica Feedback per ID inserito e ricevendo un JSON
    @PutMapping("/edit/{id}")
    Feedback editFeedback (@RequestBody Feedback newFeedback, @PathVariable ObjectId id) {
        return feedbackFacade.editFeedback(id, newFeedback);
    }



}
