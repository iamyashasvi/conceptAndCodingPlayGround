package com.example.conceptAndCodingPlayGround.repository;

import com.example.conceptAndCodingPlayGround.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        //This also important to initialise.
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTable(){
        jdbcTemplate.execute("""
                CREATE TABLE IF NOT EXISTS users (
                    user_id INT AUTO_INCREMENT PRIMARY KEY,
                    user_name VARCHAR(100),
                    age INT
                )
                """);
    }

    public void insertUser(String name, int age){
        String insertQuery = "INSERT INTO users (user_name, age) VALUES (?, ?)";
        jdbcTemplate.update(insertQuery, name, age);
    }

    public List<User> getUsers(){
        String selectQuery = "SELECT * FROM users";
        return jdbcTemplate.query(selectQuery, (resultSet, rowNum) -> {
           User user = new User();
           user.setUserId(resultSet.getInt("user_id"));
           user.setAge(resultSet.getInt("age"));
           user.setName(resultSet.getString("user_name"));
           return user;
        });
    }
}
