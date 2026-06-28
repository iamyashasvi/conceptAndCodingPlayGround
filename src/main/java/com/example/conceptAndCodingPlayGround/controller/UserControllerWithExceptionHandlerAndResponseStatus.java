package com.example.conceptAndCodingPlayGround.controller;

import com.example.conceptAndCodingPlayGround.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user/")
public class UserControllerWithExceptionHandlerAndResponseStatus {

    @GetMapping(path = "/get-user-api")
    public ResponseEntity<?> getUserWithExceptionHandlerAndResponseStatus(){
        throw new CustomException(HttpStatus.BAD_REQUEST, "Invalid Request sent"); //BAD_REQUEST=400
    }

    @ExceptionHandler(CustomException.class)
    @ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "Some issue occures while sending response") //BAD_GATEWAY =502
    public ResponseEntity<?> handleCustomException(CustomException ex){
        return new ResponseEntity<>("You are not authorised", HttpStatus.FORBIDDEN); //FORBIDDEN = 403
    }
}
