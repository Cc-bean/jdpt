//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Jiaoyv;
import com.hj.jdpt.repository.JiaoyvMapper;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class JiaoyvController {
    @Autowired
    private JiaoyvMapper jiaoyvMapper;

    public JiaoyvController() {
    }

    @GetMapping({"/queryAll/{startPage}/{pageSize}"})
    public Map<String, Object> queryAll(@PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        Page<Jiaoyv> JiaoyvPage = this.jiaoyvMapper.queryAll();
        Map<String, Object> result = new HashMap();
        result.put("record", JiaoyvPage);
        result.put("total", JiaoyvPage.getPages());
        result.put("count", JiaoyvPage.getTotal());
        result.put("nowPage", JiaoyvPage.getPageNum());
        return result;
    }

    @GetMapping({"/query/{jyId}"})
    public Map<String, Object> query(@PathVariable("jyId") Integer jyId) {
        Page<Jiaoyv> JiaoyvPage = this.jiaoyvMapper.query(jyId);
        Map<String, Object> result = new HashMap();
        result.put("record", JiaoyvPage);
        return result;
    }
}
