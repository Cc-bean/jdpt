package com.hj.jdpt.service;

import com.hj.jdpt.domain.FamilyinformationForeign;

import java.util.List;

public interface FamilyInformation {
    public List<FamilyinformationForeign> FindFamilyMember(Integer userid);
}
