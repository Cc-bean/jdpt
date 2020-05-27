//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class AController {
    public AController() {
    }

    @GetMapping({"/a"})
    public Map<String, Object> AA() {
        Map<String, Object> map = new HashMap();
        map.put("ss", "dd");
        map.put("as", "dd");
        map.put("cs", "dd");
        map.put("fs", "dd");
        return map;
    }
}
