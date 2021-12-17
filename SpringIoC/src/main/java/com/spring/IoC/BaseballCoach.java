package com.spring.IoC;
import com.spring.IoC.service.*;

public class BaseballCoach implements Coach{

    private final FortuneService fortuneService;
    private String team;
    private String email;
    private int experience;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    // Constructor Injection
    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice batting for 1hr";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String displayPersonalInfo() {
        return String.format("E-Mail: %s, Team: %s, Exp: %d", email, team, experience);
    }
}
