package edu.neiu.hw06.controllers;

import edu.neiu.hw06.data.UserRepository;
import edu.neiu.hw06.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class UserController {

    public UserRepository userRepository;

   /* @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public String handleRegistrationForm(@Valid @ModelAttribute("user") User user, Error errors) {
        return "add-gogetter";

    }*/
}
