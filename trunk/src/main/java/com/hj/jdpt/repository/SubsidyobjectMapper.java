package com.hj.jdpt.repository;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Subsidyobject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "subsidyobjectMapper")
public interface SubsidyobjectMapper {

    @Select("select * from subsidyobject where SubsidyObject_Id=#{id}")
    Subsidyobject FindSubsidyobjectById(Integer id);

    @Select("select * from subsidyobject where SO_villageId=#{id}")
    Page<Subsidyobject> PageFindSubsidyobjectByCunId(Integer id);

    @Select("select * from subsidyobject where SO_villageId=#{id}")
    List<Subsidyobject> FindSubsidyobjectByCunId(Integer id);

    @Select("select * from subsidyobject where SO_villageId=#{id} and SO_Name like '${value}%'")
    Page<Subsidyobject> SearchSubsidyobjectByName(@Param("id") Integer id, @Param("value") String name);
}