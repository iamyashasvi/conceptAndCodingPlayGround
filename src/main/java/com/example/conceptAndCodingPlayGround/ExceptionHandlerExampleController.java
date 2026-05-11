package com.example.conceptAndCodingPlayGround;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v2/")
public class ExceptionHandlerExampleController {

    @GetMapping(path = "/get-user-exception")
    public ResponseEntity<?> getUserException(){
        throw new CustomException(HttpStatus.BAD_REQUEST, "UserID is missing");
    }

    @GetMapping(path = "/with-custom-exception-class")
    public ResponseEntity<?> getUserWithCustomExceptionClass(){
        throw new CustomException(HttpStatus.BAD_REQUEST, "User id is incorrect");
    }

    @GetMapping(path = "/with-illegal-exception-class")
    public ResponseEntity<?> getUserWithIllegalExceptiopnClass(){
        throw new IllegalArgumentException("inapproprate error arguments");
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex){
            return new ResponseEntity<>(ex.getMessage(), ex.getStatus());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> illegalArgumentExceptionHandler(IllegalArgumentException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

