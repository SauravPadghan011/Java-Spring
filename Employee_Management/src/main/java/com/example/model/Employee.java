package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "empName")
    private String empName;

    @Column(name = "empId")
    private Integer empId;

    @Column(name = "empAddr")
    private String empAddr;

    @Column(name = "empMobile")
    private String empMobile;

    @Column(name = "empDept")
    private String empDept;

    @Column(name = "empSalary")
    private Integer empSalary;

    public Employee(String empName, Integer empId, String empAddr, String empMobile, String empDept, Integer empSalary) {
        this.empName = empName;
        this.empId = empId;
        this.empAddr = empAddr;
        this.empMobile = empMobile;
        this.empDept = empDept;
        this.empSalary = empSalary;
    }
}
