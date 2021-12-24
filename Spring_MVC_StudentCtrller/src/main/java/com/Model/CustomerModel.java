package com.Model;

import javax.validation.constraints.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerModel {

    private String firstName;

    @NotNull(message = "Field Cannot be Empty")
    @Size(min = 1, message = "Field Cannot Be Empty")
    private String lastName;

    /**
     * Here if we type enter any random String rather than the int it will throw or show the error
     * To avoid that we use typeMismatch.customer.freePasses=Invalid Number
     * Here typeMismatch=Exception, customer=Model_Name, freePasses=property/data member
     * For that we have to create bin.
     */
    @NotNull(message = "Field Cannot be Empty")
    @Min(value = 0, message = "Field should be greater than or equal 0")
    @Max(value = 10, message = "Field should be less than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^[0-9]{6}", message = "Invalid pincode")
    private String pincode;

    private String date;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
//        Date dateD = new Date();
//        SimpleDateFormat dateSimple = new SimpleDateFormat("dd/MM/yyyy");
//        this.date = dateSimple.format(dateD);
    }
}
