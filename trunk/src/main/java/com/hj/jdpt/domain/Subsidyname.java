package com.hj.jdpt.domain;

public class Subsidyname {
    private Integer sKey;

    private String sName;

    private Integer sType;

    private Integer sUp;

    private Integer sDown;

    private String sBeiyong1;

    private String sBeiyong2;

    private String sBeiyong3;

    private Subsidytype subsidytype;

    private  Subsidyinformation subsidyinformation;

    public Integer getsKey() {
        return sKey;
    }

    public void setsKey(Integer sKey) {
        this.sKey = sKey;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public Integer getsType() {
        return sType;
    }

    public void setsType(Integer sType) {
        this.sType = sType;
    }

    public Integer getsUp() {
        return sUp;
    }

    public void setsUp(Integer sUp) {
        this.sUp = sUp;
    }

    public Integer getsDown() {
        return sDown;
    }

    public void setsDown(Integer sDown) {
        this.sDown = sDown;
    }

    public String getsBeiyong1() {
        return sBeiyong1;
    }

    public void setsBeiyong1(String sBeiyong1) {
        this.sBeiyong1 = sBeiyong1 == null ? null : sBeiyong1.trim();
    }

    public String getsBeiyong2() {
        return sBeiyong2;
    }

    public void setsBeiyong2(String sBeiyong2) {
        this.sBeiyong2 = sBeiyong2 == null ? null : sBeiyong2.trim();
    }

    public String getsBeiyong3() {
        return sBeiyong3;
    }

    public void setsBeiyong3(String sBeiyong3) {
        this.sBeiyong3 = sBeiyong3 == null ? null : sBeiyong3.trim();
    }

    public Subsidytype getSubsidytype() {
        return subsidytype;
    }

    public void setSubsidytype(Subsidytype subsidytype) {
        this.subsidytype = subsidytype;
    }

    public Subsidyinformation getSubsidyinformation() {
        return subsidyinformation;
    }

    public void setSubsidyinformation(Subsidyinformation subsidyinformation) {
        this.subsidyinformation = subsidyinformation;
    }
}