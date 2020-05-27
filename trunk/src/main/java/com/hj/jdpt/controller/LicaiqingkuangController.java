//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.hj.jdpt.domain.Licaiqingkuang;
import com.hj.jdpt.repository.LicaiqingkuangMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class LicaiqingkuangController {
    @Autowired
    LicaiqingkuangMapper licaiqingkuangMapper;

    public LicaiqingkuangController() {
    }

    @GetMapping({"/findLiCaiById/{lcId}"})
    public Map<String, Object> queryOperationManagements(@PathVariable int lcId) {
        Map<String, Object> map = new HashMap();
        if (lcId != 0) {
            Licaiqingkuang licaiqingkuang = this.licaiqingkuangMapper.findLiCaiById(lcId);
            map.put("data", licaiqingkuang);
            map.put("status", "success");
        } else {
            map.put("data", "参数不全");
            map.put("status", "false");
        }

        return map;
    }

    @GetMapping({"/findLicaiByYear"})
    public Map<String, Object> findLicaiByYear(@RequestParam("year") Integer year, @RequestParam("zuId") Integer zuId, @RequestParam(value = "month",required = false) Integer month) {
        Map<String, Object> map = new HashMap();
        if (year != null && zuId != null) {
            if (month == null) {
                month = 0;
            }

            List<Licaiqingkuang> licaiqingkuang = this.licaiqingkuangMapper.findLicaiByYear(year, month, zuId);
            map.put("data", licaiqingkuang);
            map.put("status", "success");
        } else {
            map.put("data", "参数不全");
            map.put("status", "false");
        }

        return map;
    }
}
