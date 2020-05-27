package com.hj.jdpt.repository;


import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Subsidyname;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "subsidynameMapper")
public interface SubsidynameMapper {

    @Select("select * from subsidyname where S_type=#{id}")
    List<Subsidyname> FindSubsidynameByTypeId(Integer id);

    @Select("select * from subsidyname where S_type=#{id}")
    Page<Subsidyname> PageFindSubsidynameByTypeId(Integer id);

    @Select("select * from subsidyname where S_Key=#{id}")
    Subsidyname FindSubsidynameById(Integer id);
}