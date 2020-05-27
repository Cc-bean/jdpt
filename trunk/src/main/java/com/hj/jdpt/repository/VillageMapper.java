package com.hj.jdpt.repository;


import com.hj.jdpt.domain.Village;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component(value = "villageMapper")
public interface VillageMapper {

    @Select("select * from village where Village_Id=#{cunid}")
    Village FindVImg(Integer cunid);
}