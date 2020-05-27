//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.service;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.PartymemberinformationAndYonghu;

public interface Partymemberinformation {
    Page<PartymemberinformationAndYonghu> queryALl(Integer cun_id);

    Page<PartymemberinformationAndYonghu> queryByName(String name, Integer cun_id);

    PartymemberinformationAndYonghu queryById(Integer id);
}
