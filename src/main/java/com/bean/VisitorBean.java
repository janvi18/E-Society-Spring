package com.bean;

public class VisitorBean {
	int visitorId, houseId, userId;
	String visitorname, arrivingtime;
	boolean isallowed;

	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	public String getVisitorname() {
		return visitorname;
	}

	public void setVisitorname(String visitorname) {
		this.visitorname = visitorname;
	}

	public String getArrivingtime() {
		return arrivingtime;
	}

	public void setArrivingtime(String arrivingtime) {
		this.arrivingtime = arrivingtime;
	}

	public boolean isIsallowed() {
		return isallowed;
	}

	public void setIsallowed(boolean isallowed) {
		this.isallowed = isallowed;
	}

}