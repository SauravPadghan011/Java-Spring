package com.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentModel {

    @NotNull(message = "Field Cannot be Empty")
    @Pattern(regexp = "FSJ[0-9]{4}$", message = "Roll No. should be like this FSJXXXX")
    private String rollNo;

    @NotNull(message = "Field Cannot be Empty")
    private String firstName;
    private String lastName;

    @NotNull(message = "Field Cannot be Empty")
    private String semester;
    private Map<String, String> semesterOptions;

    private Integer javaMarks;
    private Integer dsaMarks;
    private Integer osMarks;
    private Integer dbmsMarks;
    private Integer wdMarks;
    private Integer[] marks = new Integer[5];
    private Integer totalMarks = 0;
    private Double percentage = 0.0;

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

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
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

    public Integer getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks() {
        setMarks(marks);
        for(int i=0; i<5; i++) {
            this.totalMarks += marks[i];
        }
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage() {
        setTotalMarks();
        this.percentage = (Double.valueOf(totalMarks)*100)/500;
    }

}
