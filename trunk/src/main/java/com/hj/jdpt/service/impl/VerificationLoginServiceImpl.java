package com.hj.jdpt.service.impl;

import com.hj.jdpt.service.VerificationLoginService;
import com.hj.jdpt.utils.VerificationLoginUtil.IndustrySMS;
import com.hj.jdpt.utils.VerificationLoginUtil.RequestRandomCode;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.Map;

@Service
public class VerificationLoginServiceImpl implements VerificationLoginService {
    //用于前台忘记密码后找回密码
    @Override
    public Map<String ,Object> sendMessages(String phone) {
        Map<String ,Object> map = new HashMap<>();
        try {
            RequestRandomCode rrc = new RequestRandomCode();
            String code = rrc.smsCode();
            code = new IndustrySMS().execute(phone,code);
            map.put("phone",phone);
            map.put("code",code);
            map.put("state","success");
        }catch (Exception e){
            map.put("state","error");
        }
        return map;
    }


    @Override       //前台验证码登录
    public Map<String ,Object> sendMessagesLogin(String phone) {
        Map<String ,Object> map = new HashMap<>();
        try {
            RequestRandomCode rrc = new RequestRandomCode();
            String code = rrc.smsCode();
            code = new IndustrySMS().execute(phone,code);
            map.put("phone",phone);
            map.put("code",code);
            map.put("state","success");
        }catch (Exception e){
            map.put("state","error");
        }
        return map;
    }
}
