package com.example.demo.service;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.models.Patient;
import com.example.demo.models.User;
import com.example.demo.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {	
	User save(UserRegistrationDto registrationDto);
	List<User> getAllPatients();
	User getPatientById(long id);
	void detelePatientById(long id);
	
	
	

	
}
