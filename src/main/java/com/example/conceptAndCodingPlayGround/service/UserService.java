package com.example.conceptAndCodingPlayGround.service;

import com.example.conceptAndCodingPlayGround.model.User;
import com.example.conceptAndCodingPlayGround.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 This is kind where we write business logic.
 */
@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createTable(){
        userRepository.createTable();
    }

    public void insertUser(String name, int age){

        userRepository.insertUser(name, age);
    }

    public List<User> getUser(){
        List<User> listOfUser = userRepository.getUsers();
        for(User user : listOfUser){
            System.out.println("User ::\nid ==>" + user.getUserId() + "\n user_name ===>" + user.getName() + "\n age ===>" + user.getAge());
        }
        return listOfUser;
    }
}
