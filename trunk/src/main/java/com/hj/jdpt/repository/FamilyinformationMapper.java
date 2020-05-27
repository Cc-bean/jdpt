//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.repository;

import com.hj.jdpt.domain.Familyinformation;
import com.hj.jdpt.domain.FamilyinformationForeign;
import com.hj.jdpt.domain.Nation;
import com.hj.jdpt.domain.Policystatu;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component("familyinformationMapper")
public interface FamilyinformationMapper {
    @Select({"select * from familyinformation where FI_PeopleId=#{userid}"})
    @Results({@Result(
            property = "nation",
            column = "FI_nation",
            javaType = Nation.class,
            one = @One(
                    select = "com.hj.jdpt.repository.NationMapper.FindNationById"
            )
    ), @Result(
            property = "policystatu",
            column = "FI_Politicalstatus",
            javaType = Policystatu.class,
            one = @One(
                    select = "com.hj.jdpt.repository.PolicystatuMapper.FindPolicystatuById"
            )
    )})
    List<FamilyinformationForeign> FindJTCY(Integer userid);

    @Select({"select * from familyinformation where FamilyInformation_Id=#{id}"})
    @Results({@Result(
            property = "nation",
            column = "FI_nation",
            javaType = Nation.class,
            one = @One(
                    select = "com.hj.jdpt.repository.NationMapper.FindNationById"
            )
    ), @Result(
            property = "policystatu",
            column = "FI_Politicalstatus",
            javaType = Policystatu.class,
            one = @One(
                    select = "com.hj.jdpt.repository.PolicystatuMapper.FindPolicystatuById"
            )
    )})
    FamilyinformationForeign Info(Integer id);

    @Delete({"delete from familyinformation where FamilyInformation_Id=#{id}"})
    boolean Delete(Integer id);

    @Insert({"insert into familyinformation (FI_PeopleId,FI_Name,FI_Phone,FI_Relation,FI_sex,FI_entityId,FI_Politicalstatus,FI_nation) values (#{fiPeopleid},#{fiName},#{fiPhone},#{fiRelation},#{fiSex},#{fiEntityid},#{fiPoliticalstatus},#{fiNation})"})
    boolean Insert(Familyinformation familyinformation);

    @Update({"update familyinformation set FI_Name=#{fiName},FI_Phone=#{fiPhone},FI_Relation=#{fiRelation},FI_sex=#{fiSex},FI_entityId=#{fiEntityid},FI_Politicalstatus=#{fiPoliticalstatus},FI_nation=#{fiNation} where FamilyInformation_Id=#{familyinformationId}"})
    boolean Update(Familyinformation familyinformation);
}
