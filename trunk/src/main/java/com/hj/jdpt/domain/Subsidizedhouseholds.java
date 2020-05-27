package com.hj.jdpt.domain;

public class Subsidizedhouseholds {
    private Integer subsidizedhouseholdsId;

    private String shName;

    private String shAddress;

    private String shEnjoythesubsidy;

    private String shFamilyinformation;

    private Integer shVillageid;

    private String shBeiyong1;

    private String shBeiyong2;

    private String shBeiyong3;

    private Integer shHu;

    private Subsidyinformation subsidyinformation;

    private Subsidyname subsidyname;

    public Integer getSubsidizedhouseholdsId() {
        return subsidizedhouseholdsId;
    }

    public void setSubsidizedhouseholdsId(Integer subsidizedhouseholdsId) {
        this.subsidizedhouseholdsId = subsidizedhouseholdsId;
    }

    public String getShName() {
        return shName;
    }

    public void setShName(String shName) {
        this.shName = shName == null ? null : shName.trim();
    }

    public String getShAddress() {
        return shAddress;
    }

    public void setShAddress(String shAddress) {
        this.shAddress = shAddress == null ? null : shAddress.trim();
    }

    public String getShEnjoythesubsidy() {
        return shEnjoythesubsidy;
    }

    public void setShEnjoythesubsidy(String shEnjoythesubsidy) {
        this.shEnjoythesubsidy = shEnjoythesubsidy == null ? null : shEnjoythesubsidy.trim();
    }

    public String getShFamilyinformation() {
        return shFamilyinformation;
    }

    public void setShFamilyinformation(String shFamilyinformation) {
        this.shFamilyinformation = shFamilyinformation == null ? null : shFamilyinformation.trim();
    }

    public Integer getShVillageid() {
        return shVillageid;
    }

    public void setShVillageid(Integer shVillageid) {
        this.shVillageid = shVillageid;
    }

    public String getShBeiyong1() {
        return shBeiyong1;
    }

    public void setShBeiyong1(String shBeiyong1) {
        this.shBeiyong1 = shBeiyong1 == null ? null : shBeiyong1.trim();
    }

    public String getShBeiyong2() {
        return shBeiyong2;
    }

    public void setShBeiyong2(String shBeiyong2) {
        this.shBeiyong2 = shBeiyong2 == null ? null : shBeiyong2.trim();
    }

    public String getShBeiyong3() {
        return shBeiyong3;
    }

    public void setShBeiyong3(String shBeiyong3) {
        this.shBeiyong3 = shBeiyong3 == null ? null : shBeiyong3.trim();
    }

    public Integer getShHu() {
        return shHu;
    }

    public void setShHu(Integer shHu) {
        this.shHu = shHu;
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