//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Hukouqianyi;
import com.hj.jdpt.repository.HukouqianyiMapper;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HuKouQianYiController {
    @Autowired
    private HukouqianyiMapper hukouqianyiMapper;

    public HuKouQianYiController() {
    }

    @GetMapping({"/FindHKQYById/{id}"})
    public Map<String, Object> FindHKQYById(@PathVariable("id") Integer id) {
        Hukouqianyi hukouqianyi = this.hukouqianyiMapper.FindHKQYById(id);
        Map<String, Object> result = new HashMap();
        result.put("hukouqianyi", hukouqianyi);
        return result;
    }

    @GetMapping({"/FindByCunIdLeixing/{villageId}/{typeId}/{startPage}/{pageSize}"})
    public Map<String, Object> FindByCunIdLeixing(@PathVariable("villageId") Integer villageId, @PathVariable("typeId") Integer typeId, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        Page<Hukouqianyi> hukouqianyiPage = this.hukouqianyiMapper.FindByCunIdLeixing(villageId, typeId);
        Map<String, Object> result = new HashMap();
        result.put("record", hukouqianyiPage);
        result.put("total", hukouqianyiPage.getPages());
        result.put("count", hukouqianyiPage.getTotal());
        result.put("nowPage", hukouqianyiPage.getPageNum());
        return result;
    }
}
