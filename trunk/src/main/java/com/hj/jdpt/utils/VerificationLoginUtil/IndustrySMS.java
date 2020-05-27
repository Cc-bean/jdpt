//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.utils.VerificationLoginUtil;

import java.net.URLEncoder;

public class IndustrySMS {
    public IndustrySMS() {
    }

    public static String execute(String phone, String code) {
        String tmpSmsContent = null;
        String smsContent = "【惠济阳光监督】尊敬的用户，您的验证码为" + code + "。";

        try {
            tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
        } catch (Exception var7) {
            ;
        }

        String url = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
        String body = "accountSid=1a3539e306894401952f215530594de8&to=" + phone + "&smsContent=" + tmpSmsContent + (new HttpUtil()).createCommonParam();
        (new HttpUtil()).post(url, body);
        return code;
    }
}
