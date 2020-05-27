package com.hj.jdpt.repository;

import java.util.List;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Dangyuanzuzhihuodong;
import com.hj.jdpt.domain.HuodongleixingAndDangYuanZuZhiHuoDong;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component(value = "dangyuanzuzhihuodongMapper")
public interface DangyuanzuzhihuodongMapper {
    @Select("SELECT distinct dangyuanzuzhihuodong.* FROM ygjjjdptde.huodongleixing ,ygjjjdptde.dangyuanzuzhihuodong where dangyuanzuzhihuodong.DYZZHD_Villageid =(select huodongleixing.HDLX_Village from ygjjjdptde.huodongleixing where huodongleixing.HDLX_Id=#{id}) and dangyuanzuzhihuodong.DYZZHD_LeiXing=#{id};")
    List<Dangyuanzuzhihuodong> queryAllByHDLX_Id(@Param("id") Integer id);


    @Select("select * from dangyuanzuzhihuodong where DYZZHD_Villageid=#{cun_id} and DYZZHD_LeiXing=#{LX_id}")
    Page<Dangyuanzuzhihuodong> queryAllHD(@Param("LX_id")Integer LX_id,@Param("cun_id")Integer cun_id);


    @Select("select * from dangyuanzuzhihuodong where DYZZHD_Id=#{id}")
    Dangyuanzuzhihuodong queryBy_id(Integer id);
}