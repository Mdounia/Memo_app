package com.example.demo.service;



import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.models.Patient;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.web.dto.UserRegistrationDto;

@Component
@Qualifier("patient")
public class PatientServiceImpl implements UserService {
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
    public PatientServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection < ? extends GrantedAuthority > mapRolesToAuthorities(Collection < Role > roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

	@Override
	public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(),
                registrationDto.getLastName(), registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("Patient")));
            return userRepository.save(user);
	}

	/*@Autowired
	private PatientRepository patientRepository ;	
	
	@Override
	public void savePatient(Patient patient) {
		this.patientRepository.save(patient);
		
	}*/
	@Override
	public List<User> getAllPatients() {
		return this.userRepository.findAll();
	}
	/*
	@Override
	public Patient getPatientById(long id) {
		Optional<Patient> optional=patientRepository.findById(id);
		Patient patient =null;
		if(optional.isPresent()) {
			patient = optional.get();
		}else {
			throw new RuntimeException("Patient not found for id :: "+ id);
		}
		return patient;
	}
	@Override
	public void detelePatientById(long id) {
		this.patientRepository.deleteById(id);
		
	}*/

	@Override
	public User getPatientById(long id) {
		Optional<User> optional=userRepository.findById(id);
		User patient =null;
		if(optional.isPresent()) {
			patient = optional.get();
		}else {
			throw new RuntimeException("Patient not found for id :: "+ id);
		}
		return patient;
	}

	@Override
	public void detelePatientById(long id) {
		this.userRepository.deleteById(id);
		
	}

	



    



}
