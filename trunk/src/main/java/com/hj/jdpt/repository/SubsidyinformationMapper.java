package com.hj.jdpt.repository;


import com.hj.jdpt.domain.Subsidyinformation;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component(value = "subsidyinformationMapper")
public interface SubsidyinformationMapper {

    @Select("select * from subsidyinformation where SubsidyInformation_Id=#{id}")
    Subsidyinformation FindSubsidyinformationById(Integer id);
}