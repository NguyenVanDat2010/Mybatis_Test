package com.example.demo.dto.response;

public class MesseageResponse {
    private String message;

    public MesseageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
