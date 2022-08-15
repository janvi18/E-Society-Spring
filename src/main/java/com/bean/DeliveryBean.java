package com.bean;

public class DeliveryBean {
	int deliveryId, userId, houseId;
	String couriertype, status;
	boolean isallowed;
	public int getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}
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
	public String getCouriertype() {
		return couriertype;
	}
	public void setCouriertype(String couriertype) {
		this.couriertype = couriertype;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isIsallowed() {
		return isallowed;
	}
	public void setIsallowed(boolean isallowed) {
		this.isallowed = isallowed;
	}

	

}