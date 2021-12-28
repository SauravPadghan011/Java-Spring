package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.user.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Loading xml file and automatically refreshing the context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // This is the bean that we create for User Properties which contains all the user information
        User user1 = context.getBean("userProperties", User.class);

        // Saving user data
        user1.setName("Saurav");
        user1.setPhone("9373232132");
        user1.setAddressLine1("Garoba Maidan");
        user1.setAddressLine2("Adarsh Nagar");
        user1.setCity("Nagpur");
        user1.setState("Maharashtra");
        user1.setPincode("440008");

        // Add projects
        ArrayList<String> projectList = new ArrayList<>();
        projectList.add("Chat App");
        projectList.add("Bird Detection");
        user1.setProjectList(projectList);

        // Displaying the user information
        user1.getDetails();
        user1.getProjects();
    }
}
