package com.bean;

public class ComplaintBean {
	int userId, houseId, complaintId;
	String date, complaint;
	boolean isresolved;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getHouseId() {
		return houseId;
	}
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	public int getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	public boolean isIsresolved() {
		return isresolved;
	}
	public void setIsresolved(boolean isresolved) {
		this.isresolved = isresolved;
	}

}