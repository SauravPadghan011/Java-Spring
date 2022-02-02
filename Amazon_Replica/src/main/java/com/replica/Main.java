package com.replica;

import com.replica.admin.Admin;
import com.replica.User.Login_Register;
import com.replica.member.Member;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    private Amazon adminObj = new Login_Register();
    private Admin admin = new Admin();
    private Member member = new Member();

    public static void operations() {
        Main mainObj = new Main();

        System.out.println("\n*********************************************************\n" +
                           "               WELCOME TO AMAZON REPLICA\n" +
                           "***********************************************************");
        System.out.println();
        System.out.println("1. Admin\n2. Member");
        System.out.print("Select User: ");
        int adminMemberChoice = scan.nextInt();
        String userType = null;
        if(adminMemberChoice == 1)
            userType = "Admin";
        else if(adminMemberChoice == 2)
            userType = "Member";

        System.out.println("\n***************  "+ userType + " Login ****************");
        System.out.println("1. Register\n2. Login");
        System.out.print("Enter Your Choice: ");
        int regLogChoice = scan.nextInt();

        switch(regLogChoice) {
            case 1 -> {
                mainObj.adminObj.register(userType);
            }
            case 2-> {
                String userName = mainObj.adminObj.login(userType);
                if(adminMemberChoice == 1)
                    mainObj.admin.showAdminOptions(userName);
                else if(adminMemberChoice == 2)
                    mainObj.member.showMembersOptions(userName);
            }
        }
    }

    public static void main(String[] args) {
        operations();
    }
}