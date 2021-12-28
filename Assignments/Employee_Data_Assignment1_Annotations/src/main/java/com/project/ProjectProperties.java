package com.project;

import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class ProjectProperties implements Project{
    private ArrayList<String> projectList = new ArrayList<>();

    // Setter for project list
    @Override
    public void setProjects(ArrayList<String> projectList) {
        this.projectList = projectList;
    }

    // Display the projects
    @Override
    public ArrayList<String> getProjects() {
        return projectList;
    }
}
