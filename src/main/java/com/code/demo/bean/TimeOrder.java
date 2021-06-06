/**
  * Copyright 2021 bejson.com 
  */
package com.code.demo.bean;
import java.util.Date;

/**
 * Auto-generated: 2021-05-31 1:3:21
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class TimeOrder {

    private String restId;
    private String depaId;
    private String restDate;
    private String ouatId;
    private int restSum;
    private int restSurplus;
    private String ouatBeginTime;
    private String ouatEndTime;
    public void setRestId(String restId) {
         this.restId = restId;
     }
     public String getRestId() {
         return restId;
     }

    public void setDepaId(String depaId) {
         this.depaId = depaId;
     }
     public String getDepaId() {
         return depaId;
     }

    public void setRestDate(String restDate) {
         this.restDate = restDate;
     }
     public String getRestDate() {
         return restDate;
     }

    public void setOuatId(String ouatId) {
         this.ouatId = ouatId;
     }
     public String getOuatId() {
         return ouatId;
     }

    public void setRestSum(int restSum) {
         this.restSum = restSum;
     }
     public int getRestSum() {
         return restSum;
     }

    public void setRestSurplus(int restSurplus) {
         this.restSurplus = restSurplus;
     }
     public int getRestSurplus() {
         return restSurplus;
     }

    public void setOuatBeginTime(String ouatBeginTime) {
         this.ouatBeginTime = ouatBeginTime;
     }
     public String getOuatBeginTime() {
         return ouatBeginTime;
     }

    public void setOuatEndTime(String ouatEndTime) {
         this.ouatEndTime = ouatEndTime;
     }
     public String getOuatEndTime() {
         return ouatEndTime;
     }

    @Override
    public String toString() {
        return "TimeOrder{" +
                "restId='" + restId + '\'' +
                ", depaId='" + depaId + '\'' +
                ", restDate='" + restDate + '\'' +
                ", ouatId='" + ouatId + '\'' +
                ", restSum=" + restSum +
                ", restSurplus=" + restSurplus +
                ", ouatBeginTime='" + ouatBeginTime + '\'' +
                ", ouatEndTime='" + ouatEndTime + '\'' +
                '}';
    }
}