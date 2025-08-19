package com.jobposting.jobpostingapp.mapper;


import com.jobposting.jobpostingapp.model.Email;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailMapper {
    public int insertEmails(Email email);
}
