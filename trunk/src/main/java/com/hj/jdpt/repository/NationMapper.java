//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.repository;

import com.hj.jdpt.domain.Nation;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface NationMapper {
    @Select({"select N_name from nation where N_Key=#{id}"})
    String queryById(Integer id);

    @Select({"select * from nation where N_Key=#{id}"})
    Nation FindNationById(Integer id);

    @Select({"select * from nation"})
    List<Nation> nationlist();
}
