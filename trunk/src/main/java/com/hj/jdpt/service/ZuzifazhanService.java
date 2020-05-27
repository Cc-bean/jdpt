package com.hj.jdpt.service;

import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface ZuzifazhanService {


    //查询
    public Map<String,Object> Select(Integer villageId, String year, Integer entity, Integer startPage, Integer pageSize);
}

