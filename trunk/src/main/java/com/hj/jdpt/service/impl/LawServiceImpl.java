//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.service.impl;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Law;
import com.hj.jdpt.repository.LawMapper;
import com.hj.jdpt.service.LawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LawServiceImpl implements LawService {
    @Autowired
    LawMapper lawMapper;

    public LawServiceImpl() {
    }

    public Page<Law> queryLawByType(Integer type_id) {
        String Law_typeName = null;
        switch(type_id) {
            case 0:
                Law_typeName = "";
                break;
            case 1:
                Law_typeName = "党纪党规";
                break;
            case 2:
                Law_typeName = "法律法规";
                break;
            case 3:
                Law_typeName = "政策";
                break;
            case 4:
                Law_typeName = "其他";
                break;
            default:
                Law_typeName = "";
        }

        Page<Law> queryLawByType = this.lawMapper.queryLaw_yyq(Law_typeName);
        return queryLawByType;
    }
}
