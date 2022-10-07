package com.example.aretusaWeb1.service;

import java.util.List;

public class ServiceResult<T> {

    private List<String> errors;

    private T payload;

    public ServiceResult(List<String> errors, T payload) {
        this.errors = errors;
        this.payload = payload;
    }

    public ServiceResult() {
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
