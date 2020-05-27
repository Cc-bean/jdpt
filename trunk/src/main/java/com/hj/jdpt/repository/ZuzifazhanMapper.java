package com.hj.jdpt.repository;

        import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Zuzifazhan;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


@Component(value = "zuzifazhanMapper")
public interface ZuzifazhanMapper {
    //根据名字查询
    @Select("Select * from zuzifazhan where ZZFZ_Name like '%${value}%'")
    Page<Zuzifazhan> GetByName(String value);

    //根据entity查询
    @Select("select * from zuzifazhan where ZZFZ_Entity=#{entity}  and ZZFZ_Village=#{villageId}")
    Page<Zuzifazhan>GetInfoByEntity(@Param("entity") String entity, @Param("villageId") Integer villageId);

    //根据名字和身份查询
    @Select("Select * from zuzifazhan where ZZFZ_Name like '%${value}%'and ZZFZ_Entity=#{entity}")
    Page<Zuzifazhan> GetByNameAndEntity(@Param("value") String value, @Param("entity") String entity);

    //根据村id查村名
    @Select("Select V_Name from village where Village_Id=#{villageId}")
    String GetVillageById(Integer villageId);

    //根据手机号查村id
    @Select("Select User_VillageId from yonghu where User_Accountid=#{phone}")
    Integer GetVillageId(String phone);

    //根据组id查组名
    @Select("Select Z_Name from zu where Z_Key=#{zuId}")
    String GetZuById(Integer zuId);

    //根据年份查询
    @Select("Select * from zuzifazhan where JJFZ_Time  between #{time1} and #{time2}" +
            "or FZDX_Time between #{time1} and #{time2}" +
            "or YBDY_Time between #{time1} and #{time2}" +
            "or ZSDY_Time between #{time1} and #{time2} and ZZFZ_Village=#{villageId}" )
    Page<Zuzifazhan> FindByYear(@Param("time1") String time1, @Param("time2") String time2, @Param("villageId") Integer villageId);

    //根据年份和身份查询
    @Select("Select * from zuzifazhan where ZZFZ_Entity=#{entity} and JJFZ_Time between #{time1} and #{time2} and ZZFZ_Village=#{villageId}")
    Page<Zuzifazhan> FindByjjfzTime(@Param("entity") String entity, @Param("time1") String time1, @Param("time2") String time2, @Param("villageId") Integer villageId);

    @Select("Select * from zuzifazhan where ZZFZ_Entity=#{entity} and FZDX_Time between #{time1} and #{time2} and ZZFZ_Village=#{villageId}")
    Page<Zuzifazhan> FindByfzdxTime(@Param("entity") String entity, @Param("time1") String time1, @Param("time2") String time2, @Param("villageId") Integer villageId);

    @Select("Select * from zuzifazhan where ZZFZ_Entity=#{entity} and YBDY_Time between #{time1} and #{time2} and ZZFZ_Village=#{villageId}")
    Page<Zuzifazhan> FindByybdyTime(@Param("entity") String entity, @Param("time1") String time1, @Param("time2") String time2, @Param("villageId") Integer villageId);

    @Select("Select * from zuzifazhan where ZZFZ_Entity=#{entity} and ZSDY_Time between #{time1} and #{time2} and ZZFZ_Village=#{villageId}")
    Page<Zuzifazhan> FindByzsdyTime(@Param("entity") String entity, @Param("time1") String time1, @Param("time2") String time2, @Param("villageId") Integer villageId);

}
