package edu.neiu.hw06.controllers;

import edu.neiu.hw06.models.Go_Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/go_getter")
public class Go_GetterController {

    @GetMapping
    public String getIndexPage(Model model) {
        model.addAttribute("go_getter", new Go_Getter());
        return "index-page";
    }

}
