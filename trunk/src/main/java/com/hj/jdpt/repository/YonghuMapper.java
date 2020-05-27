//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.repository;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Yonghu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component("yonghuMapper")
public interface YonghuMapper {
    @Select({"select * from yonghu"})
    Page<Yonghu> queryAll();

    @Select({"select * from yonghu where User_Accountid = #{userAccountid} and User_Password = #{userPassword}"})
    Yonghu checkLogin(@Param("userAccountid") String userAccountid, @Param("userPassword") String userPassword);

    @Select({"select * from yonghu where User_Id=#{id}"})
    Yonghu queryById(Integer id);

    @Select({"select * from yonghu where User_Accountid = #{userAccountid}"})
    Yonghu checkVLogin(String userAccountid);

    @Update({"update yonghu set User_Password = #{userPassword} where User_Id = #{userId}"})
    Boolean changePwd(Yonghu yonghu);

    @Select({"select * from yonghu where User_Id=#{id} "})
    Yonghu findInfo(Integer id);

    @Update({"update yonghu set User_Name=#{userName},User_Sex=#{userSex},User_EntityId=#{userEntityid},User_Phone=#{userPhone},User_Address=#{userAddress},User_Nation=#{userNation},User_Politicalstatus=#{userPoliticalstatus} where User_Id=#{userId}"})
    boolean Update(Yonghu yonghu);
}
