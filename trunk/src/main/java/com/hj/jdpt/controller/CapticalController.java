//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Capital;
import com.hj.jdpt.domain.Capitaldetails;
import com.hj.jdpt.domain.Zu;
import com.hj.jdpt.repository.AssetsMapper;
import com.hj.jdpt.repository.CapitalMapper;
import com.hj.jdpt.repository.CapitaldetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@CrossOrigin
@RestController
public class CapticalController {
    @Autowired
    CapitalMapper capitalMapper;
    @Autowired
    AssetsMapper assetsMapper;
    @Autowired
    CapitaldetailsMapper capitaldetailsMapper;

    public CapticalController() {
    }

    @GetMapping({"/findCapital/{capitalId}"})
    public Map<String, Object> findCapital(@PathVariable("capitalId") Integer capitalId) {
        Map<String, Object> result = new HashMap();
        Capital capital = this.capitalMapper.findCapital(capitalId);
        result.put("capital", capital);
        return result;
    }

    @PostMapping({"/insertCapital"})
    public Map<String, Object> insert(@RequestParam("capital") Capital capital) {
        Map<String, Object> result = new HashMap();
        if (this.capitalMapper.insert(capital) == 1) {
            result.put("judge", "success");
        } else {
            result.put("judge", "error");
        }

        return result;
    }

    @GetMapping({"/deleteCapital/{capitalId}"})
    public Map<String, Object> delete(@PathVariable("capitalId") Integer capitalId) {
        Map<String, Object> result = new HashMap();
        if (this.capitalMapper.delete(capitalId) == 1) {
            result.put("judge", "success");
        } else {
            result.put("judge", "error");
        }

        return result;
    }

    @PostMapping({"/updateCapital"})
    public Map<String, Object> update(@RequestParam("capital") Capital capital) {
        Map<String, Object> result = new HashMap();
        if (this.capitalMapper.update(capital) == 1) {
            result.put("judge", "success");
        } else {
            result.put("judge", "error");
        }

        return result;
    }

    @GetMapping({"/findZuById/{villageId}"})
    public Map<String, Object> findByCaptical(@PathVariable("villageId") Integer villageId) {
        HashMap result = new HashMap();

        try {
            List<Zu> capitalPage = this.assetsMapper.findZuById(villageId);
            result.put("record", capitalPage);
        } catch (Exception var4) {
            result.put("status", "error");
        }

        return result;
    }

    @GetMapping({"/findByCapticalZu/{villageId}/{zuId}/{startPage}/{pageSize}"})
    public Map<String, Object> findByCapticalZu(@PathVariable("villageId") Integer villageId, @PathVariable("zuId") Integer zuId, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        Map<String, Object> result = new HashMap();
        PageHelper.startPage(startPage, pageSize);
        Page<Capital> capitalPage = this.capitalMapper.findByCapticalZu(villageId, zuId);
        List list = new ArrayList();
        Iterator var8 = capitalPage.getResult().iterator();

        while(var8.hasNext()) {
            Capital c = (Capital)var8.next();
            Map<String, Object> map = new HashMap();
            Page<Capitaldetails> capitaldetails = this.capitaldetailsMapper.findByZijinId(c.getCapitalId());
            BigDecimal income = new BigDecimal(c.getCdBeiyong1().replace(",", ""));
            BigDecimal expenditure = new BigDecimal(c.getCdBeiyong2().replace(",", ""));
            BigDecimal count = income.subtract(expenditure);
            map.put("monthincome", count);
            map.put("capitaldetails", capitaldetails);
            list.add(map);
        }

        result.put("status", "success");
        result.put("data", list);
        result.put("total", capitalPage.getPages());
        result.put("count", capitalPage.getTotal());
        result.put("nowPage", capitalPage.getPageNum());
        return result;
    }

    @GetMapping({"/findByYearStyle/{villageId}/{zuId}/{year}/{style}/{startPage}/{pageSize}"})
    public Map<String, Object> findByYearStyle(@PathVariable("villageId") Integer villageId, @PathVariable("zuId") Integer zuId, @PathVariable("year") String year, @PathVariable("style") String style, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        HashMap result = new HashMap();

        try {
            PageHelper.startPage(startPage, pageSize);
            Page<Capital> capitalPage = this.capitalMapper.findByYearStyle(villageId, year, zuId, style);
            System.out.println(villageId + "    " + year + "    " + zuId + "    " + style);
            if (capitalPage.isEmpty()) {
                result.put("status", "null");
            } else {
                result.put("status", "success");
                result.put("record", capitalPage);
                System.out.println(capitalPage);
                result.put("total", capitalPage.getPages());
                result.put("count", capitalPage.getTotal());
                result.put("nowPage", capitalPage.getPageNum());
            }
        } catch (Exception var9) {
            result.put("status", "error");
        }

        return result;
    }

    @GetMapping({"/countByassetsId/{capitalId}/{startPage}/{pageSize}"})
    public Map<String, Object> countByassetsId(@PathVariable("capitalId") Integer capitalId, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        Capital capital = this.capitalMapper.countByassetsId(capitalId);
        Map<String, Object> result = new HashMap();
        System.out.println(capital.getCdBeiyong1());
        BigDecimal income = new BigDecimal(capital.getCdBeiyong1().replace(",", ""));
        BigDecimal expenditure = new BigDecimal(capital.getCdBeiyong2().replace(",", ""));
        BigDecimal count = income.subtract(expenditure);
        result.put("income", income);
        result.put("expenditure", expenditure);
        result.put("monthincome", count);
        return result;
    }

    @GetMapping({"/findByStyleVidZuid/{villageId}/{zuId}/{style}/{startPage}/{pageSize}"})
    public Map<String, Object> findByStyleVidZuid(@PathVariable("villageId") Integer villageId, @PathVariable("zuId") Integer zuId, @PathVariable("style") String style, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        Map<String, Object> result = new HashMap();
        PageHelper.startPage(startPage, pageSize);
        Page<Capital> capital = this.capitalMapper.findByStyleVidZuid(villageId, zuId, style);
        List list = new ArrayList();
        Iterator var9 = capital.iterator();

        while(var9.hasNext()) {
            Capital c = (Capital)var9.next();
            Map<String, Object> map = new HashMap();
            Page<Capitaldetails> capitaldetails = this.capitaldetailsMapper.findByZijinId(c.getCapitalId());
            BigDecimal income = new BigDecimal(c.getCdBeiyong1().replace(",", ""));
            BigDecimal expenditure = new BigDecimal(c.getCdBeiyong2().replace(",", ""));
            BigDecimal count = income.subtract(expenditure);
            map.put("monthincome", count);
            map.put("capitaldetails", capitaldetails);
            list.add(map);
        }

        result.put("status", "success");
        result.put("data", list);
        result.put("total", capital.getPages());
        result.put("count", capital.getTotal());
        result.put("nowPage", capital.getPageNum());
        return result;
    }

    @GetMapping({"/findZuandCapital/{villageId}/{startPage}/{pageSize}"})
    public Map<String, Map<String, Object>> findZuandAssets(@PathVariable("villageId") Integer villageId, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        List<Zu> zu = this.assetsMapper.findZuById(villageId);
        Map<String, Map<String, Object>> result = new HashMap();
        Iterator var6 = zu.iterator();

        while(var6.hasNext()) {
            Zu zu1 = (Zu)var6.next();
            Map<String, Object> zumap = new HashMap();
            zumap.put("zu", zu1);
            Page<Capital> capitalPage = this.capitalMapper.findByCapticalZu(villageId, zu1.getzKey());
            zumap.put("assets", capitalPage);
            result.put("data" + zu1.getzKey(), zumap);
        }

        return result;
    }
}
