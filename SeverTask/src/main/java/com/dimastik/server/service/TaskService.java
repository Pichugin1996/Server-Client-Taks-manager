package com.dimastik.server.service;

import com.dimastik.server.entity.Task;
import com.dimastik.server.entity.Users;
import com.dimastik.server.exception.TaskNotFound;
import com.dimastik.server.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TaskService")
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTaskByUserId(String name, String password) {
        Users user = userService.getUserByNameAndPassword(name, password);
        if (user.getId() == null) {
            return null;
        }
        return taskRepository.findAllByUserId(Math.toIntExact(user.getId()));
    }

}
