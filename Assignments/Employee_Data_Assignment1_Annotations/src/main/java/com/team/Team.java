package com.team;

import java.util.ArrayList;

public interface Team {
    void setTeamName(String teamName);
    void setNoOfMembers(int noOfMembers);

    String getTeamName();
    int getNoOfMembers();

    void setProject(ArrayList<String> list);
    void getProjects();
}
