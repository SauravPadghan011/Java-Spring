package com.controller;

import com.Model.StudentModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

/**
 * If we developed the versions then we can simply use the /v1/student
 * Otherwise we have to create another com.Model.controller, and we have to add @RequestMapping("/v2/student")
 */
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        StudentModel student = new StudentModel();

        // here we are sending the object of the StudentModel to the form
        model.addAttribute("student", student);
        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") StudentModel student, Model model) {
        System.out.printf("%s %s%n", student.getFirstName(), student.getLastName());
        return "student-display";
    }
}
