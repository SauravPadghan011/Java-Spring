package com.example.controller;

import com.example.DAO.EmployeeDao;
import com.example.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeDao employeeDao = new EmployeeDao();

    /**
     * Home page.
     * Contains Add data, delete data, view/display data.
     */
    @RequestMapping("homePage")
    public String homePage() {
        return "home-page";
    }

    /**
     * Display the Employee Form.
     * Take the details of employee.
     */
    @RequestMapping("employeeForm")
    public String employeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    /**
     * Add the employee details into database.
     * Show the message that details has been stored successfully.
     * Then return to the home page.
     */
    @RequestMapping("/added")
    public String added(@ModelAttribute("employee") Employee employee) {
        employeeDao.setEmployee(employee);
        return "employee-added";
    }

    /**
     * Display Employee details into table format.
     */
    @RequestMapping("employeeDisplay")
    public String employeeDisplay(@ModelAttribute("employee") Employee employee, Model model) {
        List<Employee> employeeList = employeeDao.getEmployee();
        model.addAttribute("employeeList", employeeList);
        return "employee-display";
    }

    /**
     * Take employee id from user to delete employee.
     */
    @RequestMapping("employeeDelete")
    public String employeeDelete(@ModelAttribute("employee") Employee employee, Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-delete";
    }

    /**
     * Delete the employee from the database.
     * Show the message that employee has been deleted successfully.
     * Then return to the home page.
     */
    @RequestMapping("/deleted")
    public String deleted(@ModelAttribute("employee") Employee employee) {
        employeeDao.deleteEmployee(employee.getEmpId());
        return "employee-deleted";
    }

}
