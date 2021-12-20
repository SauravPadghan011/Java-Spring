package com.Model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
}
