package com.hj.jdpt.domain;

public class Subsidyobject {
    private Integer subsidyobjectId;

    private Integer soSubsidyid;

    private String soName;

    private String soEnjoythesubsidy;

    private String soBeiyong1;

    private String soBeiyong2;

    private String soBeiyong3;

    private String soBeiyong4;

    private String soBeiyong5;

    private Integer soYonghu;

    private Integer soVillageid;

    private String soShenfenzheng;

    private Subsidyinformation subsidyinformation;

    private Subsidyname subsidyname;

    public Integer getSubsidyobjectId() {
        return subsidyobjectId;
    }

    public void setSubsidyobjectId(Integer subsidyobjectId) {
        this.subsidyobjectId = subsidyobjectId;
    }

    public Integer getSoSubsidyid() {
        return soSubsidyid;
    }

    public void setSoSubsidyid(Integer soSubsidyid) {
        this.soSubsidyid = soSubsidyid;
    }

    public String getSoName() {
        return soName;
    }

    public void setSoName(String soName) {
        this.soName = soName == null ? null : soName.trim();
    }

    public String getSoEnjoythesubsidy() {
        return soEnjoythesubsidy;
    }

    public void setSoEnjoythesubsidy(String soEnjoythesubsidy) {
        this.soEnjoythesubsidy = soEnjoythesubsidy == null ? null : soEnjoythesubsidy.trim();
    }

    public String getSoBeiyong1() {
        return soBeiyong1;
    }

    public void setSoBeiyong1(String soBeiyong1) {
        this.soBeiyong1 = soBeiyong1 == null ? null : soBeiyong1.trim();
    }

    public String getSoBeiyong2() {
        return soBeiyong2;
    }

    public void setSoBeiyong2(String soBeiyong2) {
        this.soBeiyong2 = soBeiyong2 == null ? null : soBeiyong2.trim();
    }

    public String getSoBeiyong3() {
        return soBeiyong3;
    }

    public void setSoBeiyong3(String soBeiyong3) {
        this.soBeiyong3 = soBeiyong3 == null ? null : soBeiyong3.trim();
    }

    public String getSoBeiyong4() {
        return soBeiyong4;
    }

    public void setSoBeiyong4(String soBeiyong4) {
        this.soBeiyong4 = soBeiyong4 == null ? null : soBeiyong4.trim();
    }

    public String getSoBeiyong5() {
        return soBeiyong5;
    }

    public void setSoBeiyong5(String soBeiyong5) {
        this.soBeiyong5 = soBeiyong5 == null ? null : soBeiyong5.trim();
    }

    public Integer getSoYonghu() {
        return soYonghu;
    }

    public void setSoYonghu(Integer soYonghu) {
        this.soYonghu = soYonghu;
    }

    public Integer getSoVillageid() {
        return soVillageid;
    }

    public void setSoVillageid(Integer soVillageid) {
        this.soVillageid = soVillageid;
    }

    public String getSoShenfenzheng() {
        return soShenfenzheng;
    }

    public void setSoShenfenzheng(String soShenfenzheng) {
        this.soShenfenzheng = soShenfenzheng == null ? null : soShenfenzheng.trim();
    }

    public Subsidyinformation getSubsidyinformation() {
        return subsidyinformation;
    }

    public void setSubsidyinformation(Subsidyinformation subsidyinformation) {
        this.subsidyinformation = subsidyinformation;
    }

    public Subsidyname getSubsidyname() {
        return subsidyname;
    }

    public void setSubsidyname(Subsidyname subsidyname) {
        this.subsidyname = subsidyname;
    }
}