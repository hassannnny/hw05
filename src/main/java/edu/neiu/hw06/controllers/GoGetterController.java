package edu.neiu.hw06.controllers;

import edu.neiu.hw06.data.GoGetterRepository;
import edu.neiu.hw06.models.GoGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/gogetter")
public class GoGetterController {

    public GoGetterRepository GoGetterRepo;

    @Autowired
    public GoGetterController(GoGetterRepository GoGetterRepo) {
        this.GoGetterRepo = GoGetterRepo;
    }

    @GetMapping
    public String getIndexPage(Model model) {
        model.addAttribute("gogetter", new GoGetter());
        return "add-gogetter";
    }

    @PostMapping
    public String handleGoGetterForm(@Valid @ModelAttribute("gogetter") GoGetter gogetter, Errors errors) {
        if (errors.hasErrors()) {
            return "add-gogetter";
        }
       this.GoGetterRepo.save(gogetter);
        return "redirect:/view";
    }

}




