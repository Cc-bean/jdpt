package com.hj.jdpt.repository;

import com.hj.jdpt.domain.Villagesurvey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value ="villageurveyMapper")
public interface VillagesurveyMapper {

    int insert(Villagesurvey record);

    int insertSelective(Villagesurvey record);




    @Select("select * from villagesurvey where VS_Villageid=#{id}")
    Villagesurvey FindVillagesurveyByVid(Integer id);

}