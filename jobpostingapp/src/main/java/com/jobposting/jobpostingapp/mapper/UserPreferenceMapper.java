package com.jobposting.jobpostingapp.mapper;

import com.jobposting.jobpostingapp.model.UserPreference;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserPreferenceMapper {
    public int insertUserPreference(UserPreference userPreference);
}
