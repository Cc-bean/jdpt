//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.service;

import java.util.Map;

public interface ResourcesService {
    Map<String, Object> queryByCunIdZu(Integer villageId, Integer startPage, Integer pageSize);

    Map<String, Object> findResourcesName(Integer villageId, Integer startPage, Integer pageSize, Integer zuid, Integer R_type);
}
