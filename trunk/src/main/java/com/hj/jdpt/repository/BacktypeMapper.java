package com.hj.jdpt.repository;

import com.hj.jdpt.domain.Backtype;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "backtypeMapper")
public interface BacktypeMapper {

    @Select("select * from backtype")
    List<Backtype> querryAll();

    @Select("select * from backtype where B_Key=#{id}")
    Backtype FindById_lfm(Integer id);
}