//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.PartymemberinformationAndYonghu;
import com.hj.jdpt.service.Partymemberinformation;
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
public class PartymemberinformationController {
    @Autowired
    Partymemberinformation partymemberinformation;

    public PartymemberinformationController() {
    }

    @GetMapping({"/partyMembersList/{cun_id}"})
    public Map<String, Object> queryAll(@PathVariable("cun_id") Integer cun_id) {
        List<PartymemberinformationAndYonghu> partymemberinformationAndYonghuList = this.partymemberinformation.queryALl(cun_id);
        Map<String, Object> map = new HashMap();
        map.put("PartymemberinformationList", partymemberinformationAndYonghuList);
        return map;
    }

    @GetMapping({"/partyMembersById/{id}"})
    public Map<String, Object> queryAllByID(@PathVariable("id") Integer id) {
        PartymemberinformationAndYonghu partymemberinformationAndYonghuByID = this.partymemberinformation.queryById(id);
        Map<String, Object> map = new HashMap();
        map.put("partymemberinformationAndYonghuByID", partymemberinformationAndYonghuByID);
        return map;
    }

    @GetMapping({"/partyMembersByName/{startPage}/{pageSize}/{name}/{cun_id}"})
    public Map<String, Object> queryAllByName(@PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize, @PathVariable("name") String name, @PathVariable("cun_id") Integer cun_id) {
        PageHelper.startPage(startPage, pageSize);
        Page<PartymemberinformationAndYonghu> partymemberByName = this.partymemberinformation.queryByName(name, cun_id);
        Map<String, Object> map = new HashMap();
        map.put("partymemberinformationAndYonghuListByName", partymemberByName);
        map.put("total", partymemberByName.getPages());
        map.put("count", partymemberByName.getTotal());
        map.put("nowPage", partymemberByName.getPageNum());
        return map;
    }

    @GetMapping({"/partyMembersPage/{startPage}/{pageSize}/{cun_id}"})
    public Map<String, Object> partyMembersPage(@PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize, @PathVariable("cun_id") Integer cun_id) {
        PageHelper.startPage(startPage, pageSize);
        Page<PartymemberinformationAndYonghu> partyMembersPage = this.partymemberinformation.queryALl(cun_id);
        Map<String, Object> result = new HashMap();
        result.put("record", partyMembersPage);
        result.put("total", partyMembersPage.getPages());
        result.put("count", partyMembersPage.getTotal());
        result.put("nowPage", partyMembersPage.getPageNum());
        return result;
    }
}
