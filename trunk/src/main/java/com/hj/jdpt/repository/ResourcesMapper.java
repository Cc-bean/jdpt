//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.repository;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Resources;
import com.hj.jdpt.domain.Resourcesdetails;
import com.hj.jdpt.domain.Zu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("resourcesMapper")
public interface ResourcesMapper {
    @Select({"select * from zu where Z_Key in (select R_zu from resources where R_Villageid =#{cunid})"})
    Page<Zu> queryByCunIdZu(int cunid);

    @Select({"select resources.* ,Resources_Id  resourceid from  resources where  resources.R_Villageid = #{cunid} and resources.R_zu = #{zuid}"})
    List<Map<String, Object>> queryByCunZuId(@Param("cunid") int cunid, @Param("zuid") int zuid);

    @Select({"select * from resourcesDetails where RD_ResourcesId in (select Resources_Id from resources where R_Villageid =#{cunid} and R_zu = #{zuid} and R_Type =#{R_type})"})
    Page<Resourcesdetails> findResourcesName(@Param("cunid") int cunid, @Param("zuid") int zuid, @Param("R_type") int R_type);

    @Select({"select * from resources"})
    List<Resources> queryAll();
}
