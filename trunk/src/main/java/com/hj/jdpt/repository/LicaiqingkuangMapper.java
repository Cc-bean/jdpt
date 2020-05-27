package com.hj.jdpt.repository;

import com.hj.jdpt.domain.Licaiqingkuang;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("licaiqingkuangMapper")
public interface LicaiqingkuangMapper {
    @Select("select * from licaiqingkuang where LC_Id=#{lcId}")
    Licaiqingkuang findLiCaiById(int lcId);

    @SelectProvider(type = findLicaiByYear.class,method = "findLicaiByYear")
    List<Licaiqingkuang> findLicaiByYear(@Param("year") int year, @Param("month")int month,@Param("zuId")int zuId);

    class findLicaiByYear{
     public String findLicaiByYear(@Param("year") int year, @Param("month")int month,@Param("zuId")int zuId){
         SQL sql=new SQL();
         sql.SELECT("*");
         sql.FROM("licaiqingkuang");
         if(year!=0&&month==0){
            sql.AND();
            sql.WHERE("LC_year=#{year} and LC_zu =#{zuId}");
         }
         if(year!=0&&month!=0){
             sql.AND();
             sql.WHERE("LC_year=#{year} and LC_month=#{month} and LC_zu =#{zuId}");
         }
         return sql.toString();
     }

    }
}