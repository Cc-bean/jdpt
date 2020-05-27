package com.hj.jdpt.repository;

import java.util.List;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Dangyuanzhuanzheng;
import com.hj.jdpt.domain.Jijifenzi;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component(value = "dangyuanzhuanzhengMapper")
public interface DangyuanzhuanzhengMapper {

    @Select("select * from dangyuanzhuanzheng where DYZZ_Year=#{dyzzYear} and DYZZ_Village=#{dyzzVillage}")
    Page< Dangyuanzhuanzheng> pageFindDangyuanzhuanzhengByDyzzYearanDdyzzVillage(@Param("dyzzYear") Integer  dyzzYear, @Param("dyzzVillage")Integer dyzzVillage);

    @Select("select * from dangyuanzhuanzheng where DYZZ_Year=#{dyzzYear}")
    Page< Dangyuanzhuanzheng> pageFindDangyuanzhuanzhengByDyzzYear( Integer  dyzzYear);

    @Select("select * from dangyuanzhuanzheng where DYZZ_Village=#{dyzzVillage}")
    Page< Dangyuanzhuanzheng> pageFindDangyuanzhuanzhengByDyzzVillage( Integer dyzzVillage);

    @Select("select * from dangyuanzhuanzheng where DYZZ_Village in(select Village_Id from village where V_Zhen_Xiang in(select zhen_Id from Zhen where Z_Name=#{zName}))")
    Page<Dangyuanzhuanzheng>pageFindDangyuanzhuanzhengByZName(String zName);

    @Select("select * from dangyuanzhuanzheng where DYZZ_Village in(select Village_Id from village where V_Zhen_Xiang in(select zhen_Id from Zhen where Z_Name=#{zName}))and DYZZ_Village in(select Village_Id  from village where V_Name=#{vName})")
    Page<Dangyuanzhuanzheng>pageFindDangyuanzhuanzhengByVNameandZName(@Param("zName") String zName,@Param("vName")String vName);

    @Select("select * from dangyuanzhuanzheng where DYZZ_Village in(select Village_Id from village where V_Zhen_Xiang in(select zhen_Id from Zhen where Z_Name=#{zName}))and DYZZ_Village in(select Village_Id  from village where V_Name=#{vName})and DYZZ_Zu in(select Z_Key from Zu where Z_Key in(select QKBG_Zu from qingKuangBianGeng where QKBG_Time=#{qkbgTime}))")
    Page<Dangyuanzhuanzheng>pageFindDangyuanzhuanzhengByVNameandZNameandQkbgTime(@Param("zName") String zName,@Param("vName")String vName,@Param("qkbgTime")String qkbgTime);

    //查询所有党员
    @Select("select * from dangyuanzhuanzheng ")
    Page<Dangyuanzhuanzheng> selectdangyuanzhuanzheng ();

    //根据id删除一条数
    @Delete("delete from dangyuanzhuanzheng where  DYZZ_Id=#{dyzzId}")
    int  DeleteDangyuanzhuanzheng(Integer dyzzId);

    //同时删除多条数据
    @Delete("delete from dangyuanzhuanzheng where   DYZZ_Id=#{dyzzId} ")
    int  DeleteDuoTiaoDangyuanzhuanzheng(String dyzzId );

    //插入
    @Insert("insert into dangyuanzhuanzheng ( DYZZ_Name, DYZZ_Native, DYZZ_Time, DYZZ_Wenhua, DYZZ_Village, DYZZ_Zu, DYZZ_Shenfenzheng, DYZZ_Danwei, DYZZZhiwu, DYZZ_Sex, DYZZ_Phone, DYZZ_Year)values(#{dyzzName},#{dyzzNative},#{dyzzTime},#{dyzzWenhua},#{dyzzVillage},#{dyzzZu},#{dyzzShenfenzheng},#{dyzzDanwei},#{dyzzZhiwu},#{dyzzSex},#{dyzzPhone},#{dyzzYear}) ")
    int Insertdangyuanzhuanzheng();
    //根据id查询
    @Select("select * from dangyuanzhuanzheng where  DYZZ_Id=#{dyzzId} ")
    Dangyuanzhuanzheng  queryAll(Integer dyzzId);

    //根据id修改
    @Update("update dangyuanzhuanzheng set DYZZ_Name=#{dyzzName}, DYZZ_Native=#{dyzzNative}, DYZZ_Time=#{dyzzTime}, DYZZ_Wenhua=#{dyzzWenhua}, DYZZ_Village=#{dyzzVillage}, DYZZ_Zu=#{dyzzZu}, DYZZ_Shenfenzheng=#{dyzzShenfenzheng}, DYZZ_Danwei=#{dyzzDanwei}, DYZZ_Zhiwu=#{dyzzZhiwu}, DYZZ_Sex=#{dyzzSex}, DYZZ_Phone=#{dyzzPhone}, DYZZ_Year=#{dyzzYear} where  DYZZ_Id=#{dyzzId}")
    int  UpdateDangyuanzhuanzheng(Integer dyzzId);
}