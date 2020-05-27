//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.repository;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Job;
import com.hj.jdpt.domain.PartymemberinformationAndYonghu;
import com.hj.jdpt.domain.Yonghu;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component("partymemberinformationMapper")
public interface PartymemberinformationMapper {
    @Select({"select * from partymemberinformation where PM_Village=#{cun_id}"})
    @Results({@Result(
            property = "yonghu",
            column = "PM_YongHu",
            javaType = Yonghu.class,
            one = @One(
                    select = "com.hj.jdpt.repository.YonghuMapper.queryById"
            )
    ), @Result(
            property = "job",
            column = "PMI_Post",
            javaType = Job.class,
            one = @One(
                    select = "com.hj.jdpt.repository.JobMapper.queryById"
            )
    )})
    Page<PartymemberinformationAndYonghu> queryAll(Integer cun_Id);

    @Select({"select * from partymemberinformation where PM_yonghu in(select User_Id from yonghu where User_Name like '${value}%') and PM_Village=#{cun_id}"})
    @Results({@Result(
            property = "yonghu",
            column = "PM_YongHu",
            javaType = Yonghu.class,
            one = @One(
                    select = "com.hj.jdpt.repository.YonghuMapper.queryById"
            )
    ), @Result(
            property = "job",
            column = "PMI_Post",
            javaType = Job.class,
            one = @One(
                    select = "com.hj.jdpt.repository.JobMapper.queryById"
            )
    )})
    Page<PartymemberinformationAndYonghu> queryByName(@Param("value") String User_Name, @Param("cun_id") Integer cun_id);

    @Select({"select * from partymemberinformation where PartyMemberInformation_Id=#{id}"})
    @Results({@Result(
            property = "yonghu",
            column = "PM_YongHu",
            javaType = Yonghu.class,
            one = @One(
                    select = "com.hj.jdpt.repository.YonghuMapper.queryById"
            )
    ), @Result(
            property = "job",
            column = "PMI_Post",
            javaType = Job.class,
            one = @One(
                    select = "com.hj.jdpt.repository.JobMapper.queryById"
            )
    )})
    PartymemberinformationAndYonghu queryById(Integer id);
}
