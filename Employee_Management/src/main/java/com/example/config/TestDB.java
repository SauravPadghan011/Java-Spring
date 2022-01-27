package com.example.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/edyoda";
        String username = "root";
        String password = "Padians@072";

        try{
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Success");
        } catch (Exception e) {

        }
    }
}
