package com.hj.jdpt.repository;

import com.hj.jdpt.domain.Zhen;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component(value = "zhenMapper")
public interface ZhenMapper {

    @Select("select * from zhen where Zhen_Id=#{id}")
    Zhen FindByZid(Integer id);

}