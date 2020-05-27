package com.hj.jdpt.service;

import com.hj.jdpt.domain.Yonghu;

public interface Loginservice {

    //处理前台用户登录请求
    public Yonghu checkLogin(String username , String userpwd);
}
