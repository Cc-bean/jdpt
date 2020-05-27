//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Resourcesdetails;
import com.hj.jdpt.domain.Zu;
import com.hj.jdpt.repository.ResourcesMapper;
import com.hj.jdpt.service.ResourcesService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourcesServiceImpl implements ResourcesService {
    @Autowired
    ResourcesMapper resourcesMapper;

    public ResourcesServiceImpl() {
    }

    public Map<String, Object> queryByCunIdZu(Integer villageId, Integer startPage, Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        HashMap result = new HashMap();

        try {
            Page<Zu> assetsPage = this.resourcesMapper.queryByCunIdZu(villageId);
            if (assetsPage.isEmpty()) {
                result.put("status", "null");
                result.put("data", "没有数据");
            } else {
                result.put("data", assetsPage);
                result.put("total", assetsPage.getPages());
                result.put("count", assetsPage.getTotal());
                result.put("nowPage", assetsPage.getPageNum());
            }
        } catch (Exception var6) {
            result.put("status", "error");
            result.put("data", "查询出错");
        }

        return result;
    }

    public Map<String, Object> findResourcesName(Integer villageId, Integer startPage, Integer pageSize, Integer zuid, Integer R_type) {
        PageHelper.startPage(startPage, pageSize);
        HashMap result = new HashMap();

        try {
            Page<Resourcesdetails> assetsPage = this.resourcesMapper.findResourcesName(villageId, zuid, R_type);
            if (assetsPage.isEmpty()) {
                result.put("status", "null");
                result.put("data", "没有数据");
            } else {
                result.put("data", assetsPage);
                result.put("total", assetsPage.getPages());
                result.put("count", assetsPage.getTotal());
                result.put("nowPage", assetsPage.getPageNum());
            }
        } catch (Exception var8) {
            result.put("status", "error");
            result.put("data", "查询出错");
        }

        return result;
    }
}
