//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Law;
import com.hj.jdpt.service.LawService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class LawController {
    @Autowired
    LawService lawService;

    public LawController() {
    }

    @GetMapping({"/queryLawByType/{startPage}/{pageSize}/{type_id}"})
    public Map<String, Object> queryLawByType(@PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize, @PathVariable("type_id") Integer type_id) {
        Map<String, Object> map = new HashMap();
        PageHelper.startPage(startPage, pageSize);
        Page<Law> laws = this.lawService.queryLawByType(type_id);
        map.put("lawPage", laws);
        map.put("total", laws.getPages());
        map.put("count", laws.getTotal());
        map.put("nowPage", laws.getPageNum());
        return map;
    }
}
