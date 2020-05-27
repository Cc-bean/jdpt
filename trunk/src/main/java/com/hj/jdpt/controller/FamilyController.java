//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.hj.jdpt.domain.Familyinformation;
import com.hj.jdpt.domain.FamilyinformationForeign;
import com.hj.jdpt.domain.Nation;
import com.hj.jdpt.domain.Policystatu;
import com.hj.jdpt.repository.FamilyinformationMapper;
import com.hj.jdpt.repository.NationMapper;
import com.hj.jdpt.repository.PolicystatuMapper;
import com.hj.jdpt.service.FamilyInformation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class FamilyController {
    @Autowired
    FamilyInformation familyInformation;
    @Autowired
    FamilyinformationMapper familyinformationMapper;
    @Autowired
    NationMapper nationMapper;
    @Autowired
    PolicystatuMapper policystatuMapper;

    public FamilyController() {
    }

    @GetMapping({"/FindFamilyMember/{userid}"})
    public Map<String, Object> FindFamilyMember(@PathVariable("userid") Integer userid) {
        List<FamilyinformationForeign> list = this.familyInformation.FindFamilyMember(userid);
        Map<String, Object> result = new HashMap();
        result.put("member", list);
        return result;
    }

    @GetMapping({"/FindMemberInfo/{id}"})
    public Map<String, Object> FindMemberInfo(@PathVariable("id") Integer id) {
        FamilyinformationForeign info = this.familyinformationMapper.Info(id);
        Map<String, Object> result = new HashMap();
        result.put("info", info);
        return result;
    }

    @GetMapping({"/DeleteMember/{id}"})
    public Map<String, Object> DeleteMember(@PathVariable("id") Integer id) {
        boolean b = this.familyinformationMapper.Delete(id);
        Map<String, Object> map = new HashMap();
        if (b) {
            map.put("statue", "success");
        } else {
            map.put("statue", "false");
        }

        return map;
    }

    @PostMapping({"/InsertMember"})
    public Map<String, Object> InsertMember(Familyinformation familyinformation, @RequestParam Integer fiPeopleid) {
        familyinformation.setFiPeopleid(fiPeopleid);
        boolean B = this.familyinformationMapper.Insert(familyinformation);
        Map<String, Object> map = new HashMap();
        if (B) {
            map.put("statue", "success");
        } else {
            map.put("statue", "false");
        }

        return map;
    }

    @PostMapping({"/UpdateMember"})
    public Map<String, Object> UpdateMember(Familyinformation familyinformation, @RequestParam Integer familyinformationId) {
        boolean update = this.familyinformationMapper.Update(familyinformation);
        Map<String, Object> map = new HashMap();
        if (update) {
            map.put("statue", "success");
        } else {
            map.put("statue", "false");
        }

        return map;
    }

    @GetMapping({"/Bianjiyemian/{id}"})
    public Map<String, Object> Bianjiyemian(@PathVariable("id") Integer id) {
        Map<String, Object> map = new HashMap();
        List<Nation> nations = this.nationMapper.nationlist();
        List<Policystatu> policystatus = this.policystatuMapper.PolicystatuList();
        FamilyinformationForeign info = this.familyinformationMapper.Info(id);
        map.put("nation", nations);
        map.put("policystatu", policystatus);
        map.put("info", info);
        return map;
    }

    @GetMapping({"/Add"})
    public Map<String, Object> Add() {
        Map<String, Object> map = new HashMap();
        List<Nation> nations = this.nationMapper.nationlist();
        List<Policystatu> policystatus = this.policystatuMapper.PolicystatuList();
        map.put("nation", nations);
        map.put("policystatu", policystatus);
        return map;
    }
}
