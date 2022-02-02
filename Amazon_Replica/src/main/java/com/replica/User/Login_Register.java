package com.replica.User;

import com.replica.Amazon;
import com.replica.Main;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Login_Register implements Amazon {

    protected static SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(User.class)
            .buildSessionFactory();
    protected static Session session = sessionFactory.getCurrentSession();

    private String firstName;
    private String lastName;
    private String userName = null;
    private String email;
    private String passwd;
    private String fullAddress;

    @Override
    public String login(String userType) {
        try {
            // Start the Transaction
            session.beginTransaction();

            while(true){
                System.out.print("\nUsername: ");
                String emailLogin = Main.scan.next();
                System.out.print("Password: ");
                String passwdLogin = Main.scan.next();

                List<User> userList =
                        session.createQuery("FROM User u WHERE u.email='"+emailLogin+"' and u.passwd='"+passwdLogin+"' " ).getResultList();
                for(User user: userList){
                    userName = user.getFirstName() + user.getLastName();
//                    String numbers = userName.replaceAll("[^0-9]", "");
//                    String letters = userName.replaceAll("[^a-z]", "");
//                    System.out.println(letters+" "+numbers);
                }


                if(userList.isEmpty())
                    System.out.println("!!!!!!! Username or Password is incorrect !!!!!!!");
                else {
                    System.out.println("***************  Login Successful !!  ****************\n\n");
                    break;
                }
            }

            // Commit the Transaction
            session.getTransaction().commit();
            return userName;

        } catch(Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            sessionFactory.close();
            session.close();
        }
        return userName;
    }

    @Override
    public void register(String userType) {
        setUserData();

        try {
            User user = new User(firstName, lastName, email, passwd, fullAddress, userType);

            // Start the Transaction
            session.beginTransaction();

            // Write into table
            session.save(user);

            // Commit the Transaction
            session.getTransaction().commit();

        } catch(Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            sessionFactory.close();
            session.close();
        }
        Main.operations();
    }

    private void setUserData() {

        System.out.println("\n***************  Registration  ****************");
        System.out.print("First Name: ");
        firstName = Main.scan.next();

        System.out.print("Last Name: ");
        lastName = Main.scan.next();

        System.out.print("Email: ");
        email = Main.scan.next();

        while(true) {
            System.out.print("Password: ");
            passwd = Main.scan.next();

            System.out.print("Confirm Password: ");
            String confirmPasswd = Main.scan.next();

            if(!Objects.equals(passwd, confirmPasswd))
                System.out.println("\nPassword not matched!!\n");
            else
                break;
        }

        System.out.print("Full Address: ");
        Main.scan.nextLine();
        fullAddress = Main.scan.nextLine();

        System.out.println("***************  Registration Successful  ****************\n\n");
    }
}