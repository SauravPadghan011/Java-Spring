package com.controller;

import com.model.StudentModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("student", new StudentModel());
        return "student-form";
    }

    @RequestMapping("/displayForm")
    public String displayForm(@ModelAttribute("student") StudentModel student) {
        System.out.printf("%s %s\n", student.getFirstName(), student.getLastName());
        student.setPercentage(0);
        System.out.println(student.getPercentage());
        return "student-display";
    }
}
