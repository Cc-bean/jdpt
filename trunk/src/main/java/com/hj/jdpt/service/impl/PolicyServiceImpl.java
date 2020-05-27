//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.service.impl;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Policy;
import com.hj.jdpt.repository.PolicyMapper;
import com.hj.jdpt.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyServiceImpl implements PolicyService {
    @Autowired
    PolicyMapper policyMapper;

    public PolicyServiceImpl() {
    }

    public Page<Policy> queryPolicyByType(Integer type_id) {
        Page<Policy> policies = this.policyMapper.queryPolicyByType_yyq(type_id);
        return policies;
    }
}
