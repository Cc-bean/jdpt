//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.*;
import com.hj.jdpt.repository.*;
import com.hj.jdpt.service.FeedbackService;
import com.hj.jdpt.utils.BadWordUtil2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class FeedbackController {
    @Autowired
    YonghuMapper yonghuMapper;
    @Autowired
    ZhenMapper zhenMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    BacktypeMapper backtypeMapper;
    @Autowired
    FeedbackMapper feedbackMapper;
    @Autowired
    FeedbackService feedbackService;
    @Autowired
    FeedbackreplyMapper feedbackreplyMapper;

    public FeedbackController() {
    }

    @GetMapping({"/FindByZid/{userid}"})
    public Map<String, Object> FindByZid(@PathVariable("userid") Integer userid) {
        Yonghu yonghu = this.yonghuMapper.queryById(userid);
        Zhen zhen = this.zhenMapper.FindByZid(yonghu.getUserTownship());
        Map<String, Object> result = new HashMap();
        result.put("zhen", zhen);
        return result;
    }

    @GetMapping({"/AllDepartment"})
    public Map<String, Object> AllDepartment() {
        List<Department> departments = this.departmentMapper.querryAll();
        Map<String, Object> result = new HashMap();
        result.put("departments", departments);
        return result;
    }

    @GetMapping({"/AllBacktype"})
    public Map<String, Object> AllBacktype() {
        List<Backtype> list = this.backtypeMapper.querryAll();
        Map<String, Object> result = new HashMap();
        result.put("backtype", list);
        return result;
    }

    @GetMapping({"/Yichuli/{userid}/{startPage}/{pageSize}"})
    public Map<String, Object> Yichuli(@PathVariable("userid") Integer userid, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        Page<Feedback> yichuli = this.feedbackMapper.Yichuli(userid);
        Backtype backtype = null;
        Department department = null;
        Zhen zhen = null;
        Feedbackreply feedbackreply = null;

        for(int i = 0; i < yichuli.size(); ++i) {
            System.out.println(((Feedback)yichuli.get(i)).getfBeiyong1());
            backtype = this.backtypeMapper.FindById_lfm(((Feedback)yichuli.get(i)).getfType());
            ((Feedback)yichuli.get(i)).setBacktype(backtype);
            feedbackreply = this.feedbackreplyMapper.FindById_lfm(((Feedback)yichuli.get(i)).getFeedbackId());
            ((Feedback)yichuli.get(i)).setFeedbackreply(feedbackreply);
            System.out.println("a");
            if (((Feedback)yichuli.get(i)).getfBeiyong1().equals("0")) {
                System.out.println("1");
                department = this.departmentMapper.FindById_lfm(Integer.parseInt(((Feedback)yichuli.get(i)).getfAdmissibleunit()));
                ((Feedback)yichuli.get(i)).setDepartment(department);
            }

            if (((Feedback)yichuli.get(i)).getfBeiyong1().equals("1")) {
                System.out.println("2");
                zhen = this.zhenMapper.FindByZid(Integer.parseInt(((Feedback)yichuli.get(i)).getfAdmissibleunit()));
                ((Feedback)yichuli.get(i)).setZhen(zhen);
            }
        }

        Map<String, Object> result = new HashMap();
        result.put("record", yichuli);
        result.put("total", yichuli.getPages());
        result.put("count", yichuli.getTotal());
        result.put("nowPage", yichuli.getPageNum());
        return result;
    }

    @GetMapping({"/Weichuli/{userid}/{startPage}/{pageSize}"})
    public Map<String, Object> Weichuli(@PathVariable("userid") Integer userid, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        Page<Feedback> weichuli = this.feedbackMapper.Weichuli(userid);
        Map<String, Object> result = new HashMap();
        result.put("record", weichuli);
        result.put("total", weichuli.getPages());
        result.put("count", weichuli.getTotal());
        result.put("nowPage", weichuli.getPageNum());
        return result;
    }

    @GetMapping({"/YichuliInfo/{id}"})
    public Map<String, Object> YichuliInfo(@PathVariable("id") Integer id) {
        new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Feedback feedback = this.feedbackMapper.YichuliInfo(id);
        Map<String, Object> result = new HashMap();
        result.put("feedback", feedback);
        result.put("time", dateFormat.format(feedback.getfTime()));
        return result;
    }

    @GetMapping({"/YichuliSearch/{id}/{year}/{startPage}/{pageSize}"})
    public Map<String, Object> YichuliSearch(@PathVariable("id") Integer id, @PathVariable("year") String year, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        Page<Feedback> feedbackPage = this.feedbackMapper.YichuliSearch(id, year);
        Backtype backtype = null;
        Department department = null;
        Zhen zhen = null;
        Feedbackreply feedbackreply = null;

        for(int i = 0; i < feedbackPage.size(); ++i) {
            System.out.println(((Feedback)feedbackPage.get(i)).getfBeiyong1());
            backtype = this.backtypeMapper.FindById_lfm(((Feedback)feedbackPage.get(i)).getfType());
            ((Feedback)feedbackPage.get(i)).setBacktype(backtype);
            feedbackreply = this.feedbackreplyMapper.FindById_lfm(((Feedback)feedbackPage.get(i)).getFeedbackId());
            ((Feedback)feedbackPage.get(i)).setFeedbackreply(feedbackreply);
            System.out.println("a");
            if (((Feedback)feedbackPage.get(i)).getfBeiyong1().equals("0")) {
                System.out.println("1");
                department = this.departmentMapper.FindById_lfm(Integer.parseInt(((Feedback)feedbackPage.get(i)).getfAdmissibleunit()));
                ((Feedback)feedbackPage.get(i)).setDepartment(department);
            }

            if (((Feedback)feedbackPage.get(i)).getfBeiyong1().equals("1")) {
                System.out.println("2");
                zhen = this.zhenMapper.FindByZid(Integer.parseInt(((Feedback)feedbackPage.get(i)).getfAdmissibleunit()));
                ((Feedback)feedbackPage.get(i)).setZhen(zhen);
            }
        }

        Map<String, Object> result = new HashMap();
        result.put("record", feedbackPage);
        result.put("total", feedbackPage.getPages());
        result.put("count", feedbackPage.getTotal());
        result.put("nowPage", feedbackPage.getPageNum());
        return result;
    }

    @GetMapping({"/WeichuliSearch/{id}/{year}/{startPage}/{pageSize}"})
    public Map<String, Object> WeichuliSearch(@PathVariable("id") Integer id, @PathVariable("year") String year, @PathVariable("startPage") Integer startPage, @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        Page<Feedback> feedbackPage = this.feedbackMapper.WeichuliSearch(id, year);
        Backtype backtype = null;
        Department department = null;
        Zhen zhen = null;

        for(int i = 0; i < feedbackPage.size(); ++i) {
            System.out.println(((Feedback)feedbackPage.get(i)).getfBeiyong1());
            backtype = this.backtypeMapper.FindById_lfm(((Feedback)feedbackPage.get(i)).getfType());
            ((Feedback)feedbackPage.get(i)).setBacktype(backtype);
            System.out.println("a");
            if (((Feedback)feedbackPage.get(i)).getfBeiyong1().equals("0")) {
                System.out.println("1");
                department = this.departmentMapper.FindById_lfm(Integer.parseInt(((Feedback)feedbackPage.get(i)).getfAdmissibleunit()));
                ((Feedback)feedbackPage.get(i)).setDepartment(department);
            }

            if (((Feedback)feedbackPage.get(i)).getfBeiyong1().equals("1")) {
                System.out.println("2");
                zhen = this.zhenMapper.FindByZid(Integer.parseInt(((Feedback)feedbackPage.get(i)).getfAdmissibleunit()));
                ((Feedback)feedbackPage.get(i)).setZhen(zhen);
            }
        }

        Map<String, Object> result = new HashMap();
        result.put("record", feedbackPage);
        result.put("total", feedbackPage.getPages());
        result.put("count", feedbackPage.getTotal());
        result.put("nowPage", feedbackPage.getPageNum());
        return result;
    }

    @PostMapping({"/TijiaoFeedback"})
    public Map<String, Object> TijiaoFeedback(Feedback feedback, @RequestParam(value = "userId",required = false) Integer userId, @RequestParam(value = "photo",required = false) MultipartFile[] photo) {
        Map<String, Object> map = new HashMap();
        System.out.println(feedback.getfTitle() + "jk");
        System.out.println(userId);
        System.out.println(photo);
        if (userId != null) {
            int i = BadWordUtil2.checkBadWord(feedback.getfContent(), 0, 2);
            if (i == 0) {
                map = this.feedbackService.AddFeedback(feedback, userId, photo);
            } else {
                ((Map)map).put("statue", "存在敏感词");
            }
        } else {
            ((Map)map).put("statue", "缺少数据");
        }

        return (Map)map;
    }
}
