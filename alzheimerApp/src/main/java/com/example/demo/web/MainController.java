package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.MedicineService;
import com.example.demo.service.TaskService;

@Controller
public class MainController {
	@Autowired
	private TaskService taskS;
	@Autowired
	private MedicineService medS;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String home(Model model,Authentication authentication) {
    	model.addAttribute("listTask", taskS.getAllTasks());
    	model.addAttribute("listMed", medS.getAllMedidcines());
    	String user=authentication.getName();
    	model.addAttribute("user", user);
        return "index";
    }

	
}

