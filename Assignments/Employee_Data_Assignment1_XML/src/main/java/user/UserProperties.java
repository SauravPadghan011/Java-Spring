package user;

import address.Address;
import team.Team;

import java.util.ArrayList;

public class UserProperties implements User{
    private String name;
    private String phone;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }



    // Constructor Injection
    Address address;
    public UserProperties(Address address) {
        this.address = address;
    }

//    Team team;
//    public void setTeamDetails(Team team) {
//        this.team = team;
//    }
//    ArrayList<String> list = new ArrayList<>();
//    @Override
//    public void setList(ArrayList<String> list) {
//        team.setProjects(list);
//    }

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



    @Override
    public void getUserDetails() {
        System.out.println("Name: "+name);
        System.out.println("Phone: "+phone);
        System.out.println("Address Line 1: "+address.getAddressLine1());
        System.out.println("Address Line 2: "+address.getAddressLine2());
        System.out.println("City: "+address.getCity());
        System.out.println("State: "+address.getState());
        System.out.println("Pincode: "+address.getPincode());
//        System.out.println("Team Name: "+team.getTeamName());
//        System.out.println("No of Members in Team: "+team.getNoOfMembers());
//        team.getProjects();

    }
}
