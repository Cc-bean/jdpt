//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Dangyuanzuzhihuodong;
import com.hj.jdpt.domain.HuodongleixingAndDangYuanZuZhiHuoDong;
import com.hj.jdpt.repository.DangyuanzuzhihuodongMapper;
import com.hj.jdpt.service.Huodongleixing;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HuodongleixingController {
    @Autowired
    Huodongleixing huodongleixing;
    @Autowired
    DangyuanzuzhihuodongMapper dangyuanzuzhihuodongMapper;

    public HuodongleixingController() {
    }

    @GetMapping({"/HuodongleixingqueryAll/{cun_id}"})
    public Map<String, Object> HuodongleixingqueryAll(@PathVariable("cun_id") Integer cun_id) {
        List<HuodongleixingAndDangYuanZuZhiHuoDong> huodongleixingAndDangYuanZuZhiHuoDongsList = this.huodongleixing.queryAll(cun_id);
        Map<String, Object> map = new HashMap();
        map.put("huodongleixingAndDangYuanZuZhiHuoDongsList", huodongleixingAndDangYuanZuZhiHuoDongsList);
        return map;
    }

    @GetMapping({"/queryAllLeiXing/{startPage}/{pageSize}/{cun_id}"})
    public Map<String, Object> queryAllLeiXing(@PathVariable("cun_id") Integer cun_id, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        Page<HuodongleixingAndDangYuanZuZhiHuoDong> huodongleixingList = this.huodongleixing.queryAllLeiXing(cun_id);
        Map<String, Object> result = new HashMap();
        result.put("huodongleixingList", huodongleixingList);
        result.put("total", huodongleixingList.getPages());
        result.put("count", huodongleixingList.getTotal());
        result.put("nowPage", huodongleixingList.getPageNum());
        return result;
    }

    @GetMapping({"/queryAllHuoDong/{startPage}/{pageSize}/{LX_id}/{cun_id}"})
    public Map<String, Object> queryAllHuoDong(@PathVariable("LX_id") Integer LX_id, @PathVariable("cun_id") Integer cun_id, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        Page<Dangyuanzuzhihuodong> huodongList = this.huodongleixing.queryAllHD(LX_id, cun_id);
        Map<String, Object> result = new HashMap();
        result.put("huodongleixingList", huodongList);
        result.put("total", huodongList.getPages());
        result.put("count", huodongList.getTotal());
        result.put("nowPage", huodongList.getPageNum());
        return result;
    }

    @GetMapping({"/queryHuoDongById/{HD_id}"})
    public Map<String, Object> queryHuoDongById(@PathVariable("HD_id") Integer HD_id) {
        Dangyuanzuzhihuodong huodong = this.dangyuanzuzhihuodongMapper.queryBy_id(HD_id);
        Map<String, Object> map = new HashMap();
        map.put("huodong", huodong);
        return map;
    }
}
