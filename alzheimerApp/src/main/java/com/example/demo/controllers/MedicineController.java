package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Medicine;
import com.example.demo.models.User;
import com.example.demo.service.MedicineService;
import com.example.demo.service.UserService;

@Controller
public class MedicineController {
	
	@Autowired
	private MedicineService medS;
	
	private UserService patS;
	
	@Autowired
	public MedicineController(@Qualifier("patient")UserService patS) {
		this.patS = patS;
	}


    
	@RequestMapping("/medicinesList")
    String viewListPatients(Model model){
    	model.addAttribute("listMedicine",medS.getAllMedidcines());
        return "medicinesList";
    }
    @RequestMapping("/medicineForm")
    String index(Model model){
    	Medicine med=new Medicine();
    	model.addAttribute("med", med);
    	List<User>users=patS.getAllPatients();
    	model.addAttribute("users", users);
        return "medicineForm";
    }
    
	@PostMapping("/saveMedicine")
	public String savePatient(@ModelAttribute("med") Medicine med) {
		medS.saveMedicne(med);
		return "redirect:/medicinesList";
		
	}
	@GetMapping("/updateMedicine/{id}")
	public String update(@PathVariable (value="id") long id,Model model) {
		Medicine med =medS.getMedicineById(id);
		//set task as model attribute to pre populate the form
		model.addAttribute("medUpd", med);
    	List<User>users=patS.getAllPatients();
    	model.addAttribute("users", users);
		return "updateMedicine";
		
	}
	@GetMapping("/deleteMedicine/{id}")
	public String deleteTask(@PathVariable (value="id") long id) {
		//call delete methode from the service 
		this.medS.deteleMedicneById(id);
		return "redirect:/medicinesList";	
		
	}

}
