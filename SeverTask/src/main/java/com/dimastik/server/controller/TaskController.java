package com.dimastik.server.controller;

import com.dimastik.server.dto.TaskResponseDTO;
import com.dimastik.server.dto.UserRequestDTO;
import com.dimastik.server.entity.Task;
import com.dimastik.server.service.TaskService;
import com.dimastik.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/tasks")
    public List<Task> getTaskByUserId(@RequestBody UserRequestDTO userRequestDTO) {
        return taskService.getTaskByUserId(userRequestDTO.getName(), userRequestDTO.getPassword());
    }
}















