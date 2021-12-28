package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "student-form";
    }

    @RequestMapping("/displayForm")
    public String displayForm() {
        return "student-display";
    }
}
