package com.springdemo.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    Logger log = LoggerFactory.getLogger(CustomerController.class);
    @RequestMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult result){

        log.info("Last name : |" + theCustomer.getLastName() + "|");
        log.info("Binding result: " + result);
        log.info("\n");

        if(result.hasErrors())
            return "customer-form";
        else
            return "customer-confirmation";
    }
}
