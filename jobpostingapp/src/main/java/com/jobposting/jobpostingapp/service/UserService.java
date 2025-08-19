package com.jobposting.jobpostingapp.service;

import com.jobposting.jobpostingapp.mapper.*;
import com.jobposting.jobpostingapp.model.*;
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

    private final UserPreferenceMapper userPreferenceMapper;

    public UserService(UserMapper userMapper, AddressMapper addressMapper, EmailMapper emailMapper, PhoneMapper phoneMapper, UserPreferenceMapper userPreferenceMapper) {
        this.userMapper = userMapper;
        this.addressMapper = addressMapper;
        this.emailMapper = emailMapper;
        this.phoneMapper = phoneMapper;
        this.userPreferenceMapper = userPreferenceMapper;
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
        this.allInsertUserPreference(user);
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

    public void allInsertUserPreference(User user) {
        for(UserPreference userPreference: user.getUserPreference()) {
            userPreference.setUserId(user.getUserId());
            userPreferenceMapper.insertUserPreference(userPreference);
        }
    }
}
