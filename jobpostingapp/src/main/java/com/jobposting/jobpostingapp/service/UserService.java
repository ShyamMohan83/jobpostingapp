package com.jobposting.jobpostingapp.service;

import com.jobposting.jobpostingapp.mapper.*;
import com.jobposting.jobpostingapp.model.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final AddressMapper addressMapper;
    private final EmailMapper emailMapper;

    private final PhoneMapper phoneMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    private final UserPreferenceMapper userPreferenceMapper;

    private final AuthMapper authMapper;
    private final UserRoleMapper userRoleMapper;

    public UserService(UserMapper userMapper, AddressMapper addressMapper, EmailMapper emailMapper,
                       PhoneMapper phoneMapper, UserPreferenceMapper userPreferenceMapper,
                       AuthMapper authMapper, UserRoleMapper userRoleMapper,
                       BCryptPasswordEncoder passwordEncoder
    ) {
        this.userMapper = userMapper;
        this.addressMapper = addressMapper;
        this.emailMapper = emailMapper;
        this.phoneMapper = phoneMapper;
        this.userPreferenceMapper = userPreferenceMapper;
        this.authMapper = authMapper;
        this.userRoleMapper = userRoleMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Transactional
    public User createUser(User user) {
        this.insertUser(user);
        this.insertAddress(user);
        this.insertEmails(user);
        this.insertAllPhoneNumbers(user);
        this.insertAllUserPreference(user);
        this.insertUserAuthInfo(user);
        this.insertAllRoles(user);
        return user;
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    public void insertEmails(User user) {
        for (Email email : user.getEmails()) {
            email.setUserId(user.getUserId());
            emailMapper.insertEmails(email);
        }
    }

    public void insertAddress(User user) {
        for(Address address: user.getAddress()) {
            address.setUserId(user.getUserId());
            addressMapper.insertAddress(address);
        }
    }

    public void insertAllPhoneNumbers(User user) {
        for (Phone phone : user.getPhones()) {
            phone.setUserId(user.getUserId());
            phoneMapper.insertPhoneNumbers(phone);
        }
    }

    public void insertAllUserPreference(User user) {
        for(UserPreference userPreference: user.getUserPreference()) {
            userPreference.setUserId(user.getUserId());
            userPreferenceMapper.insertUserPreference(userPreference);
        }
    }

    public void insertUserAuthInfo(User user) {
        UserAuthEntity userAuthEntity = user.getAuthEntity();
        String rawPassword = userAuthEntity.getPasswordHash();
        rawPassword = passwordEncoder.encode(rawPassword);
        System.out.println(rawPassword);
        userAuthEntity.setUserId(user.getUserId());
        userAuthEntity.setPasswordHash(rawPassword);
        authMapper.insertAuthInformation(userAuthEntity);
    }

    public void insertAllRoles(User user) {
        for (UserRole userRole : user.getRoles()) {
            userRole.setUserId(user.getUserId());
            this.userRoleMapper.insertUserRoles(userRole);
        }
    }
}
