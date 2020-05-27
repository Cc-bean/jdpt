package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Yvbeidangyuan;
import com.hj.jdpt.repository.YvbeidangyuanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin
@RestController
public class YvbeidangyuanController {
    @Autowired
    private YvbeidangyuanMapper yvbeidangyuanMapper;
    @GetMapping(value = "/pageFondYvbeidangyuanByYbdyYearandYbdyVillage/{ybdyYear}/{ybdyVillage}/{startPage}/{pageSize}")
    public Map<String ,Object> pageFondYvbeidangyuanByYbdyYearandYbdyVillage(@PathVariable(value = "ybdyYear") Integer ybdyYear,
                                                                        @PathVariable(value = "ybdyVillage") Integer ybdyVillage,
                                          @PathVariable(value = "startPage") Integer startPage,
                                          @PathVariable(value = "pageSize") Integer pageSize
                                          ){

        PageHelper.startPage(startPage,pageSize);
        Page<Yvbeidangyuan> YvbeidangyuanPage =  yvbeidangyuanMapper.pageFondYvbeidangyuanByYbdyYearandYbdyVillage(ybdyYear,ybdyVillage);
        Map<String ,Object> result = new HashMap<>();
        result.put("record",YvbeidangyuanPage);
        //总页数
        result.put("total",YvbeidangyuanPage.getPages());
        //记录总数
        result.put("count",YvbeidangyuanPage.getTotal());
        //当前第几页
        result.put("nowPage",YvbeidangyuanPage.getPageNum());
        return result;
    }

    @GetMapping(value = "/pageFondYvbeidangyuanByYbdyYear/{ybdyYear}/{startPage}/{pageSize}")
    public Map<String ,Object> pageFondYvbeidangyuanByYbdyYear(@PathVariable(value = "ybdyYear") Integer ybdyYear,
                                                                             @PathVariable(value = "startPage") Integer startPage,
                                                                             @PathVariable(value = "pageSize") Integer pageSize
    ){

        PageHelper.startPage(startPage,pageSize);
        Page<Yvbeidangyuan> YvbeidangyuanPage =  yvbeidangyuanMapper.pageFondYvbeidangyuanByYbdyYear(ybdyYear);
        Map<String ,Object> result = new HashMap<>();
        result.put("record",YvbeidangyuanPage);
        //总页数
        result.put("total",YvbeidangyuanPage.getPages());
        //记录总数
        result.put("count",YvbeidangyuanPage.getTotal());
        //当前第几页
        result.put("nowPage",YvbeidangyuanPage.getPageNum());
        return result;
    }

    @GetMapping(value = "/pageFondYvbeidangyuanByYbdyVillage/{ybdyVillage}/{startPage}/{pageSize}")
    public Map<String ,Object> pageFondYvbeidangyuanByYbdyVillage(@PathVariable(value = "ybdyVillage") Integer ybdyVillage,

                                                               @PathVariable(value = "startPage") Integer startPage,
                                                               @PathVariable(value = "pageSize") Integer pageSize
    ){

        PageHelper.startPage(startPage,pageSize);
        Page<Yvbeidangyuan> YvbeidangyuanPage =  yvbeidangyuanMapper.pageFondYvbeidangyuanByYbdyVillage(ybdyVillage);
        Map<String ,Object> result = new HashMap<>();
        result.put("record",YvbeidangyuanPage);
        //总页数
        result.put("total",YvbeidangyuanPage.getPages());
        //记录总数
        result.put("count",YvbeidangyuanPage.getTotal());
        //当前第几页
        result.put("nowPage",YvbeidangyuanPage.getPageNum());
        return result;
    }
    @GetMapping(value = "/pageFindYvbeidangyuanByZName/{zName}/{startPage}/{pageSize}")
    public Map<String ,Object> pageFindYvbeidangyuanByZName(@PathVariable(value = "zName") String zName,

                                                                  @PathVariable(value = "startPage") Integer startPage,
                                                                  @PathVariable(value = "pageSize") Integer pageSize
    ){

        PageHelper.startPage(startPage,pageSize);
        Page<Yvbeidangyuan> YvbeidangyuanPage =  yvbeidangyuanMapper.pageFindYvbeidangyuanByZName(zName);
        Map<String ,Object> result = new HashMap<>();
        result.put("record",YvbeidangyuanPage);
        //总页数
        result.put("total",YvbeidangyuanPage.getPages());
        //记录总数
        result.put("count",YvbeidangyuanPage.getTotal());
        //当前第几页
        result.put("nowPage",YvbeidangyuanPage.getPageNum());
        return result;
    }
    @GetMapping(value = "/pageYvbeidangyuanByVNameandZName/{zName}/{vName}/{startPage}/{pageSize}")
    public Map<String ,Object> pageYvbeidangyuanByVNameandZName(@PathVariable(value = "zName") String zName,
                                                                @PathVariable(value = "vName") String vName,
                                                            @PathVariable(value = "startPage") Integer startPage,
                                                            @PathVariable(value = "pageSize") Integer pageSize
    ){

        PageHelper.startPage(startPage,pageSize);
        Page<Yvbeidangyuan> YvbeidangyuanPage =  yvbeidangyuanMapper.pageYvbeidangyuanByVNameandZName(zName,vName);
        Map<String ,Object> result = new HashMap<>();
        result.put("record",YvbeidangyuanPage);
        //总页数
        result.put("total",YvbeidangyuanPage.getPages());
        //记录总数
        result.put("count",YvbeidangyuanPage.getTotal());
        //当前第几页
        result.put("nowPage",YvbeidangyuanPage.getPageNum());
        return result;
    }
    @GetMapping(value = "/pageFindYvbeidangyuanByVNameandZNameandQkbgTime/{zName}/{vName}/{qkbgTime}/{startPage}/{pageSize}")
    public Map<String ,Object> pageFindYvbeidangyuanByVNameandZNameandQkbgTime(@PathVariable(value = "zName") String zName,
                                                                @PathVariable(value = "vName") String vName,
                                                                               @PathVariable(value = "qkbgTime") String qkbgTime,
                                                                @PathVariable(value = "startPage") Integer startPage,
                                                                @PathVariable(value = "pageSize") Integer pageSize
    ){

        PageHelper.startPage(startPage,pageSize);
        Page<Yvbeidangyuan> YvbeidangyuanPage =  yvbeidangyuanMapper.pageFindYvbeidangyuanByVNameandZNameandQkbgTime(zName,vName,qkbgTime);
        Map<String ,Object> result = new HashMap<>();
        result.put("record",YvbeidangyuanPage);
        //总页数
        result.put("total",YvbeidangyuanPage.getPages());
        //记录总数
        result.put("count",YvbeidangyuanPage.getTotal());
        //当前第几页
        result.put("nowPage",YvbeidangyuanPage.getPageNum());
        return result;
    }
    @GetMapping(value = "/selectYvbeidangyuan/{startPage}/{pageSize}")
    public Map<String ,Object> selectYvbeidangyuan(
                                                                               @PathVariable(value = "startPage") Integer startPage,
                                                                               @PathVariable(value = "pageSize") Integer pageSize
    ){

        PageHelper.startPage(startPage,pageSize);
        Page<Yvbeidangyuan> YvbeidangyuanPage =  yvbeidangyuanMapper.selectYvbeidangyuan();
        Map<String ,Object> result = new HashMap<>();
        result.put("record",YvbeidangyuanPage);
        //总页数
        result.put("total",YvbeidangyuanPage.getPages());
        //记录总数
        result.put("count",YvbeidangyuanPage.getTotal());
        //当前第几页
        result.put("nowPage",YvbeidangyuanPage.getPageNum());
        return result;
    }
    @GetMapping(value = "/DeleteYvbeidangyuan/{ybdyId}")
    public Map<String ,Object> DeleteYvbeidangyuan(
            @PathVariable(value = "ybdyId") Integer ybdyId


    ){
        Map<String ,Object> map = new HashMap<>();
        Yvbeidangyuan yvbeidangyuan =yvbeidangyuanMapper.queryAll(ybdyId);
        if(yvbeidangyuan==null){
            map.put("result","null");
        }else{
           int result= yvbeidangyuanMapper.DeleteYvbeidangyuan(ybdyId);
           if(result==1){
               map.put("result","success");
           }
           else {
               map.put("result","error");
           }
        }
        return map;
    }
    @GetMapping(value = "/DeleteDuoTiaoYvbeidangyuan/{ybdyId}")
    public Map<String ,Object> DeleteDuoTiaoYvbeidangyuan(
            @PathVariable(value = "ybdyId") String ybdyId


    ){
        Map<String ,Object> map = new HashMap<>();
        int result= yvbeidangyuanMapper.DeleteDuoTiaoYvbeidangyuan(ybdyId);
        map.put("result",result);
        return map;
    }
    @GetMapping(value = "/InsertYvbeidangyuan")
    public Map<String ,Object> InsertYvbeidangyuan(


    ){
        Map<String ,Object> map = new HashMap<>();
        int result= yvbeidangyuanMapper.InsertYvbeidangyuan();
        map.put("result",result);
        return map;
    }
    @GetMapping(value = "/UpdateYvbeidangyuan/{ybdyId}")
    public Map<String ,Object> UpdateYvbeidangyuan(
            @PathVariable(value = "ybdyId") Integer ybdyId


    ){
        Map<String ,Object> map = new HashMap<>();
        int result= yvbeidangyuanMapper.UpdateYvbeidangyuan(ybdyId);
        map.put("result",result);
        return map;
    }

}
