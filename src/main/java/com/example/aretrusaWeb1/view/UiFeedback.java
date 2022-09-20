package com.example.aretrusaWeb1.view;

import com.example.aretrusaWeb1.model.Feedback;

public class UiFeedback {
    public int feedback;


    public UiFeedback(Feedback feedback) {
        this.feedback=feedback.getFeedback();
    }

    public UiFeedback() {
    }

    public int getFeedback() {
        return feedback;
    }

}
