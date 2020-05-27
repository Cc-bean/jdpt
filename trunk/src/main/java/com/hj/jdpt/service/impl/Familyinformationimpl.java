package com.hj.jdpt.service.impl;

import com.hj.jdpt.domain.FamilyinformationForeign;
import com.hj.jdpt.repository.FamilyinformationMapper;
import com.hj.jdpt.service.FamilyInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Familyinformationimpl implements FamilyInformation {

    @Autowired
    private FamilyinformationMapper familyinformationMapper;

    @Override
    public List<FamilyinformationForeign> FindFamilyMember(Integer userid) {
        return familyinformationMapper.FindJTCY(userid);
    }
}
