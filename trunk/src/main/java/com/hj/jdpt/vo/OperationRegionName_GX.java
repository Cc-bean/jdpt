package com.hj.jdpt.vo;

public class OperationRegionName_GX {
    private String VillageName;
    private String ZhenName;
    private String RegionName;

    @Override
    public String toString() {
        return "OperationRegionName_GX{" +
                "VillageName='" + VillageName + '\'' +
                ", ZhenName='" + ZhenName + '\'' +
                ", RegionName='" + RegionName + '\'' +
                '}';
    }

    public String getVillageName() {
        return VillageName;
    }

    public void setVillageName(String villageName) {
        VillageName = villageName;
    }

    public String getZhenName() {
        return ZhenName;
    }

    public void setZhenName(String zhenName) {
        ZhenName = zhenName;
    }

    public String getRegionName() {
        return RegionName;
    }

    public void setRegionName(String regionName) {
        RegionName = regionName;
    }
}
