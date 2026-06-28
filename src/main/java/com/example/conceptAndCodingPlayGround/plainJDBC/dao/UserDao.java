package com.example.conceptAndCodingPlayGround.plainJDBC.dao;

import com.example.conceptAndCodingPlayGround.plainJDBC.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.example.conceptAndCodingPlayGround.model.User;
import java.util.List;

public class UserDao {

    public void createUserTable(){
        try{
            Connection connection = new DatabaseConnection().getConnection();
            Statement statementQuery = connection.createStatement();
            String sqlQuery = "CREATE TABLE users(user_id INT AUTO_INCREMENT PRIMARY KEY, user_name VARCHAR(100), age INT)";
            statementQuery.executeUpdate(sqlQuery);
        } catch(SQLException e){
            System.out.println("Error while executing sqlQuery" + e.getMessage());
        }
        finally {
                // close stateQuery and DB connection.
        }
    }

    public void createUser(String username, int age){
        try{
            Connection connection = new DatabaseConnection().getConnection();
            String sqlQuery = "INSERT INTO users(user_name, age) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, age);
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){

        }
        finally{
        // close stateQuery and DB connection.
        }
    }

    public List<User> readUser(){
        List<User> userList = new ArrayList<>();
        try{
            Connection connection = new DatabaseConnection().getConnection();
            String sqlQuery = "SELECT * FROM users";
            PreparedStatement praparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet output = praparedStatement.executeQuery();
            while(output.next()){
                String userDetails = output.getInt("user_id") + " : " + output.getString("user_name") + " : " + output.getInt("age");
                System.out.println(userDetails);
                User user = new User(output.getString("user_name"), output.getInt("age"));
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            System.out.println("Somethingwent wrong while reading data from table" +e.getMessage() + e.getStackTrace());
        }
        finally {
            //close sql query statement and DB connection.
        }
        return userList;
    }
}
