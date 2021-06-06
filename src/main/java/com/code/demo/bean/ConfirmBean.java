package com.code.demo.bean;

public class ConfirmBean {

    /**
     * reusId : 603949343172116481
     * depaId : 2AA5C070-2605-B96B-E23B-85EAEE45DE8A
     * corpCode : 36
     * date : 2021-06-01
     * ouatId : 774
     * vaccCodes : 5601
     */

    private String reusId;
    private String depaId;
    private String corpCode;
    private String date;
    private String ouatId;
    private String vaccCodes;

    public String getReusId() {
        return reusId;
    }

    public void setReusId(String reusId) {
        this.reusId = reusId;
    }

    public String getDepaId() {
        return depaId;
    }

    public void setDepaId(String depaId) {
        this.depaId = depaId;
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOuatId() {
        return ouatId;
    }

    public void setOuatId(String ouatId) {
        this.ouatId = ouatId;
    }

    public String getVaccCodes() {
        return vaccCodes;
    }

    public void setVaccCodes(String vaccCodes) {
        this.vaccCodes = vaccCodes;
    }

    @Override
    public String toString() {
        return "ConfirmBean{" +
                "reusId='" + reusId + '\'' +
                ", depaId='" + depaId + '\'' +
                ", corpCode='" + corpCode + '\'' +
                ", date='" + date + '\'' +
                ", ouatId='" + ouatId + '\'' +
                ", vaccCodes='" + vaccCodes + '\'' +
                '}';
    }
}
