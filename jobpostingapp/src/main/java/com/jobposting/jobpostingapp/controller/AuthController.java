package com.jobposting.jobpostingapp.controller;

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
    public String login(@RequestBody UserLoginRequest userLoginRequest) {
     if(authService.verifyUser(userLoginRequest.getUserName(), userLoginRequest.getPassword())) {
         return "Login Success";
     }
        return "Login failed";
    }

}
