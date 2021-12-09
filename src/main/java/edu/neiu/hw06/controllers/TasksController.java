package edu.neiu.hw06.controllers;

import edu.neiu.hw06.data.TasksRepository;
import edu.neiu.hw06.data.TasksRepository;
import edu.neiu.hw06.models.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/task")
public class TasksController {

    public TasksRepository TaskRepo;

    @Autowired
    public TasksController(TasksRepository TaskRepo) {
        this.TaskRepo = TaskRepo;
    }

    @GetMapping
    public String getTaskPage(Model model) {
        model.addAttribute("task", new Tasks());
        return "add-task";
    }

    @PostMapping
    public String handleTaskForm(@Valid @ModelAttribute("task") Tasks tasks, Errors errors) {
        return "redirect:/view";
    }

}

