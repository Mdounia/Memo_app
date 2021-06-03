package com.example.demo.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.Patient;
import com.example.demo.models.User;
import com.example.demo.service.PatientService;
import com.example.demo.service.UserService;
import com.example.demo.web.dto.UserRegistrationDto;

@Controller
public class PatientController {
	
	//@Autowired
	private UserService patS;
	
	
    public PatientController(@Qualifier("patient")UserService patS) {
		this.patS = patS;
	}

	@RequestMapping("/patientList")
    String viewListPatients(Model model){
    	model.addAttribute("listPatient", patS.getAllPatients());
        return "patientsList";
    }	
	
	
    @RequestMapping("/patientForm")
    String index(Model model){
    	UserRegistrationDto user=new UserRegistrationDto();
    	model.addAttribute("pat", user);
        return "patientForm";
    }
    
	@PostMapping("/savePatient")
	public String savePatient(@ModelAttribute("pat") UserRegistrationDto user ) {
		//save patient to database
		patS.save(user);
		return "redirect:/patientList";
		
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value="id") long id,Model model) {
		//get patient from the service
		User patient =patS.getPatientById(id);
		//set patient as model attribute to pre populate the form
		model.addAttribute("patUpd", patient);
		return "updateForm";
		
	}
	@GetMapping("/deletePatient/{id}")
	public String deletePatient(@PathVariable (value="id") long id) {
		//call delete methode from the service 
		this.patS.detelePatientById(id);
		return "redirect:/patientList";	
		
	}
	


	
	


}
