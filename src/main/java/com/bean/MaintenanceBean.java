package com.bean;

public class MaintenanceBean {
	int maintenanceid, maintenanceamt, houseid;
	String creationdate, month, paymentdate, lastdate, penalty;
	boolean maintancepaid;

	public int getHouseid() {
		return houseid;
	}

	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}

	public int getMaintenanceid() {
		return maintenanceid;
	}

	public void setMaintenanceid(int maintenanceid) {
		this.maintenanceid = maintenanceid;
	}

	public int getMaintenanceamt() {
		return maintenanceamt;
	}

	public void setMaintenanceamt(int maintenanceamt) {
		this.maintenanceamt = maintenanceamt;
	}

	public String getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(String paymentdate) {
		this.paymentdate = paymentdate;
	}

	public String getLastdate() {
		return lastdate;
	}

	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}

	public String getPenalty() {
		return penalty;
	}

	public void setPenalty(String penalty) {
		this.penalty = penalty;
	}

	public boolean isMaintancepaid() {
		return maintancepaid;
	}

	public void setMaintancepaid(boolean maintancepaid) {
		this.maintancepaid = maintancepaid;
	}

}