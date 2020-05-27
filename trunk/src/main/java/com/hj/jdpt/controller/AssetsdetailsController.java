//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Assetsdetails;
import com.hj.jdpt.domain.Zichanjingying;
import com.hj.jdpt.domain.Zichantaizhang;
import com.hj.jdpt.repository.AssetsdetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class AssetsdetailsController {
    @Autowired
    private AssetsdetailsMapper assetsdetailsMapper;

    public AssetsdetailsController() {
    }

    @PostMapping({"/insertAssetsdetails"})
    public Map<String, Object> pageFindAssetsByVillageId(@RequestParam("assetsdetails") Assetsdetails assetsdetails) {
        Map<String, Object> result = new HashMap();
        if (this.assetsdetailsMapper.insert(assetsdetails) == 1) {
            result.put("judge", "success");
        } else {
            result.put("judge", "error");
        }
        return result;
    }

    @GetMapping({"/deleteAssetsdetails/{asId}"})
    public Map<String, Object> delete(@PathVariable("asId") Integer asId) {
        Map<String, Object> result = new HashMap();
        if (this.assetsdetailsMapper.delete(asId) == 1) {
            result.put("judge", "success");
        } else {
            result.put("judge", "error");
        }

        return result;
    }

    @PostMapping({"/updateAssetsdetails"})
    public Map<String, Object> update(@RequestParam("assetsdetails") Assetsdetails assetsdetails) {
        Map<String, Object> result = new HashMap();
        if (this.assetsdetailsMapper.update(assetsdetails) == 1) {
            result.put("judge", "success");
        } else {
            result.put("judge", "error");
        }

        return result;
    }

    @GetMapping({"/findAssetsdetails/{assetsdetailsId}"})
    public Map<String, Object> findAssetsdetails(@PathVariable("assetsdetailsId") Integer assetsdetailsId) {
        HashMap result = new HashMap();

        try {
            Assetsdetails assetsdetails = this.assetsdetailsMapper.findAssetsdetails(assetsdetailsId);
            if (assetsdetails == null) {
                result.put("status", "null");
            } else {
                result.put("status", "success");
                result.put("assetsdetails", assetsdetails);
            }
        } catch (Exception var4) {
            result.put("status", "error");
        }

        return result;
    }

    @GetMapping({"/findByAssetsId/{assetsId}/{startPage}/{pageSize}"})
    public Map<String, Object> findByAssetsId(@PathVariable("assetsId") Integer assetsId, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        HashMap result = new HashMap();

        try {
            PageHelper.startPage(startPage, pageSize);
            Page<Assetsdetails> assetsdetails = this.assetsdetailsMapper.findByAssetsId(assetsId);
            if (assetsdetails.isEmpty()) {
                result.put("status", "null");
            } else {
                result.put("status", "success");
                result.put("record", assetsdetails);
                result.put("total", assetsdetails.getPages());
                result.put("count", assetsdetails.getTotal());
                result.put("nowPage", assetsdetails.getPageNum());
            }
        } catch (Exception var6) {
            result.put("status", "error");
        }

        return result;
    }
    @GetMapping(value = "/findAssetsDetailsByCunid/{villageId}/{startPage}/{pageSize}")
    public Map<String ,Object> findAssetsDetailsByCunid(@PathVariable(value = "villageId") Integer villageId,
                                                        @PathVariable(value = "startPage") Integer startPage,
                                                        @PathVariable(value = "pageSize") Integer pageSize
    ){
        Map<String ,Object> result = new HashMap<>();
        PageHelper.startPage(startPage,pageSize);
        Page<Map<String ,Object>> assetsdetails =  assetsdetailsMapper.findAssetsDetailsByCunid(villageId);
        if(assetsdetails.isEmpty()) {
            result.put("data", "null");
        }else {
            result.put("status", "success");
            List list=new ArrayList();
            for (Map<String ,Object> map:assetsdetails){
                Map<String ,Object> result1 = new HashMap<>();
                Integer ZCMZ_Id=Integer.parseInt(map.get("ZCMZ_Id").toString());
                Zichantaizhang zichantaizhang=assetsdetailsMapper.findZiChanFJY(ZCMZ_Id);
                Zichanjingying zichanjingying=assetsdetailsMapper.findZiChanJY(ZCMZ_Id);
                result1.put("zichantfeijingying",zichantaizhang);
                result1.put("zichanjingying",zichanjingying);
                result1.putAll(map);
                list.add(result1);
            }
            result.put("data", list);
            //总页数
            result.put("total", assetsdetails.getPages());
            //记录总数
            result.put("count", assetsdetails.getTotal());
            //当前第几页
            result.put("nowPage", assetsdetails.getPageNum());
        }

        return result;
    }
}
