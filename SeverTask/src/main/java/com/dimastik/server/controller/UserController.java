package com.dimastik.server.controller;

import com.dimastik.server.dto.TaskResponseDTO;
import com.dimastik.server.dto.UserRequestDTO;
import com.dimastik.server.dto.UserResponseDTO;
import com.dimastik.server.entity.Task;
import com.dimastik.server.entity.Users;
import com.dimastik.server.exception.UserNotFound;
import com.dimastik.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users/test", method = RequestMethod.GET)
    public String testUserController() {
        return userService.testUserController();
    }

    //Получение массива task по логину и паролю
    @GetMapping("/users")
    public UserResponseDTO getUserByIdAndName(@RequestBody UserRequestDTO userRequestDTO) {
        Users user = userService.getUserByNameAndPassword(userRequestDTO.getName(), userRequestDTO.getPassword());
        System.out.println(user);
        return new UserResponseDTO(user);
    }
}
