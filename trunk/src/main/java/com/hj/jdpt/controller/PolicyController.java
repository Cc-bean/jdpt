//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Policy;
import com.hj.jdpt.service.PolicyService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class PolicyController {
    @Autowired
    PolicyService policyService;

    public PolicyController() {
    }

    @GetMapping({"/queryPolicyByType/{startPage}/{pageSize}/{type_id}"})
    public Map<String, Object> queryPolicyByType(@PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize, @PathVariable("type_id") Integer type_id) {
        Map<String, Object> map = new HashMap();
        PageHelper.startPage(startPage, pageSize);
        Page<Policy> policyPage = this.policyService.queryPolicyByType(type_id);
        map.put("policyPage", policyPage);
        map.put("total", policyPage.getPages());
        map.put("count", policyPage.getTotal());
        map.put("nowPage", policyPage.getPageNum());
        return map;
    }
}
