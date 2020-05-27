//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Operationmanagement;
import com.hj.jdpt.repository.OperationmanagementMapper;
import com.hj.jdpt.vo.OperationmanagementVO_GX;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class OperationmanagementController {
    @Autowired
    OperationmanagementMapper mapper;

    public OperationmanagementController() {
    }

    @GetMapping({"/queryOperationManagements/{startPage}/{pageSize}/{cunId}"})
    public Map<String, Object> queryOperationManagements(@PathVariable int startPage, @PathVariable int pageSize, @PathVariable int cunId) {
        Map<String, Object> map = new HashMap();
        PageHelper.startPage(startPage, pageSize);
        Page<OperationmanagementVO_GX> list = this.mapper.queryOperationManagment(cunId);
        map.put("OperationManagements", list);
        map.put("total", list.getPages());
        map.put("count", list.getTotal());
        map.put("nowPage", list.getPageNum());
        return map;
    }

    @GetMapping({"/queryOperationManagement/{Name}/{startPage}/{pageSize}/{cunId}"})
    public Map<String, Object> queryOperationManagementByName(@PathVariable String Name, @PathVariable int startPage, @PathVariable int pageSize, @PathVariable int cunId) {
        Map<String, Object> map = new HashMap();
        PageHelper.startPage(startPage, pageSize);
        Page<OperationmanagementVO_GX> list = this.mapper.queryOperationManagmentByName(Name, cunId);
        map.put("OperationManagement", list);
        map.put("total", list.getPages());
        map.put("count", list.getTotal());
        map.put("nowPage", list.getPageNum());
        return map;
    }

    @GetMapping({"/queryOperationManagementFindById/{id}"})
    public Map<String, Object> queryOperationManagementFindById(@PathVariable int id) {
        Map<String, Object> map = new HashMap();
        Operationmanagement operationmanagement = this.mapper.queryOperationManagementFindById(id);
        map.put("OperationManagement", operationmanagement);
        return map;
    }
}
