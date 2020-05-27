package com.hj.jdpt.service.impl;

import com.hj.jdpt.bean.AJAXResult;
import com.hj.jdpt.domain.Yonghu;
import com.hj.jdpt.repository.YonghuMapper;
import com.hj.jdpt.service.Loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Loginserviceimpl implements Loginservice {

    @Autowired
    private YonghuMapper yonghuMapper;

    @Override       //验证用户登录是否正确
    public Yonghu checkLogin(String username , String userpwd) {
        return yonghuMapper.checkLogin(username, userpwd);

    }
}
