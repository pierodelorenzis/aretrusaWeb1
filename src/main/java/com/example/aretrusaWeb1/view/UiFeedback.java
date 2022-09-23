package com.example.aretrusaWeb1.view;

import com.example.aretrusaWeb1.model.Feedback;

public class UiFeedback {
    public int value;


    public UiFeedback(Feedback feedback) {
        this.value=feedback.getValue();
    }

    public UiFeedback() {
    }

    public int getValue() {
        return value;
    }

}
