/**
  * Copyright 2021 bejson.com 
  */
package com.code.demo.bean;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Auto-generated: 2021-05-30 1:13:39
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class List {

    private String depaId;
    private String outpName;
    private String areaId;
    private String areaName;
    private String outpAddress;
    private String outpPhone;
    private String corpName;
    private int outpWorkMode;
    private String outpCreatedTime;
    private String outpUpdatedTime;
    private int outpUse;
    private String depaCode;
    private Date outpStockcreatedDate;
    private int outPreDay;
    private int outHolidaySkip;
    private String outpDay;
    private int nums;
    private int status;
    private int outLarge;
    private int stock;
    private int orderNumber;
    @SerializedName("corpCode")
    private String corpCode;
    private int vcinUse;
    private String outpServiceTime;
    private String outpNoticeContent;

    public void setDepaId(String depaId) {
         this.depaId = depaId;
     }
     public String getDepaId() {
         return depaId;
     }

    public void setOutpName(String outpName) {
         this.outpName = outpName;
     }
     public String getOutpName() {
         return outpName;
     }

    public void setAreaId(String areaId) {
         this.areaId = areaId;
     }
     public String getAreaId() {
         return areaId;
     }

    public void setAreaName(String areaName) {
         this.areaName = areaName;
     }
     public String getAreaName() {
         return areaName;
     }

    public void setOutpAddress(String outpAddress) {
         this.outpAddress = outpAddress;
     }
     public String getOutpAddress() {
         return outpAddress;
     }

    public void setOutpPhone(String outpPhone) {
         this.outpPhone = outpPhone;
     }
     public String getOutpPhone() {
         return outpPhone;
     }

    public void setOutpWorkMode(int outpWorkMode) {
         this.outpWorkMode = outpWorkMode;
     }
     public int getOutpWorkMode() {
         return outpWorkMode;
     }

    public void setOutpCreatedTime(String outpCreatedTime) {
         this.outpCreatedTime = outpCreatedTime;
     }
     public String getOutpCreatedTime() {
         return outpCreatedTime;
     }

    public void setOutpUpdatedTime(String outpUpdatedTime) {
         this.outpUpdatedTime = outpUpdatedTime;
     }
     public String getOutpUpdatedTime() {
         return outpUpdatedTime;
     }

    public void setOutpUse(int outpUse) {
         this.outpUse = outpUse;
     }
     public int getOutpUse() {
         return outpUse;
     }

    public void setDepaCode(String depaCode) {
         this.depaCode = depaCode;
     }
     public String getDepaCode() {
         return depaCode;
     }

    public void setOutpStockcreatedDate(Date outpStockcreatedDate) {
         this.outpStockcreatedDate = outpStockcreatedDate;
     }
     public Date getOutpStockcreatedDate() {
         return outpStockcreatedDate;
     }

    public void setOutPreDay(int outPreDay) {
         this.outPreDay = outPreDay;
     }
     public int getOutPreDay() {
         return outPreDay;
     }

    public void setOutHolidaySkip(int outHolidaySkip) {
         this.outHolidaySkip = outHolidaySkip;
     }
     public int getOutHolidaySkip() {
         return outHolidaySkip;
     }

    public void setOutpDay(String outpDay) {
         this.outpDay = outpDay;
     }
     public String getOutpDay() {
         return outpDay;
     }

    public void setNums(int nums) {
         this.nums = nums;
     }
     public int getNums() {
         return nums;
     }

    public void setStatus(int status) {
         this.status = status;
     }
     public int getStatus() {
         return status;
     }

    public void setOutLarge(int outLarge) {
         this.outLarge = outLarge;
     }
     public int getOutLarge() {
         return outLarge;
     }

    public void setStock(int stock) {
         this.stock = stock;
     }
     public int getStock() {
         return stock;
     }

    public void setOrderNumber(int orderNumber) {
         this.orderNumber = orderNumber;
     }
     public int getOrderNumber() {
         return orderNumber;
     }
     
     
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode;
    }

    public int getVcinUse() {
        return vcinUse;
    }

    public void setVcinUse(int vcinUse) {
        this.vcinUse = vcinUse;
    }

    public String getOutpServiceTime() {
        return outpServiceTime;
    }

    public void setOutpServiceTime(String outpServiceTime) {
        this.outpServiceTime = outpServiceTime;
    }

    public String getOutpNoticeContent() {
        return outpNoticeContent;
    }

    public void setOutpNoticeContent(String outpNoticeContent) {
        this.outpNoticeContent = outpNoticeContent;
    }

    @Override
    public String toString() {
        return "List{" +
                "depaId='" + depaId + '\'' +
                ", outpName='" + outpName + '\'' +
                ", areaId='" + areaId + '\'' +
                ", areaName='" + areaName + '\'' +
                ", outpAddress='" + outpAddress + '\'' +
                ", outpPhone='" + outpPhone + '\'' +
                ", corpName='" + corpName + '\'' +
                ", outpWorkMode=" + outpWorkMode +
                ", outpCreatedTime='" + outpCreatedTime + '\'' +
                ", outpUpdatedTime='" + outpUpdatedTime + '\'' +
                ", outpUse=" + outpUse +
                ", depaCode='" + depaCode + '\'' +
                ", outpStockcreatedDate=" + outpStockcreatedDate +
                ", outPreDay=" + outPreDay +
                ", outHolidaySkip=" + outHolidaySkip +
                ", outpDay='" + outpDay + '\'' +
                ", nums=" + nums +
                ", status=" + status +
                ", outLarge=" + outLarge +
                ", stock=" + stock +
                ", orderNumber=" + orderNumber +
                ", corpCode='" + corpCode + '\'' +
                ", vcinUse=" + vcinUse +
                ", outpServiceTime='" + outpServiceTime + '\'' +
                ", outpNoticeContent='" + outpNoticeContent + '\'' +
                '}';
    }
}