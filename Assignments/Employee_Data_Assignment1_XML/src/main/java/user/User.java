package user;


import java.util.ArrayList;

public interface User {
    void setName(String name);
    void setPhone(String phone);
    void getUserDetails();

    void setAddressLine1(String addressLine1);
    void setAddressLine2(String addressLine2);
    void setCity(String city);
    void setState(String state);
    void setPincode(String pincode);

    void setList(ArrayList<String> projectList);

//    void setList(ArrayList<String> list);
}