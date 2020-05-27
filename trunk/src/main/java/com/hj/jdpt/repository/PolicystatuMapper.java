//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.repository;

import com.hj.jdpt.domain.Policystatu;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component("policystatuMapper")
public interface PolicystatuMapper {
    @Select({"select * from policystatu where P_Key=#{id}"})
    Policystatu FindPolicystatuById(Integer id);

    @Select({"select * from policystatu"})
    List<Policystatu> PolicystatuList();
}
