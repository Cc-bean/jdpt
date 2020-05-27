package com.hj.jdpt.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Zuzifazhan;
import com.hj.jdpt.repository.ZuzifazhanMapper;
import com.hj.jdpt.service.ZuzifazhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ZuzifazhanServiceImpl implements ZuzifazhanService {

    @Autowired
    ZuzifazhanMapper zuzifazhanMapper;
    @Override
    public Map<String, Object> Select(Integer villageId,String year, Integer entity, Integer startPage, Integer pageSize) {
        Map<String, Object> map= new HashMap<>();
        String time1=year+"-"+0+1+"-"+0+1;
        String time2=year+"-"+12+"-"+31;
        Page<Zuzifazhan> zuzifazhan=null;
        if(year!=null&&entity==null){
            PageHelper.startPage(startPage, pageSize);
            zuzifazhan = zuzifazhanMapper.FindByYear(time1,time2,villageId);
         }
        if(entity!=null&&year==null){
            PageHelper.startPage(startPage, pageSize);
            if(entity==1) {
                zuzifazhan=zuzifazhanMapper.GetInfoByEntity("积极分子",villageId);
            }
            if(entity==2) {
                zuzifazhan=zuzifazhanMapper.GetInfoByEntity("发展对象",villageId);
            }
            if(entity==3) {
                zuzifazhan=zuzifazhanMapper.GetInfoByEntity("预备党员",villageId);
            }
            if(entity==4) {
                zuzifazhan=zuzifazhanMapper.GetInfoByEntity("正式党员",villageId);
            }
        }
        if(year!=null&&entity!=null) {
            PageHelper.startPage(startPage, pageSize);
            if(entity==1) {
                zuzifazhan = zuzifazhanMapper.FindByjjfzTime("积极分子", time1, time2,villageId);
            }
            if(entity==2) {
                zuzifazhan = zuzifazhanMapper.FindByfzdxTime("发展对象", time1, time2,villageId);
            }
            if(entity==3) {
                zuzifazhan = zuzifazhanMapper.FindByybdyTime("预备党员", time1, time2,villageId);
            }
            if(entity==4) {
                zuzifazhan = zuzifazhanMapper.FindByzsdyTime("正式党员", time1, time2,villageId);
            }
        }
        if (zuzifazhan== null) {
            map.put("status", "null");
            map.put("data", "没有数据");
        } else {
            for (int i = 0; i < zuzifazhan.size(); i++) {
                String villageName = zuzifazhanMapper.GetVillageById(zuzifazhan.get(i).getZzfzVillage());
                zuzifazhan.get(i).setVillageName(villageName);
                String zuName = zuzifazhanMapper.GetZuById(zuzifazhan.get(i).getZzfzZu());
                zuzifazhan.get(i).setZuName(zuName);
            }
            map.put("status", "success");
                //总页数
            map.put("total", zuzifazhan.getPages());
            //记录总数
            map.put("count", zuzifazhan.getTotal());
                //页面大小
            map.put("pageSize", zuzifazhan.getPageSize());
                //数据
            map.put("data", zuzifazhan);
                //当前第几页
            map.put("nowPage", zuzifazhan.getPageNum());
            }

        return map;
    }
}
