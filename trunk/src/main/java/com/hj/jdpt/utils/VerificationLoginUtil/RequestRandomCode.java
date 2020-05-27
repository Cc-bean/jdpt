package com.hj.jdpt.utils.VerificationLoginUtil;

public class RequestRandomCode {
    //创建验证码
    public  String smsCode(){

        String random=(int)((Math.random()*9+1)*100000)+"";
        return random;

    }
}
