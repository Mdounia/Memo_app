package com.example.demo.service;


import java.util.List;

import com.example.demo.models.Patient;

public interface PatientService {
	List<Patient> getAllPatients();
	void savePatient(Patient patient);
	Patient getPatientById(long id);
	void detelePatientById(long id);

	

}
