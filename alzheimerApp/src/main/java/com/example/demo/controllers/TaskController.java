package com.example.demo.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Task;
import com.example.demo.models.User;
import com.example.demo.service.TaskService;
import com.example.demo.service.UserService;
import com.example.demo.web.dto.UserRegistrationDto;



@Controller
public class TaskController {
	
	@Autowired
	private TaskService taskS;
	private UserService patS;
	
	@Autowired
	public TaskController(@Qualifier("patient")UserService patS) {
		this.patS = patS;
	}


    
	@RequestMapping("/tasksList")
    String viewListPatients(Model model){
    	model.addAttribute("listTask", taskS.getAllTasks());
        return "tasksList";
    }
    @RequestMapping("/taskForm")
    String index(Model model){
    	Task task=new Task();
    	model.addAttribute("task", task);
    	List<User>users=patS.getAllPatients();
    	model.addAttribute("users", users);
        return "taskForm";
    }
    
	@PostMapping("/saveTask")
	public String savePatient(@ModelAttribute("task") Task task ) {
		//save task to database
		taskS.saveTask(task);
		return "redirect:/tasksList";
		
	}
	@GetMapping("/Update/{id}")
	public String update(@PathVariable (value="id") long id,Model model) {
		//get task from the service
		Task task =taskS.getTaskById(id);
		//set task as model attribute to pre populate the form
		model.addAttribute("taskUpd", task);
    	List<User>users=patS.getAllPatients();
    	model.addAttribute("users", users);
		return "updateTask";
		
	}
	@GetMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable (value="id") long id) {
		//call delete methode from the service 
		this.taskS.deteleTaskById(id);
		return "redirect:/tasksList";	
		
	}

}
