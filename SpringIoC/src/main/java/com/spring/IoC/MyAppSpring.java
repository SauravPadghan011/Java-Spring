package com.spring.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyAppSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach coachB = context.getBean("baseballCoach", Coach.class);
        Coach coachC = context.getBean("cricketCoach", Coach.class);
        Coach coachF = context.getBean("footballCoach", Coach.class);
        System.out.println(coachB.getDailyWorkout());
        System.out.println(coachB.getDailyFortune());
        System.out.println(coachB.displayPersonalInfo());
        System.out.println();

        System.out.println(coachC.getDailyWorkout());
        System.out.println(coachC.getDailyFortune());
        System.out.println(coachC.displayPersonalInfo());
        System.out.println();

        System.out.println(coachF.getDailyWorkout());
        System.out.println(coachF.getDailyFortune());
        System.out.println(coachF.displayPersonalInfo());
        System.out.println();
    }
}
