//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Villagecadres;
import com.hj.jdpt.domain.VillagecadresAndJob;
import com.hj.jdpt.repository.VillagecadresMapper;
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
public class VillagecadresController {
    @Autowired
    private VillagecadresMapper villagecadresMapper;

    public VillagecadresController() {
    }

    @GetMapping({"/villagecadres/{villageId}"})
    public Map<String, Object> villagecadres(@PathVariable("villageId") Integer villageId) {
        List<Villagecadres> list = this.villagecadresMapper.FindByCunId(villageId);
        Map<String, Object> result = new HashMap();
        result.put("v", list);
        return result;
    }

    @GetMapping({"/FindVillagecadresById/{villagecadresId}"})
    public Map<String, Object> FindVillagecadresById(@PathVariable("villagecadresId") Integer villagecadresId) {
        Villagecadres villagecadres = this.villagecadresMapper.FindVillagecadresById(villagecadresId);
        Map<String, Object> result = new HashMap();
        result.put("name", villagecadres.getVcName());
        result.put("sex", villagecadres.getVcSex());
        result.put("phone", villagecadres.getVcPhone());
        result.put("GongZi", villagecadres.getVcGongzi());
        result.put("Zhize", villagecadres.getVcZhize());
        return result;
    }

    @GetMapping({"/PageFindVillagecadres/{villageId}/{startPage}/{pageSize}"})
    public Map<String, Object> PageFindVillagecadres(@PathVariable("villageId") Integer villageId, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        Page<VillagecadresAndJob> villagecadresPage = this.villagecadresMapper.PageFindVillagecadres(villageId);
        Map<String, Object> result = new HashMap();
        result.put("record", villagecadresPage);
        result.put("total", villagecadresPage.getPages());
        result.put("count", villagecadresPage.getTotal());
        result.put("nowPage", villagecadresPage.getPageNum());
        return result;
    }
}
