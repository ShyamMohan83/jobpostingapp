package com.jobposting.jobpostingapp.service;

import com.jobposting.jobpostingapp.mapper.AuthMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthMapper authMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    public AuthService(AuthMapper authMapper, BCryptPasswordEncoder passwordEncoder) {
        this.authMapper = authMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean verifyUser(String userName, String rawPassword) {
        String hashPassWord = authMapper.getPasswordByUsername(userName);
        return hashPassWord !=null && passwordEncoder.matches(rawPassword, hashPassWord);
    }

}
