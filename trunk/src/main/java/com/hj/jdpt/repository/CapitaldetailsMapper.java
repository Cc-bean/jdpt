package com.hj.jdpt.repository;



import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Capitaldetails;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


@Component(value = "capitaldetailsMapper")
public interface CapitaldetailsMapper {
    @Select("select capitaldetails.* ,capitaldetails.CD_beiyong1 as files from capitaldetails where CapitalDetails_Id=#{capitaldetailsId}")
    Capitaldetails findCapitaldetails(int capitaldetailsId);
    @Select("select capitaldetails.* ,capitaldetails.CD_beiyong1 as files from capitaldetails where CD_ZiJinId=#{capitalId}")
    Page<Capitaldetails> findByZijinId(int capitalId);
    @Delete("delete from capitaldetails where CapitalDetails_Id=#{capitaldetailsId}")
    int delete(int capitaldetailsId);
}