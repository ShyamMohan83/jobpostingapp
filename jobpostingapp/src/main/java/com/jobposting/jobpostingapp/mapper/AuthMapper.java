package com.jobposting.jobpostingapp.mapper;

import com.jobposting.jobpostingapp.model.AuthResponse;
import com.jobposting.jobpostingapp.model.UserAuthEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthMapper {
    public UserAuthEntity getPasswordByUsername(@Param("userName") String userName);
    public int insertAuthInformation(UserAuthEntity userAuthEntity);
}
