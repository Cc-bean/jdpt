package com.hj.jdpt.repository;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Jiaoyv;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import java.util.List;
@Component(value = "jiaoyvMapper")
public interface JiaoyvMapper {

    @Select("select * from  Jiaoyv")
    Page<Jiaoyv> queryAll();

    @Select("select * from  jiaoyv where JY_Id=#{jyId}")
    Page<Jiaoyv> query(Integer jyId);

}