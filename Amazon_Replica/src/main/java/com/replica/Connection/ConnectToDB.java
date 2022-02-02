package com.replica.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToDB {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/Amazon";
        String userName = "root";
        String passwd = "Padians@072";

        try{
            Connection connection = DriverManager.getConnection(dbURL, userName, passwd);
            System.out.println("Success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
