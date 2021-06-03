package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UserService;
import com.example.demo.web.dto.UserRegistrationDto;

@Controller //its able to handle http requests 
@RequestMapping("/registration")
public class UserRegistrationController {
	
	private UserService userService;

	@Autowired
	public UserRegistrationController(@Qualifier("tuteur")UserService userService) {
		this.userService = userService;
	}
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	@GetMapping
	public String showRegistrationForm() {
		return "register";
	}
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
		userService.save(userRegistrationDto);
		return "redirect:/registration?success";
	}
	

}
