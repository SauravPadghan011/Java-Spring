package com.spring.IoC;

import com.spring.IoC.service.HappyFortune;

public class MyApp {
    public static void main(String[] args) {
        Coach coach = new BaseballCoach(new HappyFortune());
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
    }
}
