package com.example.aretrusaWeb1.view;

import com.example.aretrusaWeb1.model.Feedback;

public class UiFeedback {
    public Feedback.Value value;


    public UiFeedback(Feedback feedback) {
        this.value = feedback.getValue();
    }

    public UiFeedback() {
    }

    public Feedback.Value getValue() {
        return value;
    }

    private class Value {
    }
}
