package project;

import java.util.ArrayList;
import java.util.List;

public class ProjectProperties implements Project{
    List<String> projectList = new ArrayList<>();

    @Override
    public void setProjects(List<String> projectList) {
        this.projectList = projectList;
    }

    @Override
    public List<String> getProjects() {
        return projectList;
    }
}
