package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Dangyuanzhuanzheng;
import com.hj.jdpt.repository.DangyuanzhuanzhengMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin
@RestController
public class DangyuanzhuanzhengController {
    @Autowired
    private DangyuanzhuanzhengMapper dangyuanzhuanzhengMapper;

    @GetMapping(value = "/pageFindDangyuanzhuanzhengByDyzzYearanDdyzzVillage/{dyzzYear}/{dyzzVillage}/{startPage}/{pageSize}")
    public Map<String, Object> pageFindDangyuanzhuanzhengByDyzzYearanDdyzzVillage(@PathVariable(value = "dyzzYear") Integer dyzzYear,
                                                                                  @PathVariable(value = "dyzzVillage") Integer dyzzVillage,
                                                                                  @PathVariable(value = "startPage") Integer startPage,
                                                                                  @PathVariable(value = "pageSize") Integer pageSize
    ) {

        PageHelper.startPage(startPage, pageSize);
        Page<Dangyuanzhuanzheng> DangyuanzhuanzhengPage = dangyuanzhuanzhengMapper.pageFindDangyuanzhuanzhengByDyzzYearanDdyzzVillage(dyzzYear, dyzzVillage);
        Map<String, Object> result = new HashMap<>();
        result.put("record", DangyuanzhuanzhengPage);
        //总页数
        result.put("total", DangyuanzhuanzhengPage.getPages());
        //记录总数
        result.put("count", DangyuanzhuanzhengPage.getTotal());
        //当前第几页
        result.put("nowPage", DangyuanzhuanzhengPage.getPageNum());
        return result;
    }


    @GetMapping(value = "/pageFindDangyuanzhuanzhengByDyzzYear/{dyzzYear}/{startPage}/{pageSize}")
    public Map<String ,Object> pageFindDangyuanzhuanzhengByDyzzYear(@PathVariable(value = "dyzzYear") Integer dyzzYear,
                                                                                  @PathVariable(value = "startPage") Integer startPage,
                                                                                  @PathVariable(value = "pageSize") Integer pageSize
    ){

        PageHelper.startPage(startPage,pageSize);
        Page<Dangyuanzhuanzheng> DangyuanzhuanzhengPage =  dangyuanzhuanzhengMapper.pageFindDangyuanzhuanzhengByDyzzYear(dyzzYear);
        Map<String ,Object> result = new HashMap<>();
        result.put("record",DangyuanzhuanzhengPage);
        //总页数
        result.put("total",DangyuanzhuanzhengPage.getPages());
        //记录总数
        result.put("count",DangyuanzhuanzhengPage.getTotal());
        //当前第几页
        result.put("nowPage",DangyuanzhuanzhengPage.getPageNum());
        return result;
    }

    @GetMapping(value = "/pageFindDangyuanzhuanzhengByDyzzVillage/{dyzzVillage}/{startPage}/{pageSize}")
    public Map<String ,Object> pageFindDangyuanzhuanzhengByDyzzVillage(@PathVariable(value = "dyzzVillage") Integer dyzzVillage,
                                                                                  @PathVariable(value = "startPage") Integer startPage,
                                                                                  @PathVariable(value = "pageSize") Integer pageSize
    ){

        PageHelper.startPage(startPage,pageSize);
        Page<Dangyuanzhuanzheng> DangyuanzhuanzhengPage =  dangyuanzhuanzhengMapper.pageFindDangyuanzhuanzhengByDyzzVillage(dyzzVillage);
        Map<String ,Object> result = new HashMap<>();
        result.put("record",DangyuanzhuanzhengPage);
        //总页数
        result.put("total",DangyuanzhuanzhengPage.getPages());
        //记录总数
        result.put("count",DangyuanzhuanzhengPage.getTotal());
        //当前第几页
        result.put("nowPage",DangyuanzhuanzhengPage.getPageNum());
        return result;
    }
    @GetMapping(value = "/pageFindDangyuanzhuanzhengByZName/{zName}/{startPage}/{pageSize}")
    public Map<String ,Object> pageFindDangyuanzhuanzhengByZName(@PathVariable(value = "zName") String zName,
                                                                       @PathVariable(value = "startPage") Integer startPage,
                                                                       @PathVariable(value = "pageSize") Integer pageSize
    ){

        PageHelper.startPage(startPage,pageSize);
        Page<Dangyuanzhuanzheng> DangyuanzhuanzhengPage =  dangyuanzhuanzhengMapper.pageFindDangyuanzhuanzhengByZName(zName);
        Map<String ,Object> result = new HashMap<>();
        result.put("record",DangyuanzhuanzhengPage);
        //总页数
        result.put("total",DangyuanzhuanzhengPage.getPages());
        //记录总数
        result.put("count",DangyuanzhuanzhengPage.getTotal());
        //当前第几页
        result.put("nowPage",DangyuanzhuanzhengPage.getPageNum());
        return result;
    }
    @GetMapping(value = "/pageFindDangyuanzhuanzhengByVNameandZName/{zName}/{vName}/{startPage}/{pageSize}")
    public Map<String ,Object> pageFindDangyuanzhuanzhengByVNameandZName(@PathVariable(value = "zName") String zName,
                                                                         @PathVariable(value = "vName") String vName,
                                                                 @PathVariable(value = "startPage") Integer startPage,
                                                                 @PathVariable(value = "pageSize") Integer pageSize
    ){

        PageHelper.startPage(startPage,pageSize);
        Page<Dangyuanzhuanzheng> DangyuanzhuanzhengPage =  dangyuanzhuanzhengMapper.pageFindDangyuanzhuanzhengByVNameandZName(zName,vName);
        Map<String ,Object> result = new HashMap<>();
        result.put("record",DangyuanzhuanzhengPage);
        //总页数
        result.put("total",DangyuanzhuanzhengPage.getPages());
        //记录总数
        result.put("count",DangyuanzhuanzhengPage.getTotal());
        //当前第几页
        result.put("nowPage",DangyuanzhuanzhengPage.getPageNum());
        return result;
    }
    @GetMapping(value = "/pageFindDangyuanzhuanzhengByVNameandZNameandQkbgTime/{zName}/{vName}/{qkbgTime}/{startPage}/{pageSize}")
    public Map<String ,Object> pageFindDangyuanzhuanzhengByVNameandZNameandQkbgTime(@PathVariable(value = "zName") String zName,
                                                                                    @PathVariable(value = "vName") String vName,
                                                                                    @PathVariable(value = "qkbgTime") String qkbgTime,
                                                                                    @PathVariable(value = "startPage") Integer startPage,
                                                                                    @PathVariable(value = "pageSize") Integer pageSize
    ){

        PageHelper.startPage(startPage,pageSize);
        Page<Dangyuanzhuanzheng> DangyuanzhuanzhengPage =  dangyuanzhuanzhengMapper.pageFindDangyuanzhuanzhengByVNameandZNameandQkbgTime(zName,vName,qkbgTime);
        Map<String ,Object> result = new HashMap<>();
        result.put("record",DangyuanzhuanzhengPage);
        //总页数
        result.put("total",DangyuanzhuanzhengPage.getPages());
        //记录总数
        result.put("count",DangyuanzhuanzhengPage.getTotal());
        //当前第几页
        result.put("nowPage",DangyuanzhuanzhengPage.getPageNum());
        return result;
    }
    @GetMapping(value = "/selectdangyuanzhuanzheng/{startPage}/{pageSize}")
    public Map<String ,Object> selectdangyuanzhuanzheng(
                                                                                    @PathVariable(value = "startPage") Integer startPage,
                                                                                    @PathVariable(value = "pageSize") Integer pageSize
    ){

        PageHelper.startPage(startPage,pageSize);
        Page<Dangyuanzhuanzheng> DangyuanzhuanzhengPage =  dangyuanzhuanzhengMapper.selectdangyuanzhuanzheng();
        Map<String ,Object> result = new HashMap<>();
        result.put("record",DangyuanzhuanzhengPage);
        //总页数
        result.put("total",DangyuanzhuanzhengPage.getPages());
        //记录总数
        result.put("count",DangyuanzhuanzhengPage.getTotal());
        //当前第几页
        result.put("nowPage",DangyuanzhuanzhengPage.getPageNum());
        return result;
    }
    @GetMapping(value = "/DeleteDangyuanzhuanzheng/{dyzzId}")
    public Map<String ,Object> DeleteDangyuanzhuanzheng(
            @PathVariable(value = "dyzzId") Integer dyzzId

    ){

        Dangyuanzhuanzheng dangyuanzhuanzheng =dangyuanzhuanzhengMapper.queryAll(dyzzId);
        Map<String ,Object> map = new HashMap<>();
        if(dangyuanzhuanzheng==null){
            map.put("result","null");
        }else{
           int result= dangyuanzhuanzhengMapper.DeleteDangyuanzhuanzheng(dyzzId);
            if(result==1){
                map.put("result","success");
            }else{
                map.put("result","error");
            }
        }

        return map;
    }
    @GetMapping(value = "/DeleteDuoTiaoDangyuanzhuanzheng/{dyzzId}")
    public Map<String ,Object> DeleteDuoTiaoDangyuanzhuanzheng(
            @PathVariable(value = "dyzzId") String dyzzId

    ){

        Map<String ,Object> map = new HashMap<>();
        int result= dangyuanzhuanzhengMapper.DeleteDuoTiaoDangyuanzhuanzheng(dyzzId);
        map.put("result",result);
        return map;
    }
    @GetMapping(value = "/Insertdangyuanzhuanzheng")
    public Map<String ,Object> Insertdangyuanzhuanzheng(
    ){

        Map<String ,Object> map = new HashMap<>();
        int result= dangyuanzhuanzhengMapper.Insertdangyuanzhuanzheng();
        map.put("result",result);
        return map;
    }
    @GetMapping(value = "/UpdateDangyuanzhuanzheng/{dyzzId}")
    public Map<String ,Object> UpdateDangyuanzhuanzheng(
            @PathVariable(value = "dyzzId") Integer dyzzId

    ){

        Map<String ,Object> map = new HashMap<>();
        int result= dangyuanzhuanzhengMapper.UpdateDangyuanzhuanzheng(dyzzId);
        map.put("result",result);
        return map;
    }
}
