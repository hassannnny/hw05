package edu.neiu.hw06.controllers;

import edu.neiu.hw06.data.GoGetterRepository;
import edu.neiu.hw06.models.GoGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/view/{id}")
    public String showGoGetter(@PathVariable Long id, Model model) {
        GoGetter goGetter = this.GoGetterRepo.findById(id).get();
        model.addAttribute("gogetter", goGetter);
        return "view-gogetter";
    }

    @GetMapping("/delete/{id}")
    public String deleteGoGetter(@PathVariable Long id) {
        this.GoGetterRepo.deleteById(id);
        return "redirect:/view";
    }

    @PostMapping
    public String handleGoGetterForm(@Valid @ModelAttribute("gogetter") GoGetter gogetter, Errors errors) {
        if (errors.hasErrors()) {
            return "add-gogetter";
        }
        try {
            this.GoGetterRepo.save(gogetter);
        } catch (DataIntegrityViolationException e) {
            errors.rejectValue("email", "InvalidEmail", "Email is already registered");
            return "add-gogetter";
        }
        return "add-gogetter";
    }

    @PostMapping("edit/{id}")
    public String handleEditGoGoGetterForm(@PathVariable Long id, @Valid @ModelAttribute("gogetter") GoGetter gogetter, Errors errors) {
        if (errors.hasErrors()) {
            return "view-gogetter";
        }
        try {
            GoGetter originalGogetter = this.GoGetterRepo.findById(id).get();
            updateOriginalGoGetter(originalGogetter, gogetter);
            this.GoGetterRepo.save(gogetter);
        } catch (DataIntegrityViolationException e) {
            errors.rejectValue("email", "InvalidEmail", "Email is already registered");
            return "view-gogetter";
        }
        return "redirect:/add-gogetter";
    }

    private void updateOriginalGoGetter(GoGetter original, GoGetter update) {
        original.setFirstName(update.getFirstName());
        original.setLastName(update.getLastName());
        original.setSchoolEmail(update.getSchoolEmail());
    }

}




