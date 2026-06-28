package com.example.conceptAndCodingPlayGround.PlainJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public Connection getConnection(){
        try{
            //H2 Driver loading.
            Class.forName("org.h2.Driver");

            //Establish connection.
            return DriverManager.getConnection("jdbc:h2:mem:userDB", "root", "");
        } catch(ClassNotFoundException | SQLException e){
            System.out.println("Something went wrong while loading sql driver class or getting connection.... please check..");
            e.printStackTrace();
        }
        throw new IllegalStateException("Unable to create H2 connection");
    }
}
