package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Zuzifazhan;
import com.hj.jdpt.repository.ZuzifazhanMapper;
import com.hj.jdpt.service.ZuzifazhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@CrossOrigin
@RestController
public class ZuzifazhanController {

    @Autowired
    ZuzifazhanService zuzifazhanService;

    @Autowired
    ZuzifazhanMapper zuzifazhanMapper;
    @PostMapping("/QSelect")
    public Map<String ,Object> QSelect(
            @RequestParam Integer villageId,//村id
            @RequestParam(required = false) String year,//姓名
            @RequestParam(required = false) Integer entity,//身份
            @RequestParam Integer startPage,
            @RequestParam Integer pageSize
    ){
        if(StringUtils.isEmpty(entity)){
            entity=null;
        }
        if(StringUtils.isEmpty(year)){
            year=null;
        }
        Map<String , Object> map=zuzifazhanService.Select(villageId,year, entity,startPage,pageSize);
        return map;
    }


}
