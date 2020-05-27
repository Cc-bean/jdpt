package com.hj.jdpt.domain;

public class Villagecadres {
    private Integer villagecadresId;

    private Integer vcVillageid;

    private Integer vcPost;

    private String vcName;

    private String vcPhone;

    private String vcSex;

    private String vcEntityid;

    private String vcBeiyong1;

    private String vcBeiyong2;

    private String vcGongzi;

    private String vcZhize;

    private String vcOldimagename;

    private String vcNewimagename;

    public Integer getVillagecadresId() {
        return villagecadresId;
    }

    public void setVillagecadresId(Integer villagecadresId) {
        this.villagecadresId = villagecadresId;
    }

    public Integer getVcVillageid() {
        return vcVillageid;
    }

    public void setVcVillageid(Integer vcVillageid) {
        this.vcVillageid = vcVillageid;
    }

    public Integer getVcPost() {
        return vcPost;
    }

    public void setVcPost(Integer vcPost) {
        this.vcPost = vcPost;
    }

    public String getVcName() {
        return vcName;
    }

    public void setVcName(String vcName) {
        this.vcName = vcName == null ? null : vcName.trim();
    }

    public String getVcPhone() {
        return vcPhone;
    }

    public void setVcPhone(String vcPhone) {
        this.vcPhone = vcPhone == null ? null : vcPhone.trim();
    }

    public String getVcSex() {
        return vcSex;
    }

    public void setVcSex(String vcSex) {
        this.vcSex = vcSex == null ? null : vcSex.trim();
    }

    public String getVcEntityid() {
        return vcEntityid;
    }

    public void setVcEntityid(String vcEntityid) {
        this.vcEntityid = vcEntityid == null ? null : vcEntityid.trim();
    }

    public String getVcBeiyong1() {
        return vcBeiyong1;
    }

    public void setVcBeiyong1(String vcBeiyong1) {
        this.vcBeiyong1 = vcBeiyong1 == null ? null : vcBeiyong1.trim();
    }

    public String getVcBeiyong2() {
        return vcBeiyong2;
    }

    public void setVcBeiyong2(String vcBeiyong2) {
        this.vcBeiyong2 = vcBeiyong2 == null ? null : vcBeiyong2.trim();
    }

    public String getVcGongzi() {
        return vcGongzi;
    }

    public void setVcGongzi(String vcGongzi) {
        this.vcGongzi = vcGongzi == null ? null : vcGongzi.trim();
    }

    public String getVcZhize() {
        return vcZhize;
    }

    public void setVcZhize(String vcZhize) {
        this.vcZhize = vcZhize == null ? null : vcZhize.trim();
    }

    public String getVcOldimagename() {
        return vcOldimagename;
    }

    public void setVcOldimagename(String vcOldimagename) {
        this.vcOldimagename = vcOldimagename;
    }

    public String getVcNewimagename() {
        return vcNewimagename;
    }

    public void setVcNewimagename(String vcNewimagename) {
        this.vcNewimagename = vcNewimagename;
    }

    @Override
    public String toString() {
        return "Villagecadres{" +
                "villagecadresId=" + villagecadresId +
                ", vcVillageid=" + vcVillageid +
                ", vcPost=" + vcPost +
                ", vcName='" + vcName + '\'' +
                ", vcPhone='" + vcPhone + '\'' +
                ", vcSex='" + vcSex + '\'' +
                ", vcEntityid='" + vcEntityid + '\'' +
                ", vcBeiyong1='" + vcBeiyong1 + '\'' +
                ", vcBeiyong2='" + vcBeiyong2 + '\'' +
                ", vcGongzi='" + vcGongzi + '\'' +
                ", vcZhize='" + vcZhize + '\'' +
                ", vcOldimagename='" + vcOldimagename + '\'' +
                ", vcNewimagename='" + vcNewimagename + '\'' +
                '}';
    }
}