package com.example.conceptAndCodingPlayGround.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/v4/")
public class UserControllerWithExceptionHandlerAndResponseStatus2 {

    @GetMapping(path = "/get-user")
    public ResponseEntity<?> getUser(){
        throw new RuntimeException("Something went wrong happened");
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Bad request for the response status")
    public void handleRuntTimeException(RuntimeException rex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.FORBIDDEN.value(), "You are not authorised");
    }
}
