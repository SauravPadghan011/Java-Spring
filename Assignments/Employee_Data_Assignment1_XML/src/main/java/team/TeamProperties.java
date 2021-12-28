package team;

import project.ProjectProperties;

import java.util.ArrayList;

public class TeamProperties implements Team{

    private String teamName;
    private int noOfMembers;

    ProjectProperties project;
    public TeamProperties (ProjectProperties project){
        this.project = project;
    }
    @Override
    public void Projects(ArrayList<String> list) {
        project.setProjects(list);
    }
    @Override
    public void getProjects() {
        System.out.println(project.getProjects());
    }


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


    @Override
    public String toString() {
        return String.format("Team Name: %s\nNo of Members: %s", teamName, noOfMembers);
    }
}
