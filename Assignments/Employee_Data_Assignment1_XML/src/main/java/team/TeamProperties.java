package team;

import project.ProjectProperties;

import java.util.ArrayList;

public class TeamProperties implements Team{

    // Here these values are assigned from the properties file
    private String teamName;
    private int noOfMembers;

    /**
     * Performing the Constructor Injection for Project Class
     */
    ProjectProperties project;
    public TeamProperties(ProjectProperties project){
        this.project = project;
    }
    @Override
    public void setProjects(ArrayList<String> list) {
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
}
