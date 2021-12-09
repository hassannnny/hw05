package edu.neiu.hw06.controllers;

import edu.neiu.hw06.data.TasksRepository;
import edu.neiu.hw06.models.GoGetter;
import edu.neiu.hw06.models.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
    @RequestMapping("/viewtask")
    public class ViewTasksController {

    public TasksRepository TasksRepo;

    @Autowired
    public ViewTasksController(TasksRepository TasksRepo) {
        this.TasksRepo = TasksRepo;
    }

    @GetMapping
    public String showTasksName(Model model) {
        List<Tasks> listOfTasks = (List<Tasks>) this.TasksRepo.findAll();
        model.addAttribute("tasks", listOfTasks);
        return "display-tasks";
    }

}
