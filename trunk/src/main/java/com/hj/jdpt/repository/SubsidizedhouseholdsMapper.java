package com.hj.jdpt.repository;


import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Subsidizedhouseholds;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component(value = "subsidizedhouseholdsMapper")

public interface SubsidizedhouseholdsMapper {

    @Select("select * from subsidizedhouseholds where SubsidizedHouseholds_Id=#{id}")
    Subsidizedhouseholds FindBuzhuhuById(Integer id);

    @Select("select * from subsidizedhouseholds where SH_Villageid=#{id}")
    Page<Subsidizedhouseholds> PageFindBuzhuhuById(Integer id);

    @Select("select * from subsidizedhouseholds where SH_Villageid=#{id} and SH_Name like '${value}%'")
    Page<Subsidizedhouseholds> SearchByNameId(@Param("id") Integer id, @Param("value") String name);
}