package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    String login(Model model){
    	model.addAttribute("msg", "hello");
        return "login";
    }
    
    @RequestMapping("/register")
    String register(Model model){
    	model.addAttribute("msg", "hello");
        return "register";
    }
    
    @RequestMapping("/home")
    String viewHome(Model model){
    	model.addAttribute("msg", "hello");
        return "index";
    }
}
