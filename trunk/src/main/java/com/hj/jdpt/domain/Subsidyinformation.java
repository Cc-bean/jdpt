package com.hj.jdpt.domain;

import java.util.Date;

public class Subsidyinformation {
    private Integer subsidyinformationId;

    private String siStandard;

    private String siReceivetime;

    private Date siOpentime;

    private Float siSubsidyamount;

    private Integer siNameofsubsidy;

    private String siBeiyong1;

    private String siBeiyong2;

    private String siPrize;

    private String siThing;

    private String siBeiyong3;

    private String siHouse;

    private String siObject;

    public Integer getSubsidyinformationId() {
        return subsidyinformationId;
    }

    public void setSubsidyinformationId(Integer subsidyinformationId) {
        this.subsidyinformationId = subsidyinformationId;
    }

    public String getSiStandard() {
        return siStandard;
    }

    public void setSiStandard(String siStandard) {
        this.siStandard = siStandard == null ? null : siStandard.trim();
    }

    public String getSiReceivetime() {
        return siReceivetime;
    }

    public void setSiReceivetime(String siReceivetime) {
        this.siReceivetime = siReceivetime == null ? null : siReceivetime.trim();
    }

    public Date getSiOpentime() {
        return siOpentime;
    }

    public void setSiOpentime(Date siOpentime) {
        this.siOpentime = siOpentime;
    }

    public Float getSiSubsidyamount() {
        return siSubsidyamount;
    }

    public void setSiSubsidyamount(Float siSubsidyamount) {
        this.siSubsidyamount = siSubsidyamount;
    }

    public Integer getSiNameofsubsidy() {
        return siNameofsubsidy;
    }

    public void setSiNameofsubsidy(Integer siNameofsubsidy) {
        this.siNameofsubsidy = siNameofsubsidy;
    }

    public String getSiBeiyong1() {
        return siBeiyong1;
    }

    public void setSiBeiyong1(String siBeiyong1) {
        this.siBeiyong1 = siBeiyong1 == null ? null : siBeiyong1.trim();
    }

    public String getSiBeiyong2() {
        return siBeiyong2;
    }

    public void setSiBeiyong2(String siBeiyong2) {
        this.siBeiyong2 = siBeiyong2 == null ? null : siBeiyong2.trim();
    }

    public String getSiPrize() {
        return siPrize;
    }

    public void setSiPrize(String siPrize) {
        this.siPrize = siPrize == null ? null : siPrize.trim();
    }

    public String getSiThing() {
        return siThing;
    }

    public void setSiThing(String siThing) {
        this.siThing = siThing == null ? null : siThing.trim();
    }

    public String getSiBeiyong3() {
        return siBeiyong3;
    }

    public void setSiBeiyong3(String siBeiyong3) {
        this.siBeiyong3 = siBeiyong3 == null ? null : siBeiyong3.trim();
    }

    public String getSiHouse() {
        return siHouse;
    }

    public void setSiHouse(String siHouse) {
        this.siHouse = siHouse == null ? null : siHouse.trim();
    }

    public String getSiObject() {
        return siObject;
    }

    public void setSiObject(String siObject) {
        this.siObject = siObject == null ? null : siObject.trim();
    }
}