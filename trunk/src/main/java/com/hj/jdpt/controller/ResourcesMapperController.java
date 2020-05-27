//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Zu;
import com.hj.jdpt.repository.ResourcesMapper;
import com.hj.jdpt.repository.ResourcesdetailsMapper;
import com.hj.jdpt.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class ResourcesMapperController {
    @Autowired
    ResourcesMapper resourcesMapper;
    @Autowired
    ResourcesService resourcesService;
    @Autowired
    ResourcesdetailsMapper resourcesdetailsMapper;
    public ResourcesMapperController() {
    }

    @GetMapping({"/ziyuanQueryByCunId/{villageId}/{startPage}/{pageSize}"})
    public Map<String, Object> ziyuanQueryByCunId(@PathVariable("villageId") Integer villageId, @PathVariable Integer startPage, @PathVariable Integer pageSize) {
        Map<String, Object> result = new HashMap();
        if (villageId != null && startPage != null && pageSize != null) {
            Map<String, Object> map2 = this.resourcesService.queryByCunIdZu(villageId, startPage, pageSize);
            result.put("data1", map2);
            List<Zu> list = this.resourcesMapper.queryByCunIdZu(villageId);
            List list1 = new ArrayList();

            for(int i = 0; i < list.size(); ++i) {
                Map<String, Object> map = new HashMap();
                int zid = (list.get(i)).getzKey();
                List<Map<String, Object>> list3 = this.resourcesMapper.queryByCunZuId(villageId, zid);
                map.put("zu", list.get(i));
                map.put("type", list3);
                list1.add(map);
            }

            result.put("data2", list1);
        } else {
            result.put("data", "数据输入不完整");
        }

        return result;
    }

    @GetMapping({"/ziyuanQueryFangChanName/{villageId}/{zuid}/{R_type}/{startPage}/{pageSize}"})
    public Map<String, Object> ziyuanQueryFangChanName(@PathVariable("villageId") Integer villageId, @PathVariable("zuid") Integer zuid, @PathVariable("R_type") Integer R_type, @PathVariable Integer startPage, @PathVariable Integer pageSize) {
        HashMap result = new HashMap();

        try {
            Map<String, Object> list = this.resourcesService.findResourcesName(villageId, startPage, pageSize, zuid, R_type);
            if (list == null) {
                result.put("status", "null");
            } else {
                result.put("status", "success");
                result.put("fangchanname", list);
            }
        } catch (Exception var8) {
            result.put("status", "error");
        }

        return result;
    }
    @GetMapping(value = "/ResourceSelectDetalies/{villageId}/{startPage}/{pageSize}")
    public Map<String,Object>ResourceSelectDetalies(@PathVariable(value = "villageId")Integer villageId,
                                                    @PathVariable(value = "startPage")Integer startPage,
                                                    @PathVariable(value = "pageSize")Integer pageSize
    ){
        Map<String,Object> result =new HashMap<>();
        PageHelper.startPage(startPage,pageSize);

        Page<Map<String,Object>> list = resourcesdetailsMapper.findResourceDetaile(villageId);

            result.put("status", "success");
            result.put("data", list);
            //总页数
            result.put("total", list.getPages());
            //记录总数
            result.put("count", list.getTotal());
            //当前第几页
            result.put("nowPage", list.getPageNum());
        return result;
    }
}
