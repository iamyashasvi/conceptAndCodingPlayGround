package com.example.conceptAndCodingPlayGround;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @GetMapping(path = "/api/getUser1")
    public ResponseEntity<String> getUser1(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("My-Header1", "headerOne");
        headers.add("My-Header2", "headerTwo");

        return ResponseEntity.status(HttpStatus.OK)
                .headers(headers)
                .body("My Response body object ");

    }

    @GetMapping(path = "/api/getUser2")
    public ResponseEntity<Void> getUser2(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("My-Header1", "myHeader1");
        headers.add("My-Header2", "myHeader2");

        return ResponseEntity.status(HttpStatus.OK)
                .headers(headers)
                .build();
//        build is uses body method with null body.
    }

    @GetMapping(path="/api/getUser3")
    public User getUser3(){
        User userResponseObj = new User("Yash", 25);
        // Bydefault it will return 200 status code.
        return userResponseObj;
    }
}

