package com.hj.jdpt.repository;


import java.util.List;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Jijifenzi;
import com.hj.jdpt.domain.Yvbeidangyuan;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component(value = "yvbeidangyuanMapper")
public interface YvbeidangyuanMapper {

    @Select("select * from yvbeidangyuan where YBDY_Year=#{ybdyYear} and YBDY_Village=#{ybdyVillage}")
    Page<Yvbeidangyuan> pageFondYvbeidangyuanByYbdyYearandYbdyVillage(@Param("ybdyYear") Integer ybdyYear, @Param("ybdyVillage") Integer ybdyVillage);

    @Select("select * from v where YBDY_Year=#{ybdyYear} ")
    Page<Yvbeidangyuan> pageFondYvbeidangyuanByYbdyYear(Integer ybdyYear);

    @Select("select * from yvbeidangyuan where  YBDY_Village=#{ybdyVillage}")
    Page<Yvbeidangyuan> pageFondYvbeidangyuanByYbdyVillage(  Integer ybdyVillage);

    @Select("select * from yvbeidangyuan where YBDY_Village in(select Village_Id from village where V_Zhen_Xiang in(select zhen_Id from Zhen where Z_Name=#{zName}))")
    Page<Yvbeidangyuan>pageFindYvbeidangyuanByZName(String zName);

    @Select("select * from yvbeidangyuan where YBDY_Village in(select Village_Id from village where V_Zhen_Xiang in(select zhen_Id from Zhen where Z_Name=#{zName}))and YBDY_Village in(select Village_Id  from village where V_Name=#{vName})")
    Page<Yvbeidangyuan>pageYvbeidangyuanByVNameandZName(@Param("zName") String zName,@Param("vName")String vName);

    @Select("select * from yvbeidangyuan where YBDY_Village in(select Village_Id from village where V_Zhen_Xiang in(select zhen_Id from Zhen where Z_Name=#{zName}))and YBDY_Village in(select Village_Id  from village where V_Name=#{vName})and YBDY_Zu in(select Z_Key from Zu where Z_Key in(select QKBG_Zu from qingKuangBianGeng where QKBG_Time=#{qkbgTime}))")
    Page<Yvbeidangyuan>pageFindYvbeidangyuanByVNameandZNameandQkbgTime(@Param("zName") String zName,@Param("vName")String vName,@Param("qkbgTime")String qkbgTime);

    //查询所有预备党员
    @Select("select * from yvbeidangyuan ")
    Page<Yvbeidangyuan> selectYvbeidangyuan ();

    //根据id删除一条数
    @Delete("delete from yvbeidangyuan where  YBDY_Id=#{ybdyId}")
    int  DeleteYvbeidangyuan(Integer ybdyId);

    //同时删除多条数据
    @Delete("delete from yvbeidangyuan where   YBDY_Id=#{ybdyId} ")
    int  DeleteDuoTiaoYvbeidangyuan(String ybdyId );

    //插入
    @Insert("insert into yvbeidangyuan (YBDY_Name,YBDY_Native,YBDY_Time,YBDY_Wenhua,YBDY_Village,YBDY_Zu,YBDY_Shenfenzheng,YBDY_Danwei,YBDY_Zhiwu,YBDY_Sex,YBDY_Phone,YBDY_Year)values(#{ybdyName},#{ybdyNative},#{ybdyTime},#{ybdyWenhua},#{ybdyVillage},#{ybdyZu},#{ybdyShenfenzheng},#{ybdyDanwei},#{ybdyZhiwu},#{ybdySex},#{ybdyPhone},#{ybdyYear}) ")
    int InsertYvbeidangyuan();
    //根据id查询
    @Select("select * from yvbeidangyuan where  YBDY_Id=#{ybdyId} ")
    Yvbeidangyuan  queryAll(Integer ybdyId);

    //根据id修改
    @Update("update jijifenzi set YBDY_Name=#{ybdyName},YBDY_Native=#{ybdyNative},YBDY_Time=#{ybdyTime},YBDY_Wenhua=#{ybdyWenhua},YBDY_Village=#{ybdyVillage},YBDY_Zu=#{ybdyZu},YBDY_Shenfenzheng=#{ybdyShenfenzheng},YBDY_Danwei=#{ybdyDanwei},YBDY_Zhiwu=#{ybdyZhiwu},YBDY_Sex=#{ybdySex},YBDY_Phone=#{ybdyPhone},YBDY_Year=#{ybdyYear} where YBDY_Id=#{ybdyId}")
    int  UpdateYvbeidangyuan(Integer jjfzId);

}