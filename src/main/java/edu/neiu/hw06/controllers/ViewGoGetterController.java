package edu.neiu.hw06.controllers;

import edu.neiu.hw06.data.GoGetterRepository;
import edu.neiu.hw06.models.GoGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewGoGetterController {

    public GoGetterRepository GoGetterRepo;

    @Autowired
    public ViewGoGetterController(GoGetterRepository GoGetterRepo) {
        this.GoGetterRepo = GoGetterRepo;
    }

    @GetMapping
    public String showGoGetterName(Model model) {
        List<GoGetter> gogetters = (List<GoGetter>) this.GoGetterRepo.findAll();
        model.addAttribute("gogetter", gogetters);
        return "display-gogetter";
    }
}