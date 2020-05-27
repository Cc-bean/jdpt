//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.service;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Law;

public interface LawService {
    Page<Law> queryLawByType(Integer type_id);
}
