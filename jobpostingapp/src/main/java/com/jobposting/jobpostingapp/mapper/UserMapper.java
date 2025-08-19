package com.jobposting.jobpostingapp.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.jobposting.jobpostingapp.model.User;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getAllUsers();
    int insertUser(User user);
}