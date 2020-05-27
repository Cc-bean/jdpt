//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.repository;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Law;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component("lawMapper")
public interface LawMapper {
    @Select({"select * from law inner join lawtype on law.L_Type=lawtype.L_Key where lawtype.L_name=#{L_name}"})
    Page<Law> queryLaw_yyq(String L_name);
}
