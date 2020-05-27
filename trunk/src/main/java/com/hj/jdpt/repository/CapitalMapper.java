package com.hj.jdpt.repository;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Capital;
import com.hj.jdpt.domain.Zichanjingying;
import com.hj.jdpt.domain.Zichanmingzi;
import com.hj.jdpt.domain.Zichantaizhang;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "capitalMapper")
public interface CapitalMapper {
    @Select("select * from capital")
    List<Capital> findAll();
    @Select("select * from capital where Capital_Id=#{capitalId}")
    Capital findCapital(int capitalId);
    @Insert("insert into capital(C_Type,C_Villageid,CD_Income,CD_Expenditure,CD_Beiyong1,CD_Beiyong2,CD_zu,CD_xuhao) values" +
            "(#{cType},#{cVillageid},#{cdIncome},#{cdExpenditure},#{cdBeiyong1},#{cdBeiyong2},#{cdZu},#{cdXuhao})")
    @Options(useGeneratedKeys = true, keyProperty = "capitalId")
    int insert(Capital capital);
    @Delete("delete from capital where Capital_Id=#{capitalId}")
    int delete(int capitalId);
    @Update("update capital set C_Type=#{cType} , C_Villageid=#{cVillageid}  ,  CD_Income=#{cdIncome} , CD_Expenditure=#{cdExpenditure} ,CD_Beiyong1=#{cdBeiyong1},CD_Beiyong2=#{cdBeiyong2}," +
            "CD_zu=#{cdZu}, CD_xuhao=#{cdXuhao} where Capital_Id=#{capitalId}")
    int update(Capital capital);
    @Select("select * from capital where C_Villageid=#{villageId}")
    Page<Capital> findByCaptical(int villageId);
    @Select("select * from capital where C_Villageid=#{villageId} and CD_zu=#{zuId} ")
    Page<Capital> findByCapticalZu(@Param("villageId") int villageId,@Param("zuId")int zuId);
    @Select("select * from capital where  CD_Income=#{year} and C_Villageid=#{villageId} and CD_zu=#{zuId} and C_Type like CONCAT('%',#{style},'%')")
    Page<Capital> findByYearStyle(@Param("villageId")int villageId,@Param("year")String year,@Param("zuId")int zuId ,@Param("style")String style);
    @Select("select * from capital where Capital_Id=#{capitalId}")
    Capital countByassetsId(int capitalId);
    //根据村id，组id，和资金类型查找资金EWERW
    @Select("select * from capital where C_Villageid=#{villageId} and CD_zu=#{zuId} and C_Type like CONCAT('%',#{style},'%') ")
    Page<Capital> findByStyleVidZuid(@Param("villageId") int villageId,@Param("zuId")int zuId,@Param("style")String style);
    @Select("select * from ZiChanMingZi where ZCMZ_LeiXing=#{assetsId}")
    Page<Zichanmingzi> findZichanmingziById(int assetsId);
    @Select("select * from ZiChanJingYing where ZCJY_Name=#{assetsName}")
    Zichanjingying findZichanjingyingById(int assetsName);
    @Select("select * from ZiChanTaiZhang where ZJTZ_Name=#{assetsName}")
    Zichantaizhang findZichantaizhangById(int assetsName);
}