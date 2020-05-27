package com.hj.jdpt.domain;

public class Resourcetype {
    private Integer rKey;

    private String rName;

    private String rType;

    private String rBeiyong1;

    private String rBeiyong2;

    private String rBeiyong3;

    public Integer getrKey() {
        return rKey;
    }

    public void setrKey(Integer rKey) {
        this.rKey = rKey;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public String getrType() {
        return rType;
    }

    public void setrType(String rType) {
        this.rType = rType == null ? null : rType.trim();
    }

    public String getrBeiyong1() {
        return rBeiyong1;
    }

    public void setrBeiyong1(String rBeiyong1) {
        this.rBeiyong1 = rBeiyong1 == null ? null : rBeiyong1.trim();
    }

    public String getrBeiyong2() {
        return rBeiyong2;
    }

    public void setrBeiyong2(String rBeiyong2) {
        this.rBeiyong2 = rBeiyong2 == null ? null : rBeiyong2.trim();
    }

    public String getrBeiyong3() {
        return rBeiyong3;
    }

    public void setrBeiyong3(String rBeiyong3) {
        this.rBeiyong3 = rBeiyong3 == null ? null : rBeiyong3.trim();
    }

    @Override
    public String toString() {
        return "Resourcetype{" +
                "rKey=" + rKey +
                ", rName='" + rName + '\'' +
                ", rType='" + rType + '\'' +
                ", rBeiyong1='" + rBeiyong1 + '\'' +
                ", rBeiyong2='" + rBeiyong2 + '\'' +
                ", rBeiyong3='" + rBeiyong3 + '\'' +
                '}';
    }
}