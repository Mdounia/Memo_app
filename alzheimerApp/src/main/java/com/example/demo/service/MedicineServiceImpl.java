package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.models.Medicine;
import com.example.demo.models.Task;
import com.example.demo.repository.MedicineRepository;
import com.example.demo.repository.TaskRepository;

@Component
public class MedicineServiceImpl implements MedicineService {
	@Autowired
	private MedicineRepository medicineRepository;

	@Override
	public List<Medicine> getAllMedidcines() {
		// TODO Auto-generated method stub
		return this.medicineRepository.findAll();
	}

	@Override
	public void saveMedicne(Medicine medicine) {
		this.medicineRepository.save(medicine);
		
	}

	@Override
	public Medicine getMedicineById(long id) {
		Optional<Medicine> optional=medicineRepository.findById(id);
		Medicine med =null;
		if(optional.isPresent()) {
			med = optional.get();
		}else {
			throw new RuntimeException("Medicine not found for id :: "+ id);
		}
		return med;
	}

	@Override
	public void deteleMedicneById(long id) {
		this.medicineRepository.deleteById(id);
		
	}

}
