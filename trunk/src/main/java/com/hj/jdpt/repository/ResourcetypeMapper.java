package com.hj.jdpt.repository;


import java.util.List;

import com.hj.jdpt.domain.Resourcetype;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component(value = "resourcetypeMapper")
public interface ResourcetypeMapper {
    /**
     * 查询资源类型 R_type
     */
    @Select("select R_type from ResourceType where R_Key in (select R_Type from Resources  where R_Villageid =#{id})")
    List<String> findtypenameByCunid(int id);


    @Select("select User_VillageId from  Yonghu  where User_Id =#{id}")
    int findVillageid(int id);

    /**
     * 查询资源类型全部
     */
    @Select("select * from ResourceType ")
    List<Resourcetype> findall();


}