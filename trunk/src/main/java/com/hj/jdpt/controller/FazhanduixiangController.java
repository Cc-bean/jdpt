package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Fazhanduixiang;
import com.hj.jdpt.repository.FazhanduixiangMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin
@RestController
public class FazhanduixiangController {
    @Autowired
    private FazhanduixiangMapper fazhanduixiangMapper;

    @GetMapping(value = "/pageFindFazhanduixiangByFzdxYearandFzdxVillage/{fzdxYear}/{fzdxVillage}/{startPage}/{pageSize}")
    public Map<String, Object> pageFindJijifenziByJjfzVillageandJjfzYear(@PathVariable(value = "fzdxYear") Integer fzdxYear,
                                                                         @PathVariable(value = "fzdxVillage") Integer fzdxVillage,
                                                                         @PathVariable(value = "startPage") Integer startPage,
                                                                         @PathVariable(value = "pageSize") Integer pageSize
    ) {

        PageHelper.startPage(startPage, pageSize);
        Page<Fazhanduixiang> FazhanduixiangPage = fazhanduixiangMapper.pageFindFazhanduixiangByFzdxYearandFzdxVillage(fzdxYear, fzdxVillage);
        Map<String, Object> result = new HashMap<>();
        result.put("record", FazhanduixiangPage);
        //总页数
        result.put("total", FazhanduixiangPage.getPages());
        //记录总数
        result.put("count", FazhanduixiangPage.getTotal());
        //当前第几页
        result.put("nowPage", FazhanduixiangPage.getPageNum());
        return result;
    }

    @GetMapping(value = "/pageFindFazhanduixiangByFzdxYear/{fzdxYear}/{startPage}/{pageSize}")
    public Map<String, Object> pageFindJijifenziByJjfzVillageandJjfzYear(
            @PathVariable(value = "fzdxYear") Integer fzdxYear,
            @PathVariable(value = "startPage") Integer startPage,
            @PathVariable(value = "pageSize") Integer pageSize
    ) {

        PageHelper.startPage(startPage, pageSize);
        Page<Fazhanduixiang> FazhanduixiangPage = fazhanduixiangMapper.pageFindFazhanduixiangByFzdxYear(fzdxYear);
        Map<String, Object> result = new HashMap<>();
        result.put("record", FazhanduixiangPage);
        //总页数
        result.put("total", FazhanduixiangPage.getPages());
        //记录总数
        result.put("count", FazhanduixiangPage.getTotal());
        //当前第几页
        result.put("nowPage", FazhanduixiangPage.getPageNum());
        return result;
    }

    @GetMapping(value = "/pageFindFazhanduixiangByFzdxVillage/{fzdxVillage}/{startPage}/{pageSize}")
    public Map<String, Object> pageFindFazhanduixiangByFzdxVillage(
            @PathVariable(value = "fzdxVillage") Integer fzdxVillage,
            @PathVariable(value = "startPage") Integer startPage,
            @PathVariable(value = "pageSize") Integer pageSize
    ) {

        PageHelper.startPage(startPage, pageSize);
        Page<Fazhanduixiang> FazhanduixiangPage = fazhanduixiangMapper.pageFindFazhanduixiangByFzdxVillage(fzdxVillage);
        Map<String, Object> result = new HashMap<>();
        result.put("record", FazhanduixiangPage);
        //总页数
        result.put("total", FazhanduixiangPage.getPages());
        //记录总数
        result.put("count", FazhanduixiangPage.getTotal());
        //当前第几页
        result.put("nowPage", FazhanduixiangPage.getPageNum());
        return result;
    }

    @GetMapping(value = "/pageFindFazhanduixiangByZName/{zName}/{startPage}/{pageSize}")
    public Map<String, Object> pageFindFazhanduixiangByZName(
            @PathVariable(value = "zName") String zName,
            @PathVariable(value = "startPage") Integer startPage,
            @PathVariable(value = "pageSize") Integer pageSize
    ) {

        PageHelper.startPage(startPage, pageSize);
        Page<Fazhanduixiang> FazhanduixiangPage = fazhanduixiangMapper.pageFindFazhanduixiangByZName(zName);
        Map<String, Object> result = new HashMap<>();
        result.put("record", FazhanduixiangPage);
        //总页数
        result.put("total", FazhanduixiangPage.getPages());
        //记录总数
        result.put("count", FazhanduixiangPage.getTotal());
        //当前第几页
        result.put("nowPage", FazhanduixiangPage.getPageNum());
        return result;
    }

    @GetMapping(value = "/pageFindFazhanduixiangByVNameandZName/{zName}/{vName}/{startPage}/{pageSize}")
    public Map<String, Object> pageFindFazhanduixiangByVNameandZName(
            @PathVariable(value = "zName") String zName,
            @PathVariable(value = "vName") String vName,
            @PathVariable(value = "startPage") Integer startPage,
            @PathVariable(value = "pageSize") Integer pageSize
    ) {

        PageHelper.startPage(startPage, pageSize);
        Page<Fazhanduixiang> FazhanduixiangPage = fazhanduixiangMapper.pageFindFazhanduixiangByVNameandZName(zName, vName);
        Map<String, Object> result = new HashMap<>();
        result.put("record", FazhanduixiangPage);
        //总页数
        result.put("total", FazhanduixiangPage.getPages());
        //记录总数
        result.put("count", FazhanduixiangPage.getTotal());
        //当前第几页
        result.put("nowPage", FazhanduixiangPage.getPageNum());
        return result;
    }

    @GetMapping(value = "/pageFindFazhanduixiangByVNameandZNameandQkbgTime/{zName}/{vName}/{qkbgTime}/{startPage}/{pageSize}")
    public Map<String, Object> pageFindFazhanduixiangByVNameandZNameandQkbgTime(
            @PathVariable(value = "zName") String zName,
            @PathVariable(value = "vName") String vName,
            @PathVariable(value = "qkbgTime") String qkbgTime,
            @PathVariable(value = "startPage") Integer startPage,
            @PathVariable(value = "pageSize") Integer pageSize
    ) {

        PageHelper.startPage(startPage, pageSize);
        Page<Fazhanduixiang> FazhanduixiangPage = fazhanduixiangMapper.pageFindFazhanduixiangByVNameandZNameandQkbgTime(zName, vName, qkbgTime);
        Map<String, Object> result = new HashMap<>();
        result.put("record", FazhanduixiangPage);
        //总页数
        result.put("total", FazhanduixiangPage.getPages());
        //记录总数
        result.put("count", FazhanduixiangPage.getTotal());
        //当前第几页
        result.put("nowPage", FazhanduixiangPage.getPageNum());
        return result;
    }

    @GetMapping(value = "/selectFazhanduixiang/{startPage}/{pageSize}")
    public Map<String, Object> selectFazhanduixiang(

            @PathVariable(value = "startPage") Integer startPage,
            @PathVariable(value = "pageSize") Integer pageSize
    ) {

        PageHelper.startPage(startPage, pageSize);
        Page<Fazhanduixiang> FazhanduixiangPage = fazhanduixiangMapper.selectFazhanduixiang();
        Map<String, Object> result = new HashMap<>();
        result.put("record", FazhanduixiangPage);
        //总页数
        result.put("total", FazhanduixiangPage.getPages());
        //记录总数
        result.put("count", FazhanduixiangPage.getTotal());
        //当前第几页
        result.put("nowPage", FazhanduixiangPage.getPageNum());
        return result;
    }

    @GetMapping(value = "/DeleteFazhanduixiang/{fzdxId}")
    public Map<String, Object> DeleteFazhanduixiang(
            @PathVariable(value = "fzdxId") Integer fzdxId

    ) {
        Map<String, Object> map = new HashMap<>();
        Fazhanduixiang fazhanduixiang = fazhanduixiangMapper.queryAll(fzdxId);
        if (fazhanduixiang == null) {
            map.put("result", "null");
        } else{
            int result=fazhanduixiangMapper.DeleteFazhanduixiang(fzdxId);
            if(result==1){
                map.put("result", "success");
            }else {
                map.put("result", "error");
            }
        }
        return map;
    }
    @GetMapping(value = "/DeleteDuoTiaoFazhanduixiang/{fzdxId}")
    public Map<String, Object> DeleteDuoTiaoFazhanduixiang(
            @PathVariable(value = "fzdxId") String fzdxId

    ) {
        Map<String, Object> map = new HashMap<>();
            int result=fazhanduixiangMapper.DeleteDuoTiaoFazhanduixiang(fzdxId);
            map.put("result",result);
            return map;
    }
    @GetMapping(value = "/InsertFazhanduixiang")
    public Map<String, Object> InsertFazhanduixiang(
    ) {
        Map<String, Object> map = new HashMap<>();
        int result=fazhanduixiangMapper.InsertFazhanduixiang();
        map.put("result",result);
        return map;
    }
    @GetMapping(value = "/UpdateFazhanduixiang/{fzdxId}")
    public Map<String, Object> UpdateFazhanduixiang(
            @PathVariable(value = "fzdxId") Integer fzdxId

    ) {
        Map<String, Object> map = new HashMap<>();
        Fazhanduixiang fazhanduixiang = fazhanduixiangMapper.queryAll(fzdxId);
        if(fazhanduixiang==null){
            map.put("result","null");
        }else {
            int result = fazhanduixiangMapper.UpdateFazhanduixiang(fzdxId);
            if(result==1){
                map.put("result", "success");
            }else {
                map.put("result", "error");
            }
        }
        return map;
    }




}
