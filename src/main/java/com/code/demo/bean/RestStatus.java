/**
  * Copyright 2021 bejson.com 
  */
package com.code.demo.bean;

import java.util.Date;

/**
 * Auto-generated: 2021-05-31 0:30:27
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class RestStatus {

	private String depaId;
	private String restDate;
	private int restSurplus;

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

	public void setRestSurplus(int restSurplus) {
		this.restSurplus = restSurplus;
	}

	public int getRestSurplus() {
		return restSurplus;
	}

	@Override
	public String toString() {
		return "RestStatus [depaId=" + depaId + ", restDate=" + restDate + ", restSurplus=" + restSurplus + "]";
	}

	
	
}