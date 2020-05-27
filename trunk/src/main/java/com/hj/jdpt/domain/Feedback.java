//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.domain;

import java.util.Date;

public class Feedback {
    private Integer feedbackId;
    private Integer fType;
    private String fAdmissibleunit;
    private String fTitle;
    private String fContent;
    private String fImagepath;
    private Integer fPeopleid;
    private Date fTime;
    private Boolean fHandle;
    private String fAdmissiblecontent;
    private String fBeiyong1;
    private String fBeiyong2;
    private Boolean fJudge;
    private Backtype backtype;
    private Department department;
    private Zhen zhen;
    private Feedbackreply feedbackreply;

    public Feedback() {
    }

    public Integer getFeedbackId() {
        return this.feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Integer getfType() {
        return this.fType;
    }

    public void setfType(Integer fType) {
        this.fType = fType;
    }

    public String getfAdmissibleunit() {
        return this.fAdmissibleunit;
    }

    public void setfAdmissibleunit(String fAdmissibleunit) {
        this.fAdmissibleunit = fAdmissibleunit == null ? null : fAdmissibleunit.trim();
    }

    public String getfTitle() {
        return this.fTitle;
    }

    public void setfTitle(String fTitle) {
        this.fTitle = fTitle == null ? null : fTitle.trim();
    }

    public String getfContent() {
        return this.fContent;
    }

    public void setfContent(String fContent) {
        this.fContent = fContent == null ? null : fContent.trim();
    }

    public String getfImagepath() {
        return this.fImagepath;
    }

    public void setfImagepath(String fImagepath) {
        this.fImagepath = fImagepath == null ? null : fImagepath.trim();
    }

    public Integer getfPeopleid() {
        return this.fPeopleid;
    }

    public void setfPeopleid(Integer fPeopleid) {
        this.fPeopleid = fPeopleid;
    }

    public Date getfTime() {
        return this.fTime;
    }

    public void setfTime(Date fTime) {
        this.fTime = fTime;
    }

    public Boolean getfHandle() {
        return this.fHandle;
    }

    public void setfHandle(Boolean fHandle) {
        this.fHandle = fHandle;
    }

    public String getfAdmissiblecontent() {
        return this.fAdmissiblecontent;
    }

    public void setfAdmissiblecontent(String fAdmissiblecontent) {
        this.fAdmissiblecontent = fAdmissiblecontent == null ? null : fAdmissiblecontent.trim();
    }

    public String getfBeiyong1() {
        return this.fBeiyong1;
    }

    public void setfBeiyong1(String fBeiyong1) {
        this.fBeiyong1 = fBeiyong1 == null ? null : fBeiyong1.trim();
    }

    public String getfBeiyong2() {
        return this.fBeiyong2;
    }

    public void setfBeiyong2(String fBeiyong2) {
        this.fBeiyong2 = fBeiyong2 == null ? null : fBeiyong2.trim();
    }

    public Boolean getfJudge() {
        return this.fJudge;
    }

    public void setfJudge(Boolean fJudge) {
        this.fJudge = fJudge;
    }

    public Backtype getBacktype() {
        return this.backtype;
    }

    public void setBacktype(Backtype backtype) {
        this.backtype = backtype;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Zhen getZhen() {
        return this.zhen;
    }

    public void setZhen(Zhen zhen) {
        this.zhen = zhen;
    }

    public Feedbackreply getFeedbackreply() {
        return this.feedbackreply;
    }

    public void setFeedbackreply(Feedbackreply feedbackreply) {
        this.feedbackreply = feedbackreply;
    }

    public String toString() {
        return "Feedback{feedbackId=" + this.feedbackId + ", fType=" + this.fType + ", fAdmissibleunit='" + this.fAdmissibleunit + '\'' + ", fTitle='" + this.fTitle + '\'' + ", fContent='" + this.fContent + '\'' + ", fImagepath='" + this.fImagepath + '\'' + ", fPeopleid=" + this.fPeopleid + ", fTime=" + this.fTime + ", fHandle=" + this.fHandle + ", fAdmissiblecontent='" + this.fAdmissiblecontent + '\'' + ", fBeiyong1='" + this.fBeiyong1 + '\'' + ", fBeiyong2='" + this.fBeiyong2 + '\'' + ", fJudge=" + this.fJudge + '}';
    }
}
