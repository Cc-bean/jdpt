//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.*;
import com.hj.jdpt.repository.AssetsMapper;
import com.hj.jdpt.repository.CapitalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
public class AssetsController {
    @Autowired
    private AssetsMapper assetsMapper;
    @Autowired
    CapitalMapper capitalMapper;

    public AssetsController() {
    }

    @PostMapping({"/insertAssets"})
    public Map<String, Object> pageFindAssetsByVillageId(@RequestParam("assets") Assets assets) {
        Map<String, Object> result = new HashMap();
        if (this.assetsMapper.insert(assets) == 1) {
            result.put("judge", "success");
        } else {
            result.put("judge", "error");
        }

        return result;
    }

    @GetMapping({"/deleteAssets/{asId}"})
    public Map<String, Object> delete(@PathVariable("asId") Integer asId) {
        Map<String, Object> result = new HashMap();
        if (this.assetsMapper.delete(asId) == 1) {
            result.put("judge", "success");
        } else {
            result.put("judge", "error");
        }

        return result;
    }

    @PostMapping({"/updateAssets"})
    public Map<String, Object> update(@RequestParam("assets") Assets assets) {
        Map<String, Object> result = new HashMap();
        if (this.assetsMapper.update(assets) == 1) {
            result.put("judge", "success");
        } else {
            result.put("judge", "error");
        }

        return result;
    }

    @GetMapping({"/selectAssets/{id}"})
    public Map<String, Object> selectAssets(@PathVariable("id") Integer id) {
        Map<String, Object> result = new HashMap();
        Assets assets = this.assetsMapper.selectAssets(id);
        result.put("assets", assets);
        return result;
    }

    @GetMapping({"/pageFindAssetsByVillageId/{villageId}/{startPage}/{pageSize}"})
    public Map<String, Object> pageFindAssetsByVillageId(@PathVariable("villageId") Integer villageId, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        HashMap result = new HashMap();

        try {
            PageHelper.startPage(startPage, pageSize);
            Page<Assets> assetsPage = this.assetsMapper.pageFindAssetsByVillageId(villageId);
            if (assetsPage.isEmpty()) {
                result.put("status", "null");
            } else {
                result.put("status", "success");
                result.put("record", assetsPage);
                result.put("total", assetsPage.getPages());
                result.put("count", assetsPage.getTotal());
                result.put("nowPage", assetsPage.getPageNum());
            }
        } catch (Exception var6) {
            result.put("status", "error");
        }

        return result;
    }

    @GetMapping({"/pageFindAssetsByZuId/{zuId}/{startPage}/{pageSize}"})
    public Map<String, Object> pageFindAssetsByZuId(@PathVariable("zuId") Integer zuId, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        Page<Assets> assetsPage = this.assetsMapper.pageFindAssetsByZuId(zuId);
        Map<String, Object> result = new HashMap();
        result.put("record", assetsPage);
        result.put("total", assetsPage.getPages());
        result.put("count", assetsPage.getTotal());
        result.put("nowPage", assetsPage.getPageNum());
        return result;
    }

    @GetMapping({"/pageFindAssetsByZuVillage/{villageId}/{zuId}/{startPage}/{pageSize}"})
    public Map<String, Object> pageFindAssetsByZuVillage(@PathVariable("villageId") Integer villageId, @PathVariable("zuId") Integer zuId, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        HashMap result = new HashMap();

        try {
            PageHelper.startPage(startPage, pageSize);
            Page<Assets> assetsPage = this.assetsMapper.pageFindAssetsByZuVillage(villageId, zuId);
            if (assetsPage.isEmpty()) {
                result.put("status", "null");
            } else {
                result.put("status", "success");
                result.put("record", assetsPage);
                result.put("total", assetsPage.getPages());
                result.put("count", assetsPage.getTotal());
                result.put("nowPage", assetsPage.getPageNum());
            }
        } catch (Exception var7) {
            result.put("status", "error");
        }

        return result;
    }

    @GetMapping({"/findZuandAssets/{villageId}/{startPage}/{pageSize}"})
    public Map<String, Object> findZuandAssets(@PathVariable("villageId") Integer villageId, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        List<Zu> zu = this.assetsMapper.findZuById(villageId);
        Map<String, Object> result = new HashMap();
        //int i = false;
        List list1 = new ArrayList();
        Iterator var8 = zu.iterator();

        while(var8.hasNext()) {
            Zu zu1 = (Zu)var8.next();
            Map<String, Object> map = new HashMap();
            map.put("zu", zu1);
            PageHelper.startPage(startPage, pageSize);
            Page<Assets> assetsPage = this.assetsMapper.pageFindAssetsByZuId(zu1.getzKey());
            map.put("assets", assetsPage);
            map.put("total", assetsPage.getPages());
            map.put("count", assetsPage.getTotal());
            map.put("nowPage", assetsPage.getPageNum());
            list1.add(map);
        }

        result.put("data", list1);
        return result;
    }

    @GetMapping({"/findZichanmingziById/{assetsId}/{startPage}/{pageSize}"})
    public Map<String, Object> findZichanmingziById(@PathVariable("assetsId") Integer assetsId, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        Map<String, Object> result = new HashMap();
        PageHelper.startPage(startPage, pageSize);
        Page<Zichanmingzi> zichanmingziById = this.capitalMapper.findZichanmingziById(assetsId);
        if (zichanmingziById.isEmpty()) {
            result.put("status", "null");
        } else {
            result.put("status", "success");
            List list = new ArrayList();
            Iterator var7 = zichanmingziById.iterator();

            while(var7.hasNext()) {
                Zichanmingzi z = (Zichanmingzi)var7.next();
                Map<String, Object> map = new HashMap();
                map.put("zichanmingzi", z);
                Zichanjingying zichanjingying = this.capitalMapper.findZichanjingyingById(z.getZcmzId());
                Zichantaizhang zichantaizhang = this.capitalMapper.findZichantaizhangById(z.getZcmzId());
                map.put("zichanjingying", zichanjingying);
                map.put("zichantaizhang", zichantaizhang);
                list.add(map);
            }

            result.put("data", list);
            result.put("total", zichanmingziById.getPages());
            result.put("count", zichanmingziById.getTotal());
            result.put("nowPage", zichanmingziById.getPageNum());
        }

        return result;
    }

    @GetMapping({"/findZichanjingyingById/{assetsNameId}"})
    public Map<String, Object> findZichanjingyingById(@PathVariable("assetsNameId") Integer assetsNameId) {
        Map<String, Object> result = new HashMap();
        Zichanjingying zichanjingying = this.capitalMapper.findZichanjingyingById(assetsNameId);
        if (zichanjingying == null) {
            result.put("status", "null");
        } else {
            result.put("status", "success");
            result.put("data", zichanjingying);
        }

        return result;
    }

    @GetMapping({"/findZichantaizhangById/{assetsNameId}"})
    public Map<String, Object> findZichantaizhangById(@PathVariable("assetsNameId") Integer assetsNameId) {
        Map<String, Object> result = new HashMap();
        Zichantaizhang zichantaizhang = this.capitalMapper.findZichantaizhangById(assetsNameId);
        if (zichantaizhang == null) {
            result.put("status", "null");
        } else {
            result.put("status", "success");
            result.put("data", zichantaizhang);
        }

        return result;
    }
}
