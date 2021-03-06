package com.example.demo.service;


import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.models.Patient;
import com.example.demo.models.User;
import com.example.demo.web.dto.UserRegistrationDto;

public interface PatientService {
	List<Patient> getAllPatients();
	void savePatient(Patient patient);
	Patient getPatientById(long id);
	void detelePatientById(long id);
	

}
