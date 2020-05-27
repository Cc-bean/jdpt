package com.hj.jdpt.repository;


import com.hj.jdpt.domain.Subsidytype;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "subsidytypeMapper")
public interface SubsidytypeMapper {


    @Select("select * from subsidytype where SI_VillageId=#{id}")
    List<Subsidytype> FindSubsidytypeByCunId(Integer id);

    @Select("select * from subsidytype where SubsidyType_Id=#{id}")
    Subsidytype FindSubsidytypeById(Integer id);

}