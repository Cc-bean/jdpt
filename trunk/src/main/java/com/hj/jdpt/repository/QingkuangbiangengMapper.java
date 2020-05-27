package com.hj.jdpt.repository;


import java.util.List;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Qingkuangbiangeng;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component(value = "qingkuangbiangengMapper")
public interface QingkuangbiangengMapper {

    @Select("select * from qingkuangbiangeng where QKBG_Year=#{qkbgYear} and QKBG_Zu in(select Z_Key from zu where Z_village=#{zVillage})")
    Page< Qingkuangbiangeng> pageFindQingkuangbiangengByQkbgYearandVillageId(@Param("qkbgYear") Integer qkbgYear, @Param("zVillage")Integer zVillage);

    @Select("select * from qingkuangbiangeng where QKBG_Year=#{qkbgYear} ")
    Page< Qingkuangbiangeng> pageFindQingkuangbiangengByQkbgYear( Integer qkbgYear);

    @Select("select * from qingkuangbiangeng where QKBG_Zu in(select Z_Key from zu where Z_village=#{zVillage})")
    Page< Qingkuangbiangeng> pageFindQingkuangbiangengByVillageId(Integer zVillage);

    @Select("select * from qingKuangBianGeng")
    Page<Qingkuangbiangeng> query();


}