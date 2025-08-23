package com.jobposting.jobpostingapp.controller;

import com.jobposting.jobpostingapp.model.AuthResponse;
import com.jobposting.jobpostingapp.model.UserLoginRequest;
import com.jobposting.jobpostingapp.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/login")
    public AuthResponse login(@RequestBody UserLoginRequest userLoginRequest) {
         return authService.verifyUser(userLoginRequest.getUserName(), userLoginRequest.getPassword());
    }

}
