package com.controller;

import com.model.StudentModel;
import database.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/student")
public class StudentController {

    @InitBinder
    private void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("student", new StudentModel());
        return "student-form";
    }

    @RequestMapping("/successForm")
    public String successForm(@Valid @ModelAttribute("student") StudentModel student, BindingResult bindingResult) {
        System.out.printf("%s %s\n", student.getFirstName(), student.getLastName());
        if(bindingResult.hasErrors())
            return "student-form";
        student.setPercentage();
        writeToDB(student);
        return "student-successful";
    }

    @RequestMapping("/displayForm")
    public String displayForm(@ModelAttribute("student") StudentModel student, BindingResult bindingResult) {
        System.out.printf("%s %s\n", student.getFirstName(), student.getLastName());
        System.out.println(student.getPercentage());
        //readDB();
        return "student-display";
    }

    public void writeToDB(StudentModel studentModel) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            Student student  = new Student(studentModel.getRollNo(), studentModel.getFirstName(),
                    studentModel.getLastName(), studentModel.getSemester(), studentModel.getTotalMarks(),
                    studentModel.getPercentage());

            //Start the transaction
            session.beginTransaction();

            // Write into table
            session.save(student);

            //Commit the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
