package com.jobposting.jobpostingapp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthMapper {
    public String getPasswordByUsername(@Param("userName") String userName);
}
