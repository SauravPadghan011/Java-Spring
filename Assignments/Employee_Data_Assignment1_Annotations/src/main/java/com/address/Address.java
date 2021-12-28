package com.address;

import org.springframework.stereotype.Component;

public interface Address {
    void setAddressLine1(String addressLine1);
    void setAddressLine2(String addressLine2);
    void setCity(String city);
    void setState(String state);
    void setPincode(String pincode);

    String getAddressLine1();
    String getAddressLine2();
    String getCity();
    String getState();
    String getPincode();
}
