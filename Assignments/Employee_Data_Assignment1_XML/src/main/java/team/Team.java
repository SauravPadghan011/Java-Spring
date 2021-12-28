package team;

import java.util.ArrayList;

public interface Team {

    void setTeamName(String teamName);
    void setNoOfMembers(int noOfMembers);

    String getTeamName();
    int getNoOfMembers();

    void setProjects(ArrayList<String> list);
    void getProjects();
}
