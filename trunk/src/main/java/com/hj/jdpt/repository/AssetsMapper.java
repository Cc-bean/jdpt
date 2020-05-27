package com.hj.jdpt.repository;


import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Assets;
import com.hj.jdpt.domain.Zu;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "assetsMapper")
public interface AssetsMapper {
      @Insert("insert int(A_Type,A_Villageid,A_beiyong1,A_beiyong2,A_Zu) values(#{aType},#{aVillageid},#{aBeiyong1},#{aBeiyong2},#{aZu})")
      @Options(useGeneratedKeys = true, keyProperty = "assetsId")
      int insert( Assets assets );
      @Delete("delete from assets where Assets_Id=#{asId}")
      int delete(int asId);
      @Update("update assets set A_Type=#{aType} , A_Villageid=#{aVillageid}  ,  A_beiyong1=#{aBeiyong1} , A_beiyong2=#{aBeiyong2} ,A_Zu=#{aZu}" +
              "  where Assets_Id=#{assetsId}")
      int update(Assets assets );
      @Select("select * from assets")
      List<Assets> queryAll();
      @Select("select * from assets where Assets_Id=#{id}")
      Assets  selectAssets(int id);
      @Select("select * from assets where A_VillageId = #{villageId}")
      Page<Assets> pageFindAssetsByVillageId(Integer villageId);
      @Select("select * from assets where A_Zu = #{zuId}")
      Page<Assets> pageFindAssetsByZuId(int zuId);
      @Select("select * from assets where A_VillageId=#{vId} and A_Zu=#{zId}")
      Page<Assets> pageFindAssetsByZuVillage(@Param("vId") int vId, @Param("zId")int zId);
      @Select("select * from zu where Z_village=#{villageId}")
      List<Zu> findZuById(int villageId);

}