package com.hj.jdpt.repository;


import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Resources;
import com.hj.jdpt.domain.Resourcesdetails;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component(value = "resourcesdetailsMapper")
public interface ResourcesdetailsMapper {
    /**
     * 查询房产数量
     */

    @Select("select count(*) from ResourcesDetails where RD_ResourcesId in (select Resources_Id from Resources where R_Villageid =#{id})")
    int findResourcesDetailsbyCunId(int cunid);
    /**
     * 查询某个房产详情
     */
    @Select("select * from ResourcesDetails where RD_ResourcesId in (select Resources_Id from Resources where R_Villageid =#{id})")
    List<Resourcesdetails> findResourcesDetail(int id);

    /**
     * 查询房产的名字
     */
    @Select("select RD_Name from ResourcesDetails where RD_ResourcesId in (select Resources_Id from Resources where R_Villageid =#{id})")
    List<String> findResourcesName(int id);



    /**
     * 查询全部房产详情
     */
    @Select("select * from ResourcesDetails ")
    List<Resourcesdetails> findResourcesDetails();

    /**
     * 通过村id查找资源详情
     * @param villageId
     * @return
     */
    @Select("select * from ResourcesDetails  rd " +
            "join resources r on rd.RD_ResourcesId=r.Resources_Id " +
            "where r.R_Villageid=#{villageId} ")
    Page<Map<String,Object>> findResourceDetaile(Integer villageId);
}