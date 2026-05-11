package com.example.conceptAndCodingPlayGround;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    String message;
    HttpStatus status;

    public CustomException(HttpStatus status, String message){
        this.message = message;
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus(){
        return status;
    }

    public String getMessage(){
        return message;
    }
}
