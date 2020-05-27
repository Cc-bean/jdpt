package com.hj.jdpt.repository;


import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Cunhuodongleixing;
import com.hj.jdpt.domain.Cunzuzhihuodong;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "cunhuodongleixingMapper")
public interface CunhuodongleixingMapper {
    @Select({"select CHDLX_Id from cunhuodongleixing where CHDLX_Village=#{id}"})
    List<Cunhuodongleixing> findAll(int id);

    @Select({"select CDYZZHD_Name from cunzuzhihuodong where CDYZZHD_Leixing=#{cunhuodongleixingId}"})
    List<Cunzuzhihuodong> findCunhuodongbyId(int cunhuodongleixingId);

    @Select({"select * from cunzuzhihuodong where CDYZZHD_Leixing in(select CHDLX_Id from cunhuodongleixing where CHDLX_Village=#{id})"})
    Page<Cunzuzhihuodong> findAllhuodong(Integer id);

    @Select({"select * from cunhuodongleixing where CHDLX_Village=#{id}"})
    List<Cunhuodongleixing> AllType(Integer id);

    @Select({"select * from cunhuodongleixing where CHDLX_Id=#{id}"})
    Cunhuodongleixing findbyid(Integer id);





}