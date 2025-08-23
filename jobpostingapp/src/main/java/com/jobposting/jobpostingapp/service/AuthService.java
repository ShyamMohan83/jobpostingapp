package com.jobposting.jobpostingapp.service;

import com.jobposting.jobpostingapp.mapper.AuthMapper;
import com.jobposting.jobpostingapp.model.AuthResponse;
import com.jobposting.jobpostingapp.model.UserAuthEntity;
import com.jobposting.jobpostingapp.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {
    private final AuthMapper authMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    public AuthService(AuthMapper authMapper, BCryptPasswordEncoder passwordEncoder) {
        this.authMapper = authMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse verifyUser(String userName, String rawPassword) {
        UserAuthEntity userAuthEntity = authMapper.getPasswordByUsername(userName);
        if(userAuthEntity == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
        }
        String hashPassWord = userAuthEntity.getPasswordHash();
        if(hashPassWord !=null && passwordEncoder.matches(rawPassword, hashPassWord)) {
            String token = JwtUtil.generateToken(userName);
            AuthResponse authResponse = new AuthResponse(token, userName, userAuthEntity.getUserId(), 1);
            return authResponse;
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
    }
}
