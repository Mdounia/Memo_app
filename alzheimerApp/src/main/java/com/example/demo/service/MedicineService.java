package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Medicine;

public interface MedicineService {
	
	List<Medicine> getAllMedidcines();
	void saveMedicne(Medicine medicine);
	Medicine getMedicineById(long id);
	void deteleMedicneById(long id);

}
