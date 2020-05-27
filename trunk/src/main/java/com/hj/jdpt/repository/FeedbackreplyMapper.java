//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.repository;

import com.hj.jdpt.domain.Feedbackreply;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component("feedbackreplyMapper")
public interface FeedbackreplyMapper {
    @Select({"select * from feedbackreply where FR_FeedbackId=#{id}"})
    Feedbackreply FindById_lfm(Integer id);
}
