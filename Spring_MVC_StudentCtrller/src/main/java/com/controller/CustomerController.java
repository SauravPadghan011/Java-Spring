package com.controller;

import com.Model.CustomerModel;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    /**
     * One method to avoid the spaces in input names
     * Basically it will trim the result
     * Before the binding and validation it will do a trimming of all the strings
     * It will find the String class and starts trimming
     * @param webDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("customer", new CustomerModel());
        return "customer-form";
    }

    @RequestMapping("/processForm")
    /**
     * It is necessary to use @Valid in order to perform validation
     * Also We have to use bindingResult along with ModelAttribute always
     */
    public String processForm(@Valid @ModelAttribute("customer") CustomerModel customer, BindingResult bindingResult) {
//        System.out.println(customer.getDate());
        if(bindingResult.hasErrors())
            return "customer-form";
        return "customer-display";
    }
}
