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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/task")
public class TasksController {

    public TasksRepository TasksRepo;

    @Autowired
    public TasksController(TasksRepository TasksRepo) {
        this.TasksRepo = TasksRepo;
    }

    @GetMapping
    public String getTasksPage(Model model) {
        model.addAttribute("task", new Tasks());
        return "add-task";
    }

    @PostMapping
    public String handleTasksForm(@Valid @ModelAttribute("task") Tasks tasks, Errors errors) {
        return "redirect:/viewtask";
    }

    @GetMapping("/view/{id}")
    public String showGoGetter(@PathVariable Long id, Model model) {
        Tasks task = this.TasksRepo.findById(id).get();
        model.addAttribute("task", task);
        return "viewtasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteGoGetter(@PathVariable Long id) {
        this.TasksRepo.deleteById(id);
        return "redirect:/viewtasks";
    }
}

