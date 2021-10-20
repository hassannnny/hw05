package edu.neiu.hw06.controllers;

import edu.neiu.hw06.models.GoGetter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gogetter")
public class GoGetterController {

    @GetMapping
    public String getIndexPage(Model model) {
        model.addAttribute("gogetter", new GoGetter());
        return "gogetter";
    }
    @PostMapping
    public String handleGoGetterForm(@ModelAttribute("gogetter") GoGetter gogetter) {
        System.out.print("Hello");
        System.out.print("First Name  " + gogetter.getFirstName());
        System.out.print("Last Name " + gogetter.getLastName());
        return ("redirect:/add-gogetter");
    }

}
