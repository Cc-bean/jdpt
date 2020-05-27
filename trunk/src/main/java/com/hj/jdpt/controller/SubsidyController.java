//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.*;
import com.hj.jdpt.repository.*;
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
public class SubsidyController {
    @Autowired
    private SubsidytypeMapper subsidytypeMapper;
    @Autowired
    private SubsidynameMapper subsidynameMapper;
    @Autowired
    private SubsidyobjectMapper subsidyobjectMapper;
    @Autowired
    private SubsidyinformationMapper subsidyinformationMapper;
    @Autowired
    private SubsidizedhouseholdsMapper subsidizedhouseholdsMapper;

    public SubsidyController() {
    }

    @GetMapping({"/FindSubsidytypeByCunId/{villageId}"})
    public Map<String, Object> FindSubsidytypeByCunId(@PathVariable("villageId") Integer villageId) {
        Map<String, Object> result = new HashMap();
        List<Subsidytype> list = this.subsidytypeMapper.FindSubsidytypeByCunId(villageId);
        result.put("type", list);
        return result;
    }

    @GetMapping({"/FindSubsidynameByTypeId/{TypeId}"})
    public Map<String, Object> FindSubsidynameByTypeId(@PathVariable("TypeId") Integer TypeId) {
        Map<String, Object> result = new HashMap();
        List<Subsidyname> list = this.subsidynameMapper.FindSubsidynameByTypeId(TypeId);
        result.put("subsidyname", list);
        return result;
    }

    @GetMapping({"/PageFindSubsidynameByTypeId/{TypeId}/{startPage}/{pageSize}"})
    public Map<String, Object> PageFindSubsidynameByTypeId(@PathVariable("TypeId") Integer TypeId, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        Page<Subsidyname> subsidynamePage = this.subsidynameMapper.PageFindSubsidynameByTypeId(TypeId);
        Subsidytype subsidytype = null;
        Subsidyinformation subsidyinformation = null;

        for(int i = 0; i < subsidynamePage.size(); ++i) {
            subsidytype = this.subsidytypeMapper.FindSubsidytypeById(((Subsidyname)subsidynamePage.get(i)).getsType());
            subsidyinformation = this.subsidyinformationMapper.FindSubsidyinformationById(((Subsidyname)subsidynamePage.get(i)).getsKey());
            ((Subsidyname)subsidynamePage.get(i)).setSubsidytype(subsidytype);
            ((Subsidyname)subsidynamePage.get(i)).setSubsidyinformation(subsidyinformation);
        }

        Map<String, Object> result = new HashMap();
        result.put("record", subsidynamePage);
        result.put("total", subsidynamePage.getPages());
        result.put("count", subsidynamePage.getTotal());
        result.put("nowPage", subsidynamePage.getPageNum());
        return result;
    }

    @GetMapping({"/FindSubsidynameById/{id}"})
    public Map<String, Object> FindSubsidynameById(@PathVariable("id") Integer id) {
        Subsidyname subsidyname = this.subsidynameMapper.FindSubsidynameById(id);
        Subsidytype subsidytype = this.subsidytypeMapper.FindSubsidytypeById(subsidyname.getsType());
        Subsidyinformation subsidyinformation = this.subsidyinformationMapper.FindSubsidyinformationById(subsidyname.getsKey());
        Map<String, Object> result = new HashMap();
        result.put("subsidyname", subsidyname);
        result.put("leixing", subsidytype.getStName());
        result.put("amount", subsidyinformation.getSiSubsidyamount());
        return result;
    }

    @GetMapping({"/FindSubsidyobjectByCunId/{id}"})
    public Map<String, Object> FindSubsidyobjectByCunId(@PathVariable("id") Integer id) {
        List<Subsidyobject> subsidyobjects = this.subsidyobjectMapper.FindSubsidyobjectByCunId(id);
        Map<String, Object> result = new HashMap();
        result.put("subsidyobjects", subsidyobjects);
        return result;
    }

    @GetMapping({"/PageFindSubsidyobjectByCunId/{villageId}/{startPage}/{pageSize}"})
    public Map<String, Object> PageFindSubsidyobjectByCunId(@PathVariable("villageId") Integer villageId, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        Page<Subsidyobject> subsidyobjectPage = this.subsidyobjectMapper.PageFindSubsidyobjectByCunId(villageId);
        Subsidyinformation s = null;
        Subsidyname subsidyname = null;

        for(int i = 0; i < subsidyobjectPage.size(); ++i) {
            s = this.subsidyinformationMapper.FindSubsidyinformationById(Integer.parseInt(((Subsidyobject)subsidyobjectPage.get(i)).getSoEnjoythesubsidy()));
            subsidyname = this.subsidynameMapper.FindSubsidynameById(Integer.parseInt(((Subsidyobject)subsidyobjectPage.get(i)).getSoEnjoythesubsidy()));
            ((Subsidyobject)subsidyobjectPage.get(i)).setSubsidyinformation(s);
            ((Subsidyobject)subsidyobjectPage.get(i)).setSubsidyname(subsidyname);
        }

        Map<String, Object> result = new HashMap();
        result.put("record", subsidyobjectPage);
        result.put("total", subsidyobjectPage.getPages());
        result.put("count", subsidyobjectPage.getTotal());
        result.put("nowPage", subsidyobjectPage.getPageNum());
        return result;
    }

    @GetMapping({"/FindSubsidyobjectById/{id}"})
    public Map<String, Object> FindSubsidyobjectById(@PathVariable("id") Integer id) {
        Subsidyobject subsidyobject = this.subsidyobjectMapper.FindSubsidyobjectById(id);
        Subsidyinformation subsidyinformation = this.subsidyinformationMapper.FindSubsidyinformationById(Integer.parseInt(subsidyobject.getSoEnjoythesubsidy()));
        Subsidyname subsidyname = this.subsidynameMapper.FindSubsidynameById(subsidyinformation.getSiNameofsubsidy());
        Map<String, Object> result = new HashMap();
        result.put("name", subsidyobject.getSoName());
        result.put("sex", subsidyobject.getSoBeiyong1());
        result.put("buzhu", subsidyname.getsName());
        result.put("money", subsidyinformation.getSiSubsidyamount());
        return result;
    }

    @GetMapping({"/SearchSubsidyobjectByName/{id}/{name}/{startPage}/{pageSize}"})
    public Map<String, Object> SearchSubsidyobjectByName(@PathVariable("id") Integer id, @PathVariable("name") String name, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        Page<Subsidyobject> subsidyobjectPage = this.subsidyobjectMapper.SearchSubsidyobjectByName(id, name);
        Subsidyinformation s = null;
        Subsidyname subsidyname = null;

        for(int i = 0; i < subsidyobjectPage.size(); ++i) {
            s = this.subsidyinformationMapper.FindSubsidyinformationById(Integer.parseInt(((Subsidyobject)subsidyobjectPage.get(i)).getSoEnjoythesubsidy()));
            subsidyname = this.subsidynameMapper.FindSubsidynameById(Integer.parseInt(((Subsidyobject)subsidyobjectPage.get(i)).getSoEnjoythesubsidy()));
            ((Subsidyobject)subsidyobjectPage.get(i)).setSubsidyinformation(s);
            ((Subsidyobject)subsidyobjectPage.get(i)).setSubsidyname(subsidyname);
        }

        Map<String, Object> result = new HashMap();
        result.put("record", subsidyobjectPage);
        result.put("total", subsidyobjectPage.getPages());
        result.put("count", subsidyobjectPage.getTotal());
        result.put("nowPage", subsidyobjectPage.getPageNum());
        return result;
    }

    @GetMapping({"/FindSubsidyinformationById/{id}"})
    public Map<String, Object> FindSubsidyinformationById(@PathVariable("id") Integer id) {
        Subsidizedhouseholds subsidizedhouseholds = this.subsidizedhouseholdsMapper.FindBuzhuhuById(id);
        Subsidyinformation subsidyinformation = this.subsidyinformationMapper.FindSubsidyinformationById(Integer.parseInt(subsidizedhouseholds.getShEnjoythesubsidy()));
        Subsidyname subsidyname = this.subsidynameMapper.FindSubsidynameById(subsidyinformation.getSiNameofsubsidy());
        Map<String, Object> result = new HashMap();
        result.put("name", subsidizedhouseholds.getShName());
        result.put("address", subsidizedhouseholds.getShAddress());
        result.put("buzhu", subsidyname.getsName());
        result.put("money", subsidyinformation.getSiSubsidyamount());
        return result;
    }

    @GetMapping({"/PageFindBuzhuhuById/{villageId}/{startPage}/{pageSize}"})
    public Map<String, Object> PageFindBuzhuhuById(@PathVariable("villageId") Integer villageId, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        Page<Subsidizedhouseholds> subsidizedhouseholdsPage = this.subsidizedhouseholdsMapper.PageFindBuzhuhuById(villageId);
        Subsidyinformation subsidyinformation = null;
        Subsidyname subsidyname = null;

        for(int i = 0; i < subsidizedhouseholdsPage.size(); ++i) {
            subsidyinformation = this.subsidyinformationMapper.FindSubsidyinformationById(Integer.parseInt(((Subsidizedhouseholds)subsidizedhouseholdsPage.get(i)).getShEnjoythesubsidy()));
            subsidyname = this.subsidynameMapper.FindSubsidynameById(subsidyinformation.getSiNameofsubsidy());
            ((Subsidizedhouseholds)subsidizedhouseholdsPage.get(i)).setSubsidyinformation(subsidyinformation);
            ((Subsidizedhouseholds)subsidizedhouseholdsPage.get(i)).setSubsidyname(subsidyname);
        }

        Map<String, Object> result = new HashMap();
        result.put("record", subsidizedhouseholdsPage);
        result.put("total", subsidizedhouseholdsPage.getPages());
        result.put("count", subsidizedhouseholdsPage.getTotal());
        result.put("nowPage", subsidizedhouseholdsPage.getPageNum());
        return result;
    }

    @GetMapping({"/SearchByNameId/{id}/{name}/{startPage}/{pageSize}"})
    public Map<String, Object> SearchByNameId(@PathVariable("id") Integer id, @PathVariable("name") String name, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        Page<Subsidizedhouseholds> subsidizedhouseholdsPage = this.subsidizedhouseholdsMapper.SearchByNameId(id, name);
        Subsidyinformation subsidyinformation = null;
        Subsidyname subsidyname = null;

        for(int i = 0; i < subsidizedhouseholdsPage.size(); ++i) {
            subsidyinformation = this.subsidyinformationMapper.FindSubsidyinformationById(Integer.parseInt(((Subsidizedhouseholds)subsidizedhouseholdsPage.get(i)).getShEnjoythesubsidy()));
            subsidyname = this.subsidynameMapper.FindSubsidynameById(subsidyinformation.getSiNameofsubsidy());
            ((Subsidizedhouseholds)subsidizedhouseholdsPage.get(i)).setSubsidyinformation(subsidyinformation);
            ((Subsidizedhouseholds)subsidizedhouseholdsPage.get(i)).setSubsidyname(subsidyname);
        }

        Map<String, Object> result = new HashMap();
        result.put("record", subsidizedhouseholdsPage);
        result.put("total", subsidizedhouseholdsPage.getPages());
        result.put("count", subsidizedhouseholdsPage.getTotal());
        result.put("nowPage", subsidizedhouseholdsPage.getPageNum());
        return result;
    }
}
