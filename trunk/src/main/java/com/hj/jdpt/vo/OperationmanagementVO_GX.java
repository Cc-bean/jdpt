package com.hj.jdpt.vo;

public class OperationmanagementVO_GX {
    private String OperationManagement_Id;
    private String OM_Name;//项目名称x

    private String OM_TenderingMaterial;//项目编号x

    private String OM_ImplementingParty;//实施方x

    private String OM_SourceOfFunds;//是否立项x

    private String OM_ImplementThePlan;//是否招标X

    private String OM_Acceptanceparty;//验收方x

    private String OM_FollowUpManagement;//监理方x

    private String OM_DivisionOfResponsibility;//工程支付情况x

    private String OM_Type;//备注x

    private OperationRegionName_GX names;//区，镇

    public String getOperationManagement_Id() {
        return OperationManagement_Id;
    }

    public void setOperationManagement_Id(String operationManagement_Id) {
        OperationManagement_Id = operationManagement_Id;
    }

    public String getOM_Name() {
        return OM_Name;
    }

    public void setOM_Name(String OM_Name) {
        this.OM_Name = OM_Name;
    }

    public String getOM_TenderingMaterial() {
        return OM_TenderingMaterial;
    }

    public void setOM_TenderingMaterial(String OM_TenderingMaterial) {
        this.OM_TenderingMaterial = OM_TenderingMaterial;
    }

    public String getOM_ImplementingParty() {
        return OM_ImplementingParty;
    }

    public void setOM_ImplementingParty(String OM_ImplementingParty) {
        this.OM_ImplementingParty = OM_ImplementingParty;
    }

    public String getOM_SourceOfFunds() {
        return OM_SourceOfFunds;
    }

    public void setOM_SourceOfFunds(String OM_SourceOfFunds) {
        this.OM_SourceOfFunds = OM_SourceOfFunds;
    }

    public String getOM_ImplementThePlan() {
        return OM_ImplementThePlan;
    }

    public void setOM_ImplementThePlan(String OM_ImplementThePlan) {
        this.OM_ImplementThePlan = OM_ImplementThePlan;
    }

    public String getOM_Acceptanceparty() {
        return OM_Acceptanceparty;
    }

    public void setOM_Acceptanceparty(String OM_Acceptanceparty) {
        this.OM_Acceptanceparty = OM_Acceptanceparty;
    }

    public String getOM_FollowUpManagement() {
        return OM_FollowUpManagement;
    }

    public void setOM_FollowUpManagement(String OM_FollowUpManagement) {
        this.OM_FollowUpManagement = OM_FollowUpManagement;
    }

    public String getOM_DivisionOfResponsibility() {
        return OM_DivisionOfResponsibility;
    }

    public void setOM_DivisionOfResponsibility(String OM_DivisionOfResponsibility) {
        this.OM_DivisionOfResponsibility = OM_DivisionOfResponsibility;
    }

    public String getOM_Type() {
        return OM_Type;
    }

    public void setOM_Type(String OM_Type) {
        this.OM_Type = OM_Type;
    }

    public OperationRegionName_GX getNames() {
        return names;
    }

    public void setNames(OperationRegionName_GX names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "OperationmanagementVO_GX{" +
                "OperationManagement_Id='" + OperationManagement_Id + '\'' +
                ", OM_Name='" + OM_Name + '\'' +
                ", OM_TenderingMaterial='" + OM_TenderingMaterial + '\'' +
                ", OM_ImplementingParty='" + OM_ImplementingParty + '\'' +
                ", OM_SourceOfFunds='" + OM_SourceOfFunds + '\'' +
                ", OM_ImplementThePlan='" + OM_ImplementThePlan + '\'' +
                ", OM_Acceptanceparty='" + OM_Acceptanceparty + '\'' +
                ", OM_FollowUpManagement='" + OM_FollowUpManagement + '\'' +
                ", OM_DivisionOfResponsibility='" + OM_DivisionOfResponsibility + '\'' +
                ", OM_Type='" + OM_Type + '\'' +
                ", names=" + names +
                '}';
    }
}
