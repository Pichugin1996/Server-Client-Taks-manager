package com.dimastik.server.service;

import com.dimastik.server.dto.TaskResponseDTO;
import com.dimastik.server.entity.Task;
import com.dimastik.server.exception.TaskNotFound;
import com.dimastik.server.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFound("Task id: " + id + " not found!"));
    }
}
