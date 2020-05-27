package com.hj.jdpt.repository;


import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Assetsdetails;
import com.hj.jdpt.domain.Zichanjingying;
import com.hj.jdpt.domain.Zichantaizhang;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component(value = "assetsdetailsMapper")
public interface AssetsdetailsMapper {
    @Select("select * from Assetsdetails")
    List<Assetsdetails> findAll();
    @Select("select * from assetsdetails where AssetsDetails_Id=#{assetsdetailsId}")
    Assetsdetails findAssetsdetails(int assetsdetailsId);
    @Select("select * from Assetsdetails where AD_AssetsId=#{assetsId}")
    Page<Assetsdetails> findByAssetsId(int assetsId);
    @Insert("insert into Assetsdetails(AD_Name,AD_Details,AD_AssetsId,AD_beiyong1,AD_beiyong2,AD_Money) values(#{adName},#{adDetails},#{adAssetsid},#{adBeiyong1},#{adBeiyong2},#{adMoney})")
    @Options(useGeneratedKeys = true, keyProperty = "assetsdetailsId")
    int insert(Assetsdetails assetsdetails);
    @Delete("delete from assetsdetails where AssetsDetails_Id=#{assetsdetails}")
    int delete(int assetsdetails);
    @Update("update Assetsdetails set AD_Name=#{adName} , AD_Details=#{adDetails}  ,  AD_AssetsId=#{adAssetsid} , AD_beiyong1=#{adBeiyong1} ,AD_beiyong2=#{adBeiyong2},AD_Money=#{adMoney}" +
            "  where AssetsDetails_Id=#{assetsdetailsId}")
    int update(Assetsdetails assetsdetails);

    /**
     * 通过村id查找资产详情
     */
    @Select("select * from zichanmingzi zcmz " +
            "join assets a on zcmz.ZCMZ_LeiXing = a.Assets_Id " +
            "where a.A_Villageid=#{villageid}")
    Page<Map<String,Object>> findAssetsDetailsByCunid(Integer villageid);

    /**
     * 总过资产名字表id查找资产经营表
     */
    @Select("select * from zichantaizhang  where ZJTZ_Name =#{ZCMZ_Id} ")
    Zichantaizhang findZiChanFJY(Integer ZCMZ_Id);
    /**
     * 总过资产名字表id查找资产非经营表
     */
    @Select("select * from zichanjingying  where ZCJY_Name =#{ZCMZ_Id} ")
    Zichanjingying findZiChanJY(Integer ZCMZ_Id);

}