package com.user;

import java.util.ArrayList;

public interface User {

    /**
     * User properties setters to get name and phone number
     */
    void setName(String name);
    void setPhone(String phone);

    /**
     * Address class setters which stores address properties
     */
    void setAddressLine1(String addressLine1);
    void setAddressLine2(String addressLine2);
    void setCity(String city);
    void setState(String state);
    void setPincode(String pincode);


    void setProjectList(ArrayList<String> projectList);
    void getProjects();

    void getDetails();
}
