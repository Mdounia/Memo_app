package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.models.Task;
import com.example.demo.models.User;
import com.example.demo.repository.TaskRepository;


@Component
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public List<Task> getAllTasks() {	
		return this.taskRepository.findAll();
	}

	@Override
	public void saveTask(Task task) {
		
		this.taskRepository.save(task);
		
	}

	@Override
	public Task getTaskById(long id) {
		Optional<Task> optional=taskRepository.findById(id);
		Task task =null;
		if(optional.isPresent()) {
			task = optional.get();
		}else {
			throw new RuntimeException("Patient not found for id :: "+ id);
		}
		return task;
	}

	@Override
	public void deteleTaskById(long id) {
		this.taskRepository.deleteById(id);
		
	}

}
