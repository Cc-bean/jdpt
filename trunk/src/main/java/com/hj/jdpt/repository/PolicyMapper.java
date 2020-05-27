//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.repository;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Policy;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component("policyMapper")
public interface PolicyMapper {
    @Select({"select * from policy where P_Type=#{type_id}"})
    Page<Policy> queryPolicyByType_yyq(Integer type_id);
}
