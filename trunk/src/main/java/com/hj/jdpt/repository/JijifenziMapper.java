package com.hj.jdpt.repository;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Jijifenzi;
import com.hj.jdpt.domain.Qingkuangbiangeng;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Component(value = "jijifenziMapper")
public interface JijifenziMapper {

    @Select("select * from jijifenzi where JJFZ_Village=#{jjfzVillage} and  JJFZ_Year=#{jjfzYear} ")
    Page<Jijifenzi> pageFindJijifenziByJjfzVillageandJjfzYear(@Param("jjfzVillage") Integer jjfzVillage, @Param("jjfzYear") Integer jjfzYear);

    @Select("select * from jijifenzi where JJFZ_Village=#{jjfzVillage} ")
    Page<Jijifenzi> pageFindJijifenziByJjfzVillage( Integer jjfzVillage);

    @Select("select * from jijifenzi where JJFZ_Year=#{jjfzYear} ")
    Page<Jijifenzi> pageFindJijifenziByJjfzYear( Integer jjfzYear);

    @Select("select * from jijifenzi  where JJFZ_Village in(select Village_Id from village where V_Zhen_Xiang in(select zhen_Id from Zhen where Z_Name=#{zName}))")
    Page<Jijifenzi>pageFindJijifenziByZName(String zName);

    @Select("select * from jijifenzi where JJFZ_Village in(select Village_Id from village where V_Zhen_Xiang in(select zhen_Id from Zhen where Z_Name=#{zName}))and JJFZ_Village in(select Village_Id  from village where V_Name=#{vName})")
    Page<Jijifenzi>pageFindJijifenziByVNameandZName(@Param("zName") String zName,@Param("vName")String vName);

    @Select("select * from jijifenzi where JJFZ_Village in(select Village_Id from village where V_Zhen_Xiang in(select zhen_Id from Zhen where Z_Name=#{zName}))and JJFZ_Village in(select Village_Id  from village where V_Name=#{vName})and JJFZ_Zu in(select Z_Key from Zu where Z_Key in(select QKBG_Zu from qingKuangBianGeng where QKBG_Time=#{qkbgTime}))")
    Page<Jijifenzi>pageFindJijifenziByVNameandZNameandQkbgTime(@Param("zName") String zName,@Param("vName")String vName,@Param("qkbgTime")String qkbgTime);

    //查询所有积极分子
    @Select("select * from jijifenzi ")
     Page<Jijifenzi> selectJijifenzi ();

    //根据id删除一条数
    @Delete("delete from jijifenzi where JJFZ_Id=#{jjfzId}")
    int  DeleteJijifenzi(Integer jjfzId);

    //同时删除多条数据
    @Delete("delete from jijifenzi where  JJFZ_Id in(#{jjfzId}) ")
    int  DeleteDuoTiaoJijifenzi(String jjfzId );

    //插入
    @Insert("insert into jijifenzi (Jjfz_Name,Jjfz_Native,Jjfz_Time,Jjfz_Wenhua,Jjfz_Village,Jjfz_Zu,Jjfz_Shenfenzheng,Jjfz_Danwei,Jjfz_Zhiwu,Jjfz_Sex,Jjfz_Phone,Jjfz_Year)values(#{jjfzName},#{jjfzNative},#{jjfzTime},#{jjfzWenhua},#{jjfzVillage},#{jjfzZu},#{jjfzShenfenzheng},#{jjfzDanwei},#{jjfzZhiwu},#{jjfzSex},#{jjfzPhone},#{jjfzYear}) ")
     int InsertJijifenzi();
    //根据id查询
    @Select("select * from jijifenzi where  JJFZ_Id=#{jjfzId} ")
    Jijifenzi  queryAll(Integer jjfzId);

    //根据id修改
    @Update("update jijifenzi set Jjfz_Name=#{jjfzName},Jjfz_Native=#{jjfzNative},Jjfz_Time=#{jjfzTime},Jjfz_Wenhua=#{jjfzWenhua},Jjfz_Village=#{jjfzVillage},Jjfz_Zu=#{jjfzZu},Jjfz_Shenfenzheng=#{jjfzShenfenzheng},Jjfz_Danwei=#{jjfzDanwei},Jjfz_Zhiwu=#{jjfzZhiwu},Jjfz_Sex=#{jjfzSex},Jjfz_Phone=#{jjfzPhone},Jjfz_Year=#{jjfzYear} where JJFZ_Id=#{jjfzId}")
    int  UpdateJijifenzi(Integer jjfzId);



}
//record
//        0
//        jjfzId	null
//        jjfzName	null
//        jjfzNative	null
//        jjfzTime	null
//        jjfzWenhua	null
//        jjfzVillage	null
//        jjfzZu	null
//        jjfzEntity	null
//        jjfzDanwei	null
//        jjfzZhiwu	null
//        jjfzSex	null
//        jjfzPhone	null
//        jjfzYear	null
//        jjfzShenfenzheng	null
//        jjfzXuhao	null

