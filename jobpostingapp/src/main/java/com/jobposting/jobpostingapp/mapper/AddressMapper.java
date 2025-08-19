package com.jobposting.jobpostingapp.mapper;

import com.jobposting.jobpostingapp.model.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper {
    int insertAddress(Address address );
}
