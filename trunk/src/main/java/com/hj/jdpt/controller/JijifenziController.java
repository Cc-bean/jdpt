package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Capital;
import com.hj.jdpt.domain.Jijifenzi;
import com.hj.jdpt.repository.JijifenziMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin
@RestController
public class JijifenziController {
    @Autowired
    private JijifenziMapper jijifenziMapper;

    @GetMapping(value = "/pageFindJijifenziByJjfzVillageandJjfzYear/{jjfzVillage}/{jjfzYear}/{startPage}/{pageSize}")
    public Map<String, Object> pageFindJijifenziByJjfzVillageandJjfzYear(@PathVariable(value = "jjfzVillage") Integer jjfzVillage,
                                                                         @PathVariable(value = "jjfzYear") Integer jjfzYear,
                                                                         @PathVariable(value = "startPage") Integer startPage,
                                                                         @PathVariable(value = "pageSize") Integer pageSize
    ) {

        PageHelper.startPage(startPage, pageSize);
        Map<String, Object> result = new HashMap<>();
        Page<Jijifenzi> JijifenziPage = jijifenziMapper.pageFindJijifenziByJjfzVillageandJjfzYear(jjfzVillage,jjfzYear);
        result.put("record", JijifenziPage);
        //总页数
        result.put("total", JijifenziPage.getPages());
        //记录总数
        result.put("count", JijifenziPage.getTotal());
        //当前第几页
        result.put("nowPage", JijifenziPage.getPageNum());
        return result;
    }


    @GetMapping(value = "/pageFindJijifenziByJjfzVillage/{jjfzVillage}/{startPage}/{pageSize}")
    public Map<String, Object> pageFindJijifenziByJjfzVillage(@PathVariable(value = "jjfzVillage") Integer jjfzVillage,
                                                              @PathVariable(value = "startPage") Integer startPage,
                                                              @PathVariable(value = "pageSize") Integer pageSize
    ) {

        PageHelper.startPage(startPage, pageSize);
        Map<String, Object> result = new HashMap<>();
        Page<Jijifenzi> JijifenziPage = jijifenziMapper.pageFindJijifenziByJjfzVillage(jjfzVillage);
        result = new HashMap<>();
        result.put("record", JijifenziPage);
        //总页数
        result.put("total", JijifenziPage.getPages());
        //记录总数
        result.put("count", JijifenziPage.getTotal());
        //当前第几页
        result.put("nowPage", JijifenziPage.getPageNum());


        return result;

    }

    @GetMapping(value = "/pageFindJijifenziByJjfzYear/{jjfzYear}/{startPage}/{pageSize}")
    public Map<String, Object> pageFindJijifenziByJjfzYear(
            @PathVariable(value = "jjfzYear") Integer jjfzYear,
            @PathVariable(value = "startPage") Integer startPage,
            @PathVariable(value = "pageSize") Integer pageSize
    ) {

        PageHelper.startPage(startPage, pageSize);
        Page<Jijifenzi> JijifenziPage = jijifenziMapper.pageFindJijifenziByJjfzYear(jjfzYear);
        Map<String, Object> result = new HashMap<>();
        result.put("record", JijifenziPage);
        //总页数
        result.put("total", JijifenziPage.getPages());
        //记录总数
        result.put("count", JijifenziPage.getTotal());
        //当前第几页
        result.put("nowPage", JijifenziPage.getPageNum());
        return result;
    }

    @GetMapping(value = "/pageFindJijifenziByZName/{zName}/{startPage}/{pageSize}")
    public Map<String, Object> pageFindJijifenziByZName(
            @PathVariable(value = "zName") String zName,
            @PathVariable(value = "startPage") Integer startPage,
            @PathVariable(value = "pageSize") Integer pageSize
    ) {

        PageHelper.startPage(startPage, pageSize);
        Page<Jijifenzi> JijifenziPage = jijifenziMapper.pageFindJijifenziByZName(zName);
        Map<String, Object> result = new HashMap<>();
        result.put("record", JijifenziPage);
        //总页数
        result.put("total", JijifenziPage.getPages());
        //记录总数
        result.put("count", JijifenziPage.getTotal());
        //当前第几页
        result.put("nowPage", JijifenziPage.getPageNum());
        return result;
    }

    @GetMapping(value = "/pageFindJijifenziByVNameandZName/{zName}/{vName}/{startPage}/{pageSize}")
    public Map<String, Object> pageFindJijifenziByVNameandZName(
            @PathVariable(value = "zName") String zName,
            @PathVariable(value = "vName") String vName,
            @PathVariable(value = "startPage") Integer startPage,
            @PathVariable(value = "pageSize") Integer pageSize
    ) {

        PageHelper.startPage(startPage, pageSize);
        Page<Jijifenzi> JijifenziPage = jijifenziMapper.pageFindJijifenziByVNameandZName(zName,vName);
        Map<String, Object> result = new HashMap<>();
        result.put("record", JijifenziPage);
        //总页数
        result.put("total", JijifenziPage.getPages());
        //记录总数
        result.put("count", JijifenziPage.getTotal());
        //当前第几页
        result.put("nowPage", JijifenziPage.getPageNum());
        return result;
    }

    @GetMapping(value = "/pageFindJijifenziByVNameandZNameandQkbgTime/{zName}/{vName}/{qkbgTime}/{startPage}/{pageSize}")
    public Map<String, Object> pageFindJijifenziByVNameandZNameandQkbgTime(
            @PathVariable(value = "zName") String zName,
            @PathVariable(value = "vName") String vName,
            @PathVariable(value = "qkbgTime") String qkbgTime,
            @PathVariable(value = "startPage") Integer startPage,
            @PathVariable(value = "pageSize") Integer pageSize
    ) {

        PageHelper.startPage(startPage, pageSize);
        Page<Jijifenzi> JijifenziPage = jijifenziMapper.pageFindJijifenziByVNameandZNameandQkbgTime(zName,vName,qkbgTime);
        Map<String, Object> result = new HashMap<>();
        result.put("record", JijifenziPage);
        //总页数
        result.put("total", JijifenziPage.getPages());
        //记录总数
        result.put("count", JijifenziPage.getTotal());
        //当前第几页
        result.put("nowPage", JijifenziPage.getPageNum());
        return result;
    }
    @GetMapping(value = "/selectJijifenzi//{startPage}/{pageSize}")
    public Map<String, Object> selectJijifenzi(
            @PathVariable(value = "startPage") Integer startPage,
            @PathVariable(value = "pageSize") Integer pageSize
    ) {

        PageHelper.startPage(startPage, pageSize);
        Page<Jijifenzi> JijifenziPage = jijifenziMapper.selectJijifenzi();
        Map<String, Object> result = new HashMap<>();
        result.put("record", JijifenziPage);
        //总页数
        result.put("total", JijifenziPage.getPages());
        //记录总数
        result.put("count", JijifenziPage.getTotal());
        //当前第几页
        result.put("nowPage", JijifenziPage.getPageNum());
        return result;
    }
    @GetMapping(value = "/DeleteJijifenzi/{jjfzId}")
    public Map<String, Object> DeleteJijifenzi(
            @PathVariable(value = "jjfzId") Integer jjfzId
    ) {

        Map<String, Object> map = new HashMap<>();
        Jijifenzi jijifenzi=jijifenziMapper.queryAll(jjfzId);
        if(jijifenzi==null){
            map.put("result","null");
        }else{
           int result= jijifenziMapper.DeleteJijifenzi(jjfzId);
           if(result==1){
               map.put("result","success");
           }else{
               map.put("result","error");
           }
        }
        return map;
    }
    @GetMapping(value = "/DeleteDuoTiaoJijifenzi/{jjfzId}")
    public Map<String, Object> DeleteDuoTiaoJijifenzi(
            @PathVariable(value = "jjfzId") String jjfzId
    ) {

        Map<String, Object> map = new HashMap<>();
        int result=jijifenziMapper.DeleteDuoTiaoJijifenzi(jjfzId);
        map.put("result",result);
        return map;
    }
    @GetMapping(value = "/InsertJijifenzi")
    public Map<String, Object> InsertJijifenzi(
    ) {

        Map<String, Object> map = new HashMap<>();
        int result=jijifenziMapper.InsertJijifenzi();
        map.put("result",result);
        return map;
    }
    @GetMapping(value = "/UpdateJijifenzi/{jjfzId}")
    public Map<String, Object> UpdateJijifenzi(
            @PathVariable(value = "jjfzId") Integer jjfzId
    ) {

        Map<String, Object> map = new HashMap<>();
        Jijifenzi jijifenzi=jijifenziMapper.queryAll(jjfzId);
        if(jijifenzi==null){
            map.put("result","null");
        }else {
            int result = jijifenziMapper.UpdateJijifenzi(jjfzId);
            if (result == 1) {
                map.put("result", "success");
            } else {
                map.put("result", "error");
            }
        }
        return  map;
    }





}
