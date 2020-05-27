//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.hj.jdpt.bean.AJAXResult;
import com.hj.jdpt.domain.Yonghu;
import com.hj.jdpt.repository.VillageMapper;
import com.hj.jdpt.repository.YonghuMapper;
import com.hj.jdpt.service.Loginservice;
import com.hj.jdpt.service.VerificationLoginService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class LoginController {
    @Autowired
    private Loginservice loginservice;
    @Autowired
    private VillageMapper villageMapper;
    @Autowired
    private VerificationLoginService verificationLoginService;
    @Autowired
    YonghuMapper yonghuMapper;
    Map<String, Object> map = new HashMap();

    public LoginController() {
    }

    @PostMapping({"/login"})
    public Map<String, Object> returnLogin(@RequestParam String username, @RequestParam String userpwd) {
        Map<String, Object> objectMap = new HashMap();
        AJAXResult ajaxResult = new AJAXResult();
        ajaxResult.setSuccess(true);
        if (username == "") {
            ajaxResult.setSuccess(false);
            ajaxResult.setData("用户名为空!");
            objectMap.put("state", ajaxResult.isSuccess());
            objectMap.put("data", ajaxResult.getData());
            return objectMap;
        } else if (userpwd == "") {
            ajaxResult.setSuccess(false);
            ajaxResult.setData("密码为空!");
            objectMap.put("state", ajaxResult.isSuccess());
            objectMap.put("data", ajaxResult.getData());
            return objectMap;
        } else {
            Yonghu yonghu = this.loginservice.checkLogin(username, userpwd);
            if (yonghu != null) {
                String vName = this.villageMapper.FindVImg(yonghu.getUserVillageid()).getvName();
                ajaxResult.setData(yonghu);
                objectMap.put("vName", vName);
                objectMap.put("state", ajaxResult.isSuccess());
                objectMap.put("data", ajaxResult.getData());
            } else {
                ajaxResult.setSuccess(false);
                ajaxResult.setData("用户信息不正确!");
                objectMap.put("state", ajaxResult.isSuccess());
                objectMap.put("data", ajaxResult.getData());
            }

            return objectMap;
        }
    }

    @PostMapping({"/verificationLogin"})
    public void yanZhengLogin(@RequestParam String phone) {
        this.map.clear();
        this.map = this.verificationLoginService.sendMessagesLogin(phone);
    }

    @PostMapping({"/verificationLoginSuccess"})
    public Map<String, Object> yanZhengVLogin(@RequestParam String phone, @RequestParam String vCode) {
        Yonghu yonghu = this.yonghuMapper.checkVLogin(phone);
        Map<String, Object> map1 = new HashMap();
        if (yonghu != null && this.map.get("code").equals(vCode)) {
            map1.put("Udata", yonghu);
            map1.put("state", "success");
        } else {
            map1.put("Udata", (Object)null);
            map1.put("state", "error");
        }

        return map1;
    }
}
