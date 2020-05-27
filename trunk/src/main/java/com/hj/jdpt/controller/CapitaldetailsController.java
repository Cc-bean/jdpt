//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Capitaldetails;
import com.hj.jdpt.repository.CapitalMapper;
import com.hj.jdpt.repository.CapitaldetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

@CrossOrigin
@RestController
public class CapitaldetailsController {
    @Autowired
    CapitaldetailsMapper capitaldetailsMapper;
    @Autowired
    CapitalMapper capitalMapper;

    @GetMapping({"/findCapitaldetails/{capitaldetailsId}"})
    public Map<String, Object> findCapitaldetails(@PathVariable("capitaldetailsId") Integer capitaldetailsId) {
        HashMap result = new HashMap();

        try {
            Capitaldetails capitaldetails = this.capitaldetailsMapper.findCapitaldetails(capitaldetailsId);
            if (capitaldetails == null) {
                result.put("status", "null");
            } else {
                result.put("status", "success");
                result.put("capitaldetails", capitaldetails);
            }
        } catch (Exception var4) {
            result.put("status", "error");
        }

        return result;
    }

    @GetMapping({"/deleteCapitaldetails/{capitaldetailsId}"})
    public Map<String, Object> delete(@PathVariable("capitaldetailsId") Integer capitaldetailsId) {
        Map<String, Object> result = new HashMap();
        if (this.capitaldetailsMapper.delete(capitaldetailsId) == 1) {
            result.put("judge", "success");
        } else {
            result.put("judge", "error");
        }

        return result;
    }

    @GetMapping({"/findByZijinId/{capitalId}"})
    public Map<String, Object> findByZijinId(@PathVariable("capitalId") Integer capitalId) {
        HashMap result = new HashMap();

        try {
            Page<Capitaldetails> capitalPage = this.capitaldetailsMapper.findByZijinId(capitalId);
            System.out.println(capitalPage);
            if (capitalPage.isEmpty()) {
                result.put("status", "null");
            } else {
                BigDecimal count = new BigDecimal(0);
                result.put("status", "success");
                List list = new ArrayList();
                Iterator var6 = capitalPage.iterator();

                while(var6.hasNext()) {
                    Capitaldetails c = (Capitaldetails)var6.next();
                    Map<String, Object> map = new HashMap();
                    map.put("zijinxiangqing", c);
                    BigDecimal income = new BigDecimal(0);
                    BigDecimal expenditure = new BigDecimal(0);
                    if (c.getCdIncome() != null) {
                        income = new BigDecimal((double)c.getCdIncome());
                    }

                    if (c.getCdExpenditure() != null) {
                        expenditure = new BigDecimal((double)c.getCdExpenditure());
                    }

                    BigDecimal meicicount = income.subtract(expenditure);
                    map.put("meicishouzhi", meicicount);
                    count = count.add(meicicount);

                    list.add(map);
                }
                result.put("record", list);
                result.put("monthincome", count);
            }
        } catch (Exception var12) {
            result.put("status", "error");
            var12.printStackTrace();
        }

        return result;
    }
}
