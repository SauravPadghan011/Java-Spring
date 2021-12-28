import org.springframework.context.support.ClassPathXmlApplicationContext;
import team.Team;
import user.User;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 = context.getBean("userBean", User.class);

        user1.setName("Saurav");
        user1.setPhone("9373232132");
        user1.setAddressLine1("Garoba Maidan");
        user1.setAddressLine2("Adarsh Nagar");
        user1.setCity("Nagpur");
        user1.setState("Maharashtra");
        user1.setPincode("440008");

        ArrayList<String> projectList = new ArrayList<>();
        projectList.add("Chat App");
        projectList.add("Bird Detection");
//        user1.setList(projectList);

//        Team team = context.getBean("teamBean", Team.class);
//        System.out.println(team.getTeamName());
//        System.out.println(team.getNoOfMembers());

        Team team = context.getBean("teamBean", Team.class);;

        user1.getUserDetails();
        System.out.println(team);

        team.Projects(projectList);
        team.getProjects();
    }
}
