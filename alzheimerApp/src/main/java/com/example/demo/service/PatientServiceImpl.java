package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.models.Patient;
import com.example.demo.repository.PatientRepository;

@Component
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository ;	
	
	@Override
	public void savePatient(Patient patient) {
		this.patientRepository.save(patient);
		
	}
	@Override
	public List<Patient> getAllPatients() {
		return this.patientRepository.findAll();
	}
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
		
	}



}
