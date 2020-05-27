//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.hj.jdpt.domain.Yonghu;
import com.hj.jdpt.repository.YonghuMapper;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MyController {
    @Autowired
    YonghuMapper yonghuMapper;

    public MyController() {
    }

    @GetMapping({"/XiugaiXianShi/{userId}"})
    public Map<String, Object> XiugaiXianShi(@PathVariable("userId") Integer userId) {
        Map<String, Object> map = new HashMap();
        Yonghu yonghu = this.yonghuMapper.findInfo(userId);
        map.put("data", yonghu);
        return map;
    }

    @PostMapping({"/UpdateMy"})
    public Map<String, Object> UpdateMy(Yonghu yonghu, @RequestParam Integer userId) {
        Map<String, Object> map = new HashMap();
        boolean b = this.yonghuMapper.Update(yonghu);
        if (b) {
            map.put("statue", "success");
        } else {
            map.put("statue", "false");
        }

        return map;
    }

    @PostMapping({"/Updatepwd"})
    public Map<String, Object> Updatepwd(Yonghu yonghu, @RequestParam Integer userId) {
        Map<String, Object> map = new HashMap();
        Boolean changePwd = this.yonghuMapper.changePwd(yonghu);
        if (changePwd) {
            map.put("statue", "修改成功");
        } else {
            map.put("statue", "修改失败");
        }

        return map;
    }
}
