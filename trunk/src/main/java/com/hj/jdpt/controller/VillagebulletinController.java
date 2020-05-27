package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Villageaffair;
import com.hj.jdpt.domain.Villagebulletin;
import com.hj.jdpt.repository.VillageaffairMapper;
import com.hj.jdpt.repository.VillagebulletinMapper;
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
public class VillagebulletinController {
    @Autowired
    private VillagebulletinMapper villagebulletinMapper;
    @Autowired
    private VillageaffairMapper villageaffairMapper;

    @GetMapping({"/FindVillagebulletinByCunId/{villageId}"})
    public Map<String, Object> FindVillagebulletinByCunId(@PathVariable("villageId") Integer villageId) {
        Map<String, Object> result = new HashMap();
        List<Villagebulletin> list = this.villagebulletinMapper.FindVillagebulletinByCunId(villageId);
        result.put("villagebulletins", list);
        return result;
    }

    @GetMapping({"/PageFindVillagebulletinByCunId/{villageId}/{startPage}/{pageSize}"})
    public Map<String, Object> PageFindVillagebulletinByCunId(@PathVariable("villageId") Integer villageId, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        Page<Villagebulletin> villagebulletinPage = this.villagebulletinMapper.PageFindVillagebulletinByCunId(villageId);
        Map<String, Object> result = new HashMap();
        result.put("record", villagebulletinPage);
        result.put("total", villagebulletinPage.getPages());
        result.put("count", villagebulletinPage.getTotal());
        result.put("nowPage", villagebulletinPage.getPageNum());
        return result;
    }

    @GetMapping({"/FindVillagebulletinById/{id}"})
    public Map<String, Object> FindVillagebulletinById(@PathVariable("id") Integer id) {
        Villagebulletin villagebulletin = this.villagebulletinMapper.FindVillagebulletinById(id);
        Map<String, Object> result = new HashMap();
        result.put("villagebulletin", villagebulletin);
        return result;
    }

    @GetMapping({"/FindHuiyiByCunId/{id}/{startPage}/{pageSize}"})
    public Map<String, Object> FindHuiyiByCunId(@PathVariable("id") Integer id, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        Page<Villageaffair> villageaffairPage = this.villageaffairMapper.FindHuiyiByCunId(id);
        Map<String, Object> result = new HashMap();
        result.put("record", villageaffairPage);
        result.put("total", villageaffairPage.getPages());
        result.put("count", villageaffairPage.getTotal());
        result.put("nowPage", villageaffairPage.getPageNum());
        return result;
    }

    @GetMapping({"/HuiYiXQ/{id}"})
    public Map<String, Object> HuiYiXQ(@PathVariable("id") Integer id) {
        Villageaffair villageaffair = this.villageaffairMapper.HuiYiXQ(id);
        Map<String, Object> result = new HashMap();
        result.put("villageaffair", villageaffair);
        return result;
    }

    @GetMapping({"/Cungonggao/{id}"})
    public Map<String, Object> Cungonggao(@PathVariable("id") Integer id) {
        Map<String, Object> map = new HashMap();
        List<Villagebulletin> list = this.villagebulletinMapper.Gundongtiao(id);
        map.put("data", list);
        return map;
    }
}
