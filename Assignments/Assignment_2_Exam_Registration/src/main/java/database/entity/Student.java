package database.entity;

import javax.persistence.*;

@Entity
@Table(name="exam")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "rollNo")
    private String rollNo;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "semester")
    private String semester;

    @Column(name = "totalMarks")
    private Integer totalMarks;

    @Column(name = "percentage")
    private Double percentage;

    public Student() {}

    public Student(String rollNo, String firstName, String lastName,
                   String semester, Integer totalMarks, Double percentage) {
        this.rollNo = rollNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.semester = semester;
        this.totalMarks = totalMarks;
        this.percentage = percentage;
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

    public Integer getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Integer totalMarks) {
        this.totalMarks = totalMarks;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return String.format("Student [ID=%d, First Name=%s, Last Name=%s, Semester=%s, Total Marks=%d]",
                id, firstName, lastName, semester, totalMarks);
    }
}
