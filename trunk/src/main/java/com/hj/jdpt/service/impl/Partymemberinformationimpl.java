//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.service.impl;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.PartymemberinformationAndYonghu;
import com.hj.jdpt.repository.NationMapper;
import com.hj.jdpt.repository.PartymemberinformationMapper;
import com.hj.jdpt.service.Partymemberinformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Partymemberinformationimpl implements Partymemberinformation {
    @Autowired
    private PartymemberinformationMapper partymemberinformationMapper;
    @Autowired
    NationMapper nationMapper;

    public Partymemberinformationimpl() {
    }

    public Page<PartymemberinformationAndYonghu> queryALl(Integer cun_id) {
        Page<PartymemberinformationAndYonghu> list = this.partymemberinformationMapper.queryAll(cun_id);
        String nation = null;

        for(int i = 0; i < list.size(); ++i) {
            nation = this.nationMapper.queryById(((PartymemberinformationAndYonghu)list.get(i)).getYonghu().getUserNation());
            if (nation != "" && nation != null) {
                ((PartymemberinformationAndYonghu)list.get(i)).setNation(nation);
            } else {
                ((PartymemberinformationAndYonghu)list.get(i)).setNation("");
            }
        }

        return list;
    }

    public Page<PartymemberinformationAndYonghu> queryByName(String name, Integer cun_id) {
        Page<PartymemberinformationAndYonghu> list = this.partymemberinformationMapper.queryByName(name, cun_id);
        String nation = null;

        for(int i = 0; i < list.size(); ++i) {
            nation = this.nationMapper.queryById(((PartymemberinformationAndYonghu)list.get(i)).getYonghu().getUserNation());
            if (nation != "" && nation != null) {
                ((PartymemberinformationAndYonghu)list.get(i)).setNation(nation);
            } else {
                ((PartymemberinformationAndYonghu)list.get(i)).setNation("");
            }
        }

        return list;
    }

    public PartymemberinformationAndYonghu queryById(Integer id) {
        PartymemberinformationAndYonghu partymemberinformationAndYonghu = this.partymemberinformationMapper.queryById(id);
        String nation = null;
        nation = this.nationMapper.queryById(partymemberinformationAndYonghu.getYonghu().getUserNation());
        if (nation != "" && nation != null) {
            partymemberinformationAndYonghu.setNation(nation);
        } else {
            partymemberinformationAndYonghu.setNation("");
        }

        return partymemberinformationAndYonghu;
    }
}
