package com.hj.jdpt.repository;


import java.util.List;

import com.hj.jdpt.domain.Zuzhifazhanyear;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component(value = "JiJiFenZiMapper")
public interface ZuzhifazhanyearMapper {

    @Select("select * from JiJiFenZi where  ")
    List< Zuzhifazhanyear>  queryAll();





}