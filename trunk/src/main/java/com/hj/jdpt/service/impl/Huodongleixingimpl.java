package com.hj.jdpt.service.impl;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Dangyuanzuzhihuodong;
import com.hj.jdpt.domain.HuodongleixingAndDangYuanZuZhiHuoDong;
import com.hj.jdpt.repository.DangyuanzuzhihuodongMapper;
import com.hj.jdpt.repository.HuodongleixingMapper;
import com.hj.jdpt.service.Huodongleixing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class Huodongleixingimpl implements Huodongleixing {

    @Autowired
    HuodongleixingMapper huodongleixingMapper;
    @Override   //根据村id查询所有相关活动类型以及具体活动详情
    public List<HuodongleixingAndDangYuanZuZhiHuoDong> queryAll(Integer cun_id) {
        List<HuodongleixingAndDangYuanZuZhiHuoDong> list=huodongleixingMapper.queryAll(cun_id);

       /*for (HuodongleixingAndDangYuanZuZhiHuoDong huoDong:list){
            List<Dangyuanzuzhihuodong> list1=huoDong.getDangyuanzuzhihuodong();
            Iterator<Dangyuanzuzhihuodong> it = list1.iterator();
            while (it.hasNext()){
                Dangyuanzuzhihuodong dangyuanzuzhihuodong=it.next();
                if(dangyuanzuzhihuodong.getDyzzhdVillageid()!=cun_id){
                    it.remove();
                }
            }
        }*/
        return list;
    }

    @Override
    public Page<HuodongleixingAndDangYuanZuZhiHuoDong> queryAllLeiXing(Integer cun_id) {
        return huodongleixingMapper.queryAllLeixing(cun_id);
    }


    @Autowired
    DangyuanzuzhihuodongMapper dangyuanzuzhihuodongMapper;
    @Override
    public Page<Dangyuanzuzhihuodong> queryAllHD(Integer LX_id, Integer cun_id) {
        return dangyuanzuzhihuodongMapper.queryAllHD(LX_id,cun_id);
    }
}
