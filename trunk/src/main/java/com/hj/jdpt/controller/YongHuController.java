//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Yonghu;
import com.hj.jdpt.repository.YonghuMapper;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class YongHuController {
    @Autowired
    private YonghuMapper yonghuMapper;

    public YongHuController() {
    }

    @GetMapping({"/yonghu/{startPage}/{pageSize}"})
    public Map<String, Object> returnPage(@PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        Page<Yonghu> yonghuPage = this.yonghuMapper.queryAll();
        Page<Yonghu> yonghuPage1 = this.yonghuMapper.queryAll();
        Map<String, Object> result = new HashMap();
        result.put("record", yonghuPage);
        result.put("total", yonghuPage.getPages());
        result.put("count", yonghuPage.getTotal());
        result.put("nowPage", yonghuPage.getPageNum());
        return result;
    }
}
