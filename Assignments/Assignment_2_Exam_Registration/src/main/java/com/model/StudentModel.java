package com.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class StudentModel {

    private Integer rollNo;
    private String firstName;
    private String lastName;
    private String semester;
    private Map<String, String> semesterOptions;

    private Integer javaMarks;
    private Integer dsaMarks;
    private Integer osMarks;
    private Integer dbmsMarks;
    private Integer wdMarks;
    private Integer[] marks = new Integer[5];
    private Integer percentage = 0;

    public StudentModel() {
        semesterOptions = new LinkedHashMap<>();
        semesterOptions.put("First Semester", "First Semester");
        semesterOptions.put("Second Semester", "Second Semester");
        semesterOptions.put("Third Semester", "Third Semester");
        semesterOptions.put("Fourth Semester", "Fourth Semester");
        semesterOptions.put("Fifth Semester", "Fifth Semester");
        semesterOptions.put("Sixth Semester", "Sixth Semester");
        semesterOptions.put("Seventh Semester", "Seventh Semester");
        semesterOptions.put("Eight Semester", "Eight Semester");
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
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

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Map<String, String> getSemesterOptions() {
        return semesterOptions;
    }

    public void setSemesterOptions(Map<String, String> semesterOptions) {
        this.semesterOptions = semesterOptions;
    }


    public Integer getJavaMarks() {
        return javaMarks;
    }

    public void setJavaMarks(Integer javaMarks) {
        this.javaMarks = javaMarks;
    }

    public Integer getDsaMarks() {
        return dsaMarks;
    }

    public void setDsaMarks(Integer dsaMarks) {
        this.dsaMarks = dsaMarks;
    }

    public Integer getOsMarks() {
        return osMarks;
    }

    public void setOsMarks(Integer osMarks) {
        this.osMarks = osMarks;
    }

    public Integer getDbmsMarks() {
        return dbmsMarks;
    }

    public void setDbmsMarks(Integer dbmsMarks) {
        this.dbmsMarks = dbmsMarks;
    }

    public Integer getWdMarks() {
        return wdMarks;
    }

    public void setWdMarks(Integer wdMarks) {
        this.wdMarks = wdMarks;
    }

    public Integer[] getMarks() {
        return marks;
    }

    public void setMarks(Integer[] marks) {
        marks[0] = javaMarks;
        marks[1] = dsaMarks;
        marks[2] = osMarks;
        marks[3] = dbmsMarks;
        marks[4] = wdMarks;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        setMarks(marks);
        Integer totalMarks = 0;
        for(int i=0; i<5; i++) {
           totalMarks += marks[i];
        }
        this.percentage =  (totalMarks*100)/500;
    }
}
