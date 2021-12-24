package spring_hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/edyoda";
        String username = "root";
        String password = "Padians@072";
        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Success !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
