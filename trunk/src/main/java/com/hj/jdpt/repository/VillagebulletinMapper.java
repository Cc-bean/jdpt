//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.repository;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Villagebulletin;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component("villagebulletinMapper")
public interface VillagebulletinMapper {
    @Select({"select * from villagebulletin where VB_Villageid=#{id}"})
    List<Villagebulletin> FindVillagebulletinByCunId(Integer id);

    @Select({"select * from villagebulletin where VB_Villageid=#{id}"})
    Page<Villagebulletin> PageFindVillagebulletinByCunId(Integer id);

    @Select({"select * from villagebulletin where VillageBulletin_Id=#{id}"})
    Villagebulletin FindVillagebulletinById(Integer id);

    @Select({"select * from villagebulletin  where VB_Villageid=#{id} order by VB_LanchTime desc limit 10"})
    List<Villagebulletin> Gundongtiao(Integer id);
}
