package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Patient;
import com.example.demo.models.Task;

public interface TaskService {
	List<Task> getAllTasks();
	void saveTask(Task task);
	Task getTaskById(long id);
	void deteleTaskById(long id);

}
