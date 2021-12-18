package controller;

import org.apache.commons.text.CaseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @RequestMapping("/homepage")
    public String homepage() {
        return "homepage";
    }

    @RequestMapping("/studentForm")
    public String studentForm() {
        return "studentForm";
    }

    @RequestMapping("/displayInfo")
    public String displayInfo(){
        return "displayInfo";
    }

//    @RequestMapping("/displayInfoV2")
//    public String displayInfoV2(HttpServletRequest request, Model model){
//        String firstName = request.getParameter("fname");
//        String lastName = request.getParameter("lname");
//        String fullName = camelCase(String.format("%s %s", firstName, lastName));
//        model.addAttribute("fullName", fullName);
//        return "helloStudent";
//    }

    @RequestMapping("/displayInfoV2")
    public String displayInfoV2(@RequestParam("fname") String firstName, @RequestParam("lname") String lastName,
                                Model model){
        String fullName = camelCase(String.format("%s %s", firstName, lastName));
        model.addAttribute("fullName", fullName);
        return "helloStudent";
    }

    private String camelCase(String fullName){
        return CaseUtils.toCamelCase(fullName, true, ' ');
    }}
