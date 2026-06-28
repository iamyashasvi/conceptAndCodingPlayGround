package com.example.conceptAndCodingPlayGround.controller;

import com.example.conceptAndCodingPlayGround.model.User;
import com.example.conceptAndCodingPlayGround.plainJDBC.dao.UserDao;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class UserController {

    public static final String successMessage = "Inserted One record successfully";

    /*
        curl --location --request POST 'http://localhost:8081/api/createTable' \
            --header 'Content-Type: application/json'
     */
    @PostMapping(path = "/api/createTable")
    public ResponseEntity<String> createTable(){
        UserDao userDao = new UserDao();
        userDao.createUserTable();
        return ResponseEntity.status(HttpStatus.OK)
                .body("Table is created");
    }

    /*
    curl --location 'http://localhost:8081/api/insert-one-user' \
        --header 'Content-Type: application/json' \
        --data '{
            "name": "daddy",
            "age": 63
        }'
     */
    @PostMapping(path = "/api/insert-one-user")
    public ResponseEntity<String> insertUser(@RequestBody User user){
        UserDao userDao = new UserDao();
        userDao.createUser(user.name, user.age);
        System.out.println(successMessage);
        return ResponseEntity.status(HttpStatus.OK)
                .body(successMessage);
    }

    /*
    curl --location 'http://localhost:8081/api/get-all-user-from-table'
     */
    @GetMapping(path = "/api/get-all-user-from-table")
    public ResponseEntity<List<User>> getAllUser(){
        UserDao userDao = new UserDao();
        List<User> userList = userDao.readUser();
        return ResponseEntity.status(HttpStatus.OK)
                .body(userList);
    }

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

