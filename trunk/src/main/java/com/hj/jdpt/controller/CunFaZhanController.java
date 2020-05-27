//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.hj.jdpt.domain.Cunfazhan;
import com.hj.jdpt.domain.Village;
import com.hj.jdpt.repository.CunfazhanMapper;
import com.hj.jdpt.repository.VillageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class CunFaZhanController {
    @Autowired
    private CunfazhanMapper cunfazhanMapper;
    @Autowired
    private VillageMapper villageMapper;

    public CunFaZhanController() {
    }

    @GetMapping({"/FindCunfazhanByVillageId/{villageId}"})
    public Map<String, Object> FindCunfazhanByVillageId(@PathVariable("villageId") Integer villageId) {
        Map<String, Object> result = new HashMap();
        Cunfazhan cunfazhan = this.cunfazhanMapper.FindCunfazhanByVillageId(villageId);
        result.put("cunfanzhan", cunfazhan);
        return result;
    }

    @GetMapping({"/FindVImg/{cunid}"})
    public Map<String, Object> FindVImg(@PathVariable("cunid") Integer cunid) {
        Village vImg = this.villageMapper.FindVImg(cunid);
        Map<String, Object> result = new HashMap();
        result.put("vImg", vImg);
        return result;
    }
}
