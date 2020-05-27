package com.hj.jdpt.repository;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Cunzuzhihuodong;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "cunzuzhihuodongMapper")
public interface CunzuzhihuodongMapper {
    /**
     * 查找活动详情
     * @return
     */
    @Select({"select * from cunzuzhihuodong where CDYZZHD_LeiXing=#{id}"})
    List<Cunzuzhihuodong> findCunzuzhihuodongdetail(Integer id);

    @Select({"select * from cunzuzhihuodong where CDYZZHD_LeiXing=#{id}"})
    Page<Cunzuzhihuodong> findall(Integer id);

    @Select({"select * from cunzuzhihuodong where CDYZZHD_Id=#{id}"})
    Cunzuzhihuodong findbyid(Integer id);

    @Select({"select * from cunzuzhihuodong where CDYZZHD_LeiXing in (SELECT cunhuodongleixing.CHDLX_Id FROM cunhuodongleixing where cunhuodongleixing.CHDLX_Village=#{vid})"})
    Page<Cunzuzhihuodong> findAll(Integer vid);
}