package com.dimastik.server.controller;

import com.dimastik.server.dto.TaskResponseDTO;
import com.dimastik.server.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/test")
    public String test() {
        System.out.println("OK");
        return "TEST OK";
    }

    @GetMapping("/tasks/{id}")
    public TaskResponseDTO getTaskById(@PathVariable Long id) {
        System.out.println("task: " + id);
        return new TaskResponseDTO(taskService.getTaskById(id));
    }
}
