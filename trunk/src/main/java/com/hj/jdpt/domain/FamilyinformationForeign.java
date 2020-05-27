package com.hj.jdpt.domain;

public class FamilyinformationForeign extends Familyinformation{
    private Nation nation;

    private Policystatu policystatu;

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public Policystatu getPolicystatu() {
        return policystatu;
    }

    public void setPolicystatu(Policystatu policystatu) {
        this.policystatu = policystatu;
    }
}
