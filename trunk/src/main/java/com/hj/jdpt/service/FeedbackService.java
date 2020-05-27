//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.service;

import com.hj.jdpt.domain.Feedback;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface FeedbackService {
    Map<String, Object> AddFeedback(Feedback feedback, Integer userId, MultipartFile[] photo);
}
