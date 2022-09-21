package com.example.aretrusaWeb1.view.networkUi;

public class BasicResponse<T> {

    private int errorCode;
    private String message;
    private T payload;

    public BasicResponse(int errorCode, String message, T payload) {
        this.errorCode = errorCode;
        this.message = message;
        this.payload = payload;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
