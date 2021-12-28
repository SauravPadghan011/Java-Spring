package user;

import address.Address;
import team.Team;

import java.util.ArrayList;

public class UserProperties implements User{
    /**
     * The user class properties which takes
     */
    private String name;
    private String phone;

    /**
     * setName stores the name of the user.
     * setPhone stores the phone number of the user.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }


    /**
     * Performing the Constructor Injection for Address Class
     */
    Address address;
    public UserProperties(Address address) {
        this.address = address;
    }

    /**
     * Store the address information into AddressProperties class
     */
    @Override
    public void setAddressLine1(String addressLine1) {
        address.setAddressLine1(addressLine1);
    }

    @Override
    public void setAddressLine2(String addressLine2) {
         address.setAddressLine2(addressLine2);
    }

    @Override
    public void setCity(String city) {
        address.setCity(city);
    }

    @Override
    public void setState(String state) {
        address.setState(state);
    }

    @Override
    public void setPincode(String pincode) {
        address.setPincode(pincode);
    }


    /**
     * Performing Setter Injection for Team Class
     */
    Team team;
    //  setter method which is going to be injected
    public void setTeam(Team team) {
        this.team = team;
    }

    // Add the projects into the Project class
    @Override
    public void setList(ArrayList<String> projectList) {
        team.setProjects(projectList);
    }

    // Display the user Details
    @Override
    public void getUserDetails() {
        System.out.println("Name: "+name);
        System.out.println("Phone: "+phone);
        System.out.println("Address Line 1: "+address.getAddressLine1());
        System.out.println("Address Line 2: "+address.getAddressLine2());
        System.out.println("City: "+address.getCity());
        System.out.println("State: "+address.getState());
        System.out.println("Pincode: "+address.getPincode());
        System.out.println("Team Name: "+team.getTeamName());
        System.out.println("Team: "+team.getNoOfMembers());
        team.getProjects();
    }
}
