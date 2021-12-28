package com.address;

import org.springframework.stereotype.Component;

@Component
public class AddressProperties implements Address{
    private String addressLine1;
    private String addressLine2;
    private String City;
    private String State;
    private String pincode;

    /**
     * Setter to store address details
     */
    @Override
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @Override
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Override
    public void setCity(String city) {
        City = city;
    }

    @Override
    public void setState(String state) {
        State = state;
    }

    @Override
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }


    /**
     * Getters for the address fields
     */
    @Override
    public String getAddressLine1() {
        return addressLine1;
    }

    @Override
    public String getAddressLine2() {
        return addressLine2;
    }

    @Override
    public String getCity() {
        return City;
    }

    @Override
    public String getState() {
        return State;
    }

    @Override
    public String getPincode() {
        return pincode;
    }
}
