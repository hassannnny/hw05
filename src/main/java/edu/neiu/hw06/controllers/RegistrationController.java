package edu.neiu.hw06.controllers;


import edu.neiu.hw06.data.RegistrationRepository;
import edu.neiu.hw06.models.GoGetter;
import edu.neiu.hw06.models.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    public RegistrationRepository RegisterRepo;

    @Autowired
    public RegistrationController(RegistrationRepository RegisterRepo) {
        this.RegisterRepo = RegisterRepo;
    }

    @GetMapping
    public String getRegistrationPage(Model model) {
        model.addAttribute("registration", new Registration());
        return "registration";
    }

   /* @GetMapping("/view/{id}")
    public String showRegistration(@PathVariable Long id, Model model) {
        Registration register = this.RegisterRepo.findById(id).get();
        model.addAttribute("registration", register);
        return "view-gogetter";
    }*/

    @PostMapping
    public String handleRegistrationForm(@Valid @ModelAttribute("registration") Registration registration, Errors errors) {
        if (errors.hasErrors()) {
            return "redirect:/view";
        }
        try {
            this.RegisterRepo.save(registration);
        } catch (DataIntegrityViolationException e) {
            errors.rejectValue("email", "InvalidEmail", "Email is already registered");
            return "registration";
        }

        return "redirect:/view";
    }
}
