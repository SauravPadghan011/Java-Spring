package com.team;

import com.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

// Create bean for TeamProperties class
@Component
@PropertySource(value = {"classpath:teams.properties"})
public class TeamProperties implements Team{

    // Fetch the values from the teams.properties file and store into the variables
    @Value("${teamName}")
    private String teamName;
    @Value("${teamMember}")
    private int noOfMembers;

    @Override
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public void setNoOfMembers(int noOfMembers) {
        this.noOfMembers = noOfMembers;
    }

    @Override
    public String getTeamName() {
        return teamName;
    }

    @Override
    public int getNoOfMembers() {
        return noOfMembers;
    }

    /**
     * Performing the Constructor Injection for Project Class
     */
    @Autowired
    @Qualifier("projectProperties")
    private Project project;
    @Override
    public void setProject(ArrayList<String> list) {
        project.setProjects(list);
    }
    @Override
    public void getProjects() {
        System.out.println(project.getProjects());
    }
}
