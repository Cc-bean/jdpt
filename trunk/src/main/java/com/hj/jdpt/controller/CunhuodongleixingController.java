//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Cunhuodongleixing;
import com.hj.jdpt.domain.Cunzuzhihuodong;
import com.hj.jdpt.domain.Yonghu;
import com.hj.jdpt.repository.CunhuodongleixingMapper;
import com.hj.jdpt.repository.CunzuzhihuodongMapper;
import com.hj.jdpt.repository.YonghuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class CunhuodongleixingController {
    @Autowired
    YonghuMapper yonghuMapper;
    @Autowired
    CunhuodongleixingMapper cunhuodongleixingMapper;
    @Autowired
    CunzuzhihuodongMapper cunzuzhihuodongMapper;

    public CunhuodongleixingController() {
    }

    @GetMapping({"/YongHuInfo/{id}"})
    public Map<String, Object> YongHuInfo(@PathVariable("id") Integer id) {
        HashMap result = new HashMap();

        try {
            Yonghu yonghu = this.yonghuMapper.findInfo(id);
            if (yonghu == null) {
                result.put("status", (Object)null);
            } else {
                result.put("status", "success");
                result.put("info", yonghu);
            }
        } catch (Exception var4) {
            result.put("status", "error");
        }

        return result;
    }

    @GetMapping({"/PageFindCunHuoDong/{cunId}/{startPage}/{pageSize}"})
    public Map<String, Object> PageFindCunHuoDong(@PathVariable("cunId") Integer cunId, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        HashMap result = new HashMap();

        try {
            PageHelper.startPage(startPage, pageSize);
            Page<Cunzuzhihuodong> cunhuodongPage = this.cunhuodongleixingMapper.findAllhuodong(cunId);
            if (cunhuodongPage.isEmpty()) {
                result.put("status", "null");
            } else {
                result.put("status", "success");
                result.put("cunhuodongPage", cunhuodongPage);
                result.put("total", cunhuodongPage.getPages());
                result.put("count", cunhuodongPage.getTotal());
                result.put("nowPage", cunhuodongPage.getPageNum());
            }
        } catch (Exception var6) {
            result.put("status", "error");
        }

        return result;
    }

    @GetMapping({"/HuoDongXiangQing/{id}"})
    public Map<String, Object> HuoDongXiangQing(@PathVariable("id") Integer id) {
        HashMap result = new HashMap();

        try {
            List<Cunzuzhihuodong> cunzuzhihuodong = this.cunzuzhihuodongMapper.findCunzuzhihuodongdetail(id);
            if (cunzuzhihuodong == null) {
                result.put("status", (Object)null);
            } else {
                result.put("status", "success");
                result.put("cunzuzhihuodong", cunzuzhihuodong);
            }
        } catch (Exception var4) {
            result.put("status", "error");
        }

        return result;
    }

    @GetMapping({"/ListType/{vid}"})
    public Map<String, Object> ListType(@PathVariable("vid") Integer vid) {
        Map<String, Object> result = new HashMap();
        List<Cunhuodongleixing> list = this.cunhuodongleixingMapper.AllType(vid);
        result.put("data", list);
        return result;
    }

    @GetMapping({"/findbytype/{id}/{startPage}/{pageSize}"})
    public Map<String, Object> findbytype(@PathVariable("id") Integer id, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        Map<String, Object> result = new HashMap();
        Cunhuodongleixing cunhuodongleixing = null;
        PageHelper.startPage(startPage, pageSize);
        Page<Cunzuzhihuodong> cunzuzhihuodongPage = this.cunzuzhihuodongMapper.findall(id);

        for(int i = 0; i < cunzuzhihuodongPage.size(); ++i) {
            cunhuodongleixing = this.cunhuodongleixingMapper.findbyid(((Cunzuzhihuodong)cunzuzhihuodongPage.get(i)).getCdyzzhdLeixing());
            ((Cunzuzhihuodong)cunzuzhihuodongPage.get(i)).setCunhuodongleixing(cunhuodongleixing);
        }

        result.put("data", cunzuzhihuodongPage);
        result.put("total", cunzuzhihuodongPage.getPages());
        result.put("count", cunzuzhihuodongPage.getTotal());
        result.put("nowPage", cunzuzhihuodongPage.getPageNum());
        return result;
    }

    @GetMapping({"/Cunzuzhihuodongxq/{cdyzzhdId}"})
    public Map<String, Object> Cunzuzhihuodongxq(@PathVariable("cdyzzhdId") Integer cdyzzhdId) {
        Map<String, Object> result = new HashMap();
        Cunzuzhihuodong cunzuzhihuodong = this.cunzuzhihuodongMapper.findbyid(cdyzzhdId);
        Cunhuodongleixing cunhuodongleixing = this.cunhuodongleixingMapper.findbyid(cunzuzhihuodong.getCdyzzhdLeixing());
        cunzuzhihuodong.setCunhuodongleixing(cunhuodongleixing);
        result.put("data", cunzuzhihuodong);
        return result;
    }

    @GetMapping({"/ListHuoDong/{vid}/{startPage}/{pageSize}"})
    public Map<String, Object> ListHuoDong(@PathVariable("vid") Integer vid, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        Map<String, Object> result = new HashMap();
        Cunhuodongleixing cunhuodongleixing = null;
        PageHelper.startPage(startPage, pageSize);
        Page<Cunzuzhihuodong> cunzuzhihuodongPage = this.cunzuzhihuodongMapper.findAll(vid);

        for(int i = 0; i < cunzuzhihuodongPage.size(); ++i) {
            cunhuodongleixing = this.cunhuodongleixingMapper.findbyid(((Cunzuzhihuodong)cunzuzhihuodongPage.get(i)).getCdyzzhdLeixing());
            ((Cunzuzhihuodong)cunzuzhihuodongPage.get(i)).setCunhuodongleixing(cunhuodongleixing);
        }

        result.put("data", cunzuzhihuodongPage);
        result.put("total", cunzuzhihuodongPage.getPages());
        result.put("count", cunzuzhihuodongPage.getTotal());
        result.put("nowPage", cunzuzhihuodongPage.getPageNum());
        return result;
    }
}
