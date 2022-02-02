package com.example.DAO;

import com.example.config.HibernateConfig;
import com.example.model.Employee;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class EmployeeDao {

    private Session session = HibernateConfig.getSessionFactory().openSession();

    public void setEmployee(Employee employee) {
        try{
            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getEmployee() {
        try{
            session.beginTransaction();

            List<Employee> employeeList = session.createQuery("FROM Employee", Employee.class).getResultList();

            session.getTransaction().commit();

            return employeeList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public void updateEmployee() {
//        Scanner scan = new Scanner(System.in);
//        System.out.print("Enter Employee Id to Delete: ");
//        int empId = scan.nextInt();
//
//        System.out.print("1. Mobile Number\n2.Address\nWhat to update? ");
//        int choice = scan.nextInt();
//        String whatToUpdate = null;
//        if(choice == 1) whatToUpdate = "empMobile";
//        else if(choice == 2) whatToUpdate = "empAddr";
//
//        try{
//            session.beginTransaction();
//
//            session.createQuery("UPDATE " + "").executeUpdate();
//
//            session.getTransaction().commit();
//        } catch (Exception e) {
//
//        }
//    }

    public void deleteEmployee(Integer id) {
        try{
            session.beginTransaction();

            session.createQuery("DELETE FROM Employee e WHERE e.empId='"+id+"'").executeUpdate();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
