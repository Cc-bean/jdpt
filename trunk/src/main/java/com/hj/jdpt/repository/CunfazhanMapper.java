package com.hj.jdpt.repository;


import com.hj.jdpt.domain.Cunfazhan;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component(value = "cunfazhanMapper")
public interface CunfazhanMapper {

    @Select("select * from cunfazhan where CFZ_Village=#{id}")
    Cunfazhan FindCunfazhanByVillageId(Integer id);
}