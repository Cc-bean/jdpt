package com.hj.jdpt.repository;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Villageaffair;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component(value = "villageaffairMapper")

public interface VillageaffairMapper {


    @Select("select * from villageaffair where VA_Villageid=#{id}")
    Page<Villageaffair> FindHuiyiByCunId(Integer id);

    @Select("select * from villageaffair where VillageAffair_Id=#{id}")
    Villageaffair HuiYiXQ(Integer id);
}