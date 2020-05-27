package com.hj.jdpt.repository;


import java.util.HashMap;
import java.util.List;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Dangyuanzuzhihuodong;
import com.hj.jdpt.domain.Huodongleixing;
import com.hj.jdpt.domain.HuodongleixingAndDangYuanZuZhiHuoDong;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Component;

@Component(value = "huodongleixingMapper")
public interface HuodongleixingMapper {

    @Select("select * from huodongleixing where HDLX_Village=#{id}")
    @Results({
            @Result(property = "dangyuanzuzhihuodong",column = "HDLX_Id",
                    javaType = List.class,many = @Many(select = "com.hj.jdpt.repository.DangyuanzuzhihuodongMapper.queryAllByHDLX_Id")),
                    })
    /*@Select("SELECT * FROM huodongleixing ,dangyuanzuzhihuodong where huodongleixing.HDLX_Id = dangyuanzuzhihuodong.DYZZHD_LeiXing and HDLX_Village =  DYZZHD_Villageid and huodongleixing.HDLX_Village=#{id};")
    @Results(
            {
                    @Result(property = "hdlxId",column = "HDLX_Id"),
                    @Result(property = "hdlxName",column = "HDLX_Name"),
                    @Result(property = "hdlxSheng",column = "HDLX_Sheng"),
                    @Result(property = "hdlxShi",column = "HDLX_Shi"),
                    @Result(property = "hdlxQu",column = "HDLX_Qu"),
                    @Result(property = "hdlxZhen",column = "HDLX_Zhen"),
                    @Result(property = "hdlxVillage",column = "HDLX_Village"),

                    @Result(property = "dyzzhdId",column = "DYZZHD_Id"),
                    @Result(property = "dyzzhdName",column = "DYZZHD_Name"),
                    @Result(property = "dyzzhdContent",column = "DYZZHD_Content"),
                    @Result(property = "dyzzhdPhoto",column = "DYZZHD_Photo"),
                    @Result(property = "dyzzhdZhenshilujing",column = "DYZZHD_ZhenShiLuJing"),
                    @Result(property = "dyzzhdPlace",column = "DYZZHD_Place"),
                    @Result(property = "dyzzhdTime",column = "DYZZHD_Time"),
                    @Result(property = "dyzzhdVillageid",column = "DYZZHD_LeiXing"),
                    @Result(property = "dyzzhdLeixing",column = "DYZZHD_Villageid"),
                    @Result(property = "dyzzhdXvhao",column = "DYZZHD_xvhao"),
            }
    )*/
            List<HuodongleixingAndDangYuanZuZhiHuoDong> queryAll(Integer cun_Id);



            @Select("select * from huodongleixing where HDLX_Village=#{id}")
            @Results({
                    @Result(id = true,property = "hdlxId",column = "HDLX_Id")
            })
            Page<HuodongleixingAndDangYuanZuZhiHuoDong> queryAllLeixing(Integer cun_id);


}