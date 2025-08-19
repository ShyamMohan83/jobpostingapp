package com.jobposting.jobpostingapp.mapper;

import com.jobposting.jobpostingapp.model.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper {
    public int insertUserRoles(UserRole userRole);
}
