/**
  * Copyright 2021 bejson.com 
  */
package com.code.demo.bean;

/**
 * Auto-generated: 2021-05-30 1:13:39
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Resp<T> {

    private int ecode;
    private String msg;
    private T data;
    public void setEcode(int ecode) {
         this.ecode = ecode;
     }
     public int getEcode() {
         return ecode;
     }

    public void setMsg(String msg) {
         this.msg = msg;
     }
     public String getMsg() {
         return msg;
     }

    public void setData(T data) {
         this.data = data;
     }
     public T getData() {
         return data;
     }
	@Override
	public String toString() {
		return "Resp [ecode=" + ecode + ", msg=" + msg + ", data=" + data + "]";
	}

     
     
}