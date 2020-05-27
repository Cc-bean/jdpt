package com.hj.jdpt.repository;


import com.hj.jdpt.domain.Job;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component(value = "job")
public interface JobMapper {

    @Select("select * from job where J_Key = #{id}")
    Job queryById(Integer id);

    @Select("select * from job where J_key=#{id}")
    Job FindJobById(Integer id);
}