package com.example.demo.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Patient;
import com.example.demo.service.PatientService;

@Controller
public class PatientController {
	
	@Autowired
	private PatientService patS;
	
	
    @RequestMapping("/patientList")
    String viewListPatients(Model model){
    	model.addAttribute("listPatient", patS.getAllPatients());
        return "patientsList";
    }	
	
	
    @RequestMapping("/patientForm")
    String index(Model model){
    	Patient patient=new Patient();
    	model.addAttribute("pat", patient);
        return "patientForm";
    }
    
	@PostMapping("/savePatient")
	public String saveEmployee(@ModelAttribute("pat") Patient patient) {
		//save employee to database
		patS.savePatient(patient);
		return "redirect:/patientList";
		
	}


	
	


}
