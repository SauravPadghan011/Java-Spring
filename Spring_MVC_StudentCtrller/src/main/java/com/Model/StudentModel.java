package com.Model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This is the model which will be used to send and receive the information
 * Controller <-> View Template</>
 */
public class StudentModel {

    private String firstName;
    private String lastName;
    private String country;
    private Map<String, String> countryOptions;
    private String language;
    private String[] operatingSystems;

    public StudentModel() {
        countryOptions = new LinkedHashMap<>();
        countryOptions.put("IN", "India");
        countryOptions.put("US", "USA");
        countryOptions.put("CN", "Canada");
        countryOptions.put("UK", "United Kingdom");
        countryOptions.put("FR", "France");
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Map<String, String> getCountryOptions() {
        return countryOptions;
    }

    public void setCountryOptions(Map<String, String> countryOptions) {
        this.countryOptions = countryOptions;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
}
