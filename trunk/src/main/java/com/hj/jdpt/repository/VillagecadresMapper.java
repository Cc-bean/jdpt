package com.hj.jdpt.repository;


import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Job;
import com.hj.jdpt.domain.Villagecadres;
import com.hj.jdpt.domain.VillagecadresAndJob;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "villagecadresMapper")
public interface VillagecadresMapper {

    @Select("select * from villagecadres")
    List<Villagecadres> querryAll();  //查询所有村干部

    @Select("select * from villagecadres where VC_VillageId=#{id}")
    List<Villagecadres> FindByCunId(Integer id); //根据村id查所有的村干部

    @Select("select * from villagecadres where VillageCadres_Id=#{id}")
    Villagecadres FindVillagecadresById(Integer id);   //根据id查村干部

    @Select("select * from villagecadres where VC_VillageId=#{id}")
    @Results({
            @Result(property = "job",column = "VC_Post",javaType = Job.class,one = @One(select = "com.hj.jdpt.repository.JobMapper.FindJobById"))
    })
    Page<VillagecadresAndJob> PageFindVillagecadres(Integer id);   //根据村id分页查询所有村干部


}