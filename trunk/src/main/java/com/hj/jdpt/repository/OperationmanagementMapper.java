//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.repository;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Operationmanagement;
import com.hj.jdpt.vo.OperationRegionName_GX;
import com.hj.jdpt.vo.OperationmanagementVO_GX;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Component;

@Component("operationmanagementMapper")
public interface OperationmanagementMapper {
    @Select({"select OperationManagement_Id,OM_Villageid,OM_Name,OM_TenderingMaterial,OM_ImplementingParty,OM_SourceOfFunds,OM_ImplementThePlan,OM_Acceptanceparty,OM_FollowUpManagement,OM_DivisionOfResponsibility,OM_Villageid,OM_Type from operationManagement where OM_Villageid=#{cunId}"})
    @Results({@Result(
            property = "OperationManagement_Id",
            column = "OperationManagement_Id"
    ), @Result(
            property = "OM_Name",
            column = "OM_Name"
    ), @Result(
            property = "OM_Type",
            column = "OM_Type"
    ), @Result(
            property = "OM_TenderingMaterial",
            column = "OM_TenderingMaterial"
    ), @Result(
            property = "OM_ImplementingParty",
            column = "OM_ImplementingParty"
    ), @Result(
            property = "OM_SourceOfFunds",
            column = "OM_SourceOfFunds"
    ), @Result(
            property = "OM_ImplementThePlan",
            column = "OM_ImplementThePlan"
    ), @Result(
            property = "OM_Acceptanceparty",
            column = "OM_Acceptanceparty"
    ), @Result(
            property = "OM_FollowUpManagement",
            column = "OM_FollowUpManagement"
    ), @Result(
            property = "OM_DivisionOfResponsibility",
            column = "OM_DivisionOfResponsibility"
    ), @Result(
            property = "names",
            column = "OM_Villageid",
            one = @One(
                    select = "com.hj.jdpt.repository.OperationmanagementMapper.queryNames",
                    fetchType = FetchType.EAGER
            )
    )})
    Page<OperationmanagementVO_GX> queryOperationManagment(int cunId);

    @Select({"select OM_Name,OM_Type,OM_TenderingMaterial,OM_ImplementingParty,OM_SourceOfFunds,OM_ImplementThePlan,OM_Acceptanceparty,OM_FollowUpManagement,OM_DivisionOfResponsibility,OM_Villageid,OM_Type from operationManagement where OM_Name like CONCAT('%',#{Name},'%') and OM_Villageid=#{cunId}"})
    @Results({@Result(
            property = "OperationManagement_Id",
            column = "OperationManagement_Id"
    ), @Result(
            property = "OM_Name",
            column = "OM_Name"
    ), @Result(
            property = "OM_Type",
            column = "OM_Type"
    ), @Result(
            property = "OM_TenderingMaterial",
            column = "OM_TenderingMaterial"
    ), @Result(
            property = "OM_ImplementingParty",
            column = "OM_ImplementingParty"
    ), @Result(
            property = "OM_SourceOfFunds",
            column = "OM_SourceOfFunds"
    ), @Result(
            property = "OM_ImplementThePlan",
            column = "OM_ImplementThePlan"
    ), @Result(
            property = "OM_Acceptanceparty",
            column = "OM_Acceptanceparty"
    ), @Result(
            property = "OM_FollowUpManagement",
            column = "OM_FollowUpManagement"
    ), @Result(
            property = "OM_DivisionOfResponsibility",
            column = "OM_DivisionOfResponsibility"
    ), @Result(
            property = "names",
            column = "OM_Villageid",
            one = @One(
                    select = "com.hj.jdpt.repository.OperationmanagementMapper.queryNames",
                    fetchType = FetchType.EAGER
            )
    )})
    Page<OperationmanagementVO_GX> queryOperationManagmentByName(@Param("Name") String name, @Param("cunId") int cunId);

    @Select({"select R_name from region where R_key=#{id}"})
    String queryRegionNameByID(int id);

    @Select({"select Z_Name from zhen where Zhen_Id=#{id}"})
    String queryZhengXiangNameByID(int id);

    @Select({"select V_Name,V_Zhen_xiang,V_Region from village where Village_Id=#{id}"})
    @Results({@Result(
            id = true,
            property = "VillageName",
            column = "V_Name"
    ), @Result(
            property = "ZhenName",
            column = "V_Zhen_xiang",
            one = @One(
                    select = "com.hj.jdpt.repository.OperationmanagementMapper.queryZhengXiangNameByID",
                    fetchType = FetchType.EAGER
            )
    ), @Result(
            property = "RegionName",
            column = "V_Region",
            one = @One(
                    select = "com.hj.jdpt.repository.OperationmanagementMapper.queryRegionNameByID",
                    fetchType = FetchType.EAGER
            )
    )})
    OperationRegionName_GX queryNames(int id);

    @Select({"select * from operationManagement where OperationManagement_Id=#{id}"})
    Operationmanagement queryOperationManagementFindById(int id);
}
