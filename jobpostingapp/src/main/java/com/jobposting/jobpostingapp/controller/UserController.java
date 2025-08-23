package com.jobposting.jobpostingapp.controller;

import com.jobposting.jobpostingapp.model.User;
import com.jobposting.jobpostingapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        System.out.println("inside the get All users");
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public boolean createUser(@RequestBody User user) {
        userService.createUser(user);
        return true;
    }
}
