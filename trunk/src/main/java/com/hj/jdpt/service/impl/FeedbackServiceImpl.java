//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.service.impl;

import com.hj.jdpt.domain.Feedback;
import com.hj.jdpt.domain.Yonghu;
import com.hj.jdpt.repository.FeedbackMapper;
import com.hj.jdpt.repository.YonghuMapper;
import com.hj.jdpt.service.FeedbackService;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackMapper feedbackMapper;
    @Autowired
    YonghuMapper yonghuMapper;
    String path0 = "E:\\HJResourse\\Feedback\\";

    public FeedbackServiceImpl() {
    }

    public Map<String, Object> AddFeedback(Feedback feedback, Integer userId, MultipartFile[] photo) {
        Map<String, Object> map = new HashMap();
        long s = System.currentTimeMillis();
        String newName = null;
        String p = null;
        String p2 = null;
        String p3 = null;
        if (photo.length != 0) {
            String path = this.path0;

            for(int i = 0; i < photo.length; ++i) {
                String realName = photo[i].getOriginalFilename();
                newName = s + realName;
                p = newName + ",";
                File newFile = new File(path + newName);
                p2 = p2 + p;

                try {
                    photo[i].transferTo(newFile);
                } catch (IOException var17) {
                    var17.printStackTrace();
                }
            }

            p3 = p2.substring(4);
        }

        try {
            Yonghu yonghu = this.yonghuMapper.queryById(userId);
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            List<Feedback> list = this.feedbackMapper.meiritiaoshuo(userId, dateFormat.format(date));
            if (list.size() >= 3) {
                map.put("statue", "超过每日最大反馈次数");
                return map;
            } else {
                feedback.setfImagepath(p3);
                feedback.setfTime(date);
                feedback.setfJudge(false);
                feedback.setfHandle(false);
                feedback.setfBeiyong2(String.valueOf(yonghu.getUserVillageid()));
                feedback.setfPeopleid(userId);
                if (feedback.getfBeiyong1() != null) {
                    feedback.setfBeiyong1("1");
                    feedback.setfAdmissibleunit(String.valueOf(yonghu.getUserTownship()));
                } else {
                    feedback.setfBeiyong1("0");
                    feedback.setfAdmissibleunit(feedback.getfAdmissibleunit());
                }

                Boolean flag = this.feedbackMapper.AddFeedback(feedback);
                if (flag) {
                    map.put("statue", "success");
                } else {
                    map.put("statue", "false");
                }

                return map;
            }
        } catch (Exception var16) {
            map.put("statue", "error");
            return map;
        }
    }
}
