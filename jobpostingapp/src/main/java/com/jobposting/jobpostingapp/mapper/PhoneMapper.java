package com.jobposting.jobpostingapp.mapper;

import com.jobposting.jobpostingapp.model.Phone;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PhoneMapper {
    public int insertPhoneNumbers(Phone phone);
}
