package com.hj.jdpt.repository;


import java.util.List;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Fazhanduixiang;
import com.hj.jdpt.domain.Jijifenzi;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component(value ="fazhanduixiangMapper" )
public interface FazhanduixiangMapper {

    @Select("select * from fazhanduixiang where FZDX_Year=#{fzdxYear} and FZDX_Village=#{fzdxVillage}")
    Page<Fazhanduixiang> pageFindFazhanduixiangByFzdxYearandFzdxVillage(@Param("fzdxYear") Integer fzdxYear, @Param("fzdxVillage")Integer fzdxVillage);

    @Select("select * from fazhanduixiang where FZDX_Year=#{fzdxYear} ")
    Page<Fazhanduixiang> pageFindFazhanduixiangByFzdxYear( Integer fzdxYear);

    @Select("select * from fazhanduixiang where FZDX_Village=#{fzdxVillage}")
    Page<Fazhanduixiang> pageFindFazhanduixiangByFzdxVillage(Integer fzdxVillage);

    @Select("select * from fazhanduixiang where FZDX_Village in(select Village_Id from village where V_Zhen_Xiang in(select zhen_Id from Zhen where Z_Name=#{zName}))")
    Page<Fazhanduixiang>pageFindFazhanduixiangByZName(String zName);

    @Select("select * from fazhanduixiang where FZDX_Village in(select Village_Id from village where V_Zhen_Xiang in(select zhen_Id from Zhen where Z_Name=#{zName}))and FZDX_Village in(select Village_Id  from village where V_Name=#{vName})")
    Page<Fazhanduixiang>pageFindFazhanduixiangByVNameandZName(@Param("zName") String zName,@Param("vName")String vName);

    @Select("select * from fazhanduixiang where FZDX_Village in(select Village_Id from village where V_Zhen_Xiang in(select zhen_Id from Zhen where Z_Name=#{zName}))and FZDX_Village in(select Village_Id  from village where V_Name=#{vName}) and FZDX_Zu in(select Z_Key from Zu where Z_Key in(select QKBG_Zu from qingKuangBianGeng where QKBG_Time=#{qkbgTime}))")
    Page<Fazhanduixiang>pageFindFazhanduixiangByVNameandZNameandQkbgTime(@Param("zName") String zName,@Param("vName")String vName,@Param("qkbgTime")String qkbgTime);

    //查询所有发展对象
    @Select("select * from fazhanduixiang ")
    Page<Fazhanduixiang> selectFazhanduixiang ();

    //根据id删除一条数据
    @Delete("delete from fazhanduixiang where FZDX_Id=#{fzdxId}")
    int  DeleteFazhanduixiang(Integer fzdxId);

    //同时删除多条数据
    @Delete("delete from fazhanduixiang where FZDX_Id=#{fzdxId}")
    int  DeleteDuoTiaoFazhanduixiang(String fzdxId );

    //插入
    @Insert("insert into fazhanduixiang (FZDX_Name,FZDX_Native,FZDX_Time,FZDX_Wenhua,FZDX_Village,FZDX_Zu,FZDX_Shenfenzheng,FZDX_Danwei,FZDX_Zhiwu,FZDX_Sex,FZDX_Phone,FZDX_Year)values(#{fzdxName},#{fzdxNative},#{fzdxTime},#{fzdxWenhua},#{fzdxVillage},#{fzdxZu},#{fzdxShenfenzheng},#{fzdxDanwei},#{fzdxZhiwu},#{fzdxSex},#{fzdxPhone},#{fzdxYear}) ")
    int InsertFazhanduixiang();
    //根据id查询
    @Select("select * from fazhanduixiang where  FZDX_Id =#{fzdxId}")
    Fazhanduixiang  queryAll(Integer fzdxId);

    //根据id修改
    @Update("update fazhanduixiang set FZDX_Name=#{fzdxName},FZDX_Native=#{fzdxNative},FZDX_Time=#{fzdxTime},FZDX_Wenhua=#{fzdxWenhua},FZDX_Village=#{fzdxVillage},FZDX_Zu=#{fzdxZu},FZDX_Shenfenzheng=#{fzdxShenfenzheng},FZDX_Danwei=#{fzdxDanwei},FZDX_Zhiwu=#{fzdxZhiwu},FZDX_Sex=#{fzdxSex},FZDX_Phone=#{fzdxPhone},FZDX_Year=#{fzdxYear} where FZDX_Id=#{fzdxId}")
    int  UpdateFazhanduixiang(Integer fzdxId);
}