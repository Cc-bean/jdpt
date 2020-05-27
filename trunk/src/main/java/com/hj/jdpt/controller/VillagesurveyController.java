//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.hj.jdpt.domain.Village;
import com.hj.jdpt.domain.Villagesurvey;
import com.hj.jdpt.repository.VillageMapper;
import com.hj.jdpt.repository.VillagesurveyMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class VillagesurveyController {
    String path0 = "D:\\Photo\\";
    String path1 = "HJResourse\\\\Village\\\\";
    @Autowired
    private VillagesurveyMapper villagesurveyMapper;
    @Autowired
    private VillageMapper villageMapper;

    public VillagesurveyController() {
    }

    @GetMapping({"/FindVillagesurveyByVid/{villageId}"})
    public Map<String, Object> FindVillagesurveyByVid(@PathVariable("villageId") Integer villageId) {
        Villagesurvey villagesurvey = this.villagesurveyMapper.FindVillagesurveyByVid(villageId);
        Map<String, Object> result = new HashMap();
        result.put("villagesurvey", villagesurvey);
        return result;
    }

    @GetMapping({"/FindVimg/{villageId}"})
    public Map<String, Object> FindVimg(@PathVariable("villageId") Integer villageId) {
        Map<String, Object> map = new HashMap();
        Village village = this.villageMapper.FindVImg(villageId);
        System.out.println(village.toString());

        try {
            String[] result = null;
            List<String> list = new ArrayList();
            String str = village.getvImagepath1();
            System.out.println(str);
            if (str != null) {
                result = str.split(",");

                for(int i = 0; i < result.length; ++i) {
                    list.add(this.path1 + result[i]);
                }
            }

            map.put("img", list);
        } catch (Exception var8) {
            map.put("statue", "error");
        }

        return map;
    }
}
