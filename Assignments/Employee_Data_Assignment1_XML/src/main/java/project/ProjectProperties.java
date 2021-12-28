package project;

import java.util.ArrayList;
import java.util.List;

public class ProjectProperties {
    List<String> projectList = new ArrayList<>();

    public void setProjects(List<String> projectList) {
        this.projectList = projectList;
    }

    public List<String> getProjects() {
        return projectList;
    }
}
