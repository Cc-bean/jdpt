//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.service;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Policy;

public interface PolicyService {
    Page<Policy> queryPolicyByType(Integer type_id);
}
