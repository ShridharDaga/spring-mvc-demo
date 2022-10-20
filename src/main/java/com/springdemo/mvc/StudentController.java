package com.springdemo.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    Logger log = LoggerFactory.getLogger(StudentController.class);

    @RequestMapping("/showForm")
    public String showForm(Model model){
        Student stud = new Student();
        model.addAttribute("student", stud);
        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student theStudent){
        log.info("\n" + theStudent + "\n");
        return "student-confirmation";
    }
}
