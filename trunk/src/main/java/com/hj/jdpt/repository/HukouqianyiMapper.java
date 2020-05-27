package com.hj.jdpt.repository;


import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Hukouqianyi;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component(value = "hukouqianyiMapper")
public interface HukouqianyiMapper {


    @Select("select * from hukouqianyi where HKQY_Id=#{id}")
    Hukouqianyi FindHKQYById(Integer id);

    @Select("select * from hukouqianyi where HKQY_Village=#{villageId} and HKQY_LeiXing=#{typeId}")
    Page<Hukouqianyi> FindByCunIdLeixing(@Param("villageId") Integer villageId, @Param("typeId") Integer typeId);
}