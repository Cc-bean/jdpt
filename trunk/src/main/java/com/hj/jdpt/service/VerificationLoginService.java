package com.hj.jdpt.service;

import java.util.Map;

public interface VerificationLoginService {
    //用于前台忘记密码后找回密码
    public Map<String ,Object> sendMessages(String phone);

    //验证码登录后台验证
    public Map<String ,Object> sendMessagesLogin(String phone);
}
