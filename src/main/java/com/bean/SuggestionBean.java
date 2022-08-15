package com.bean;

public class SuggestionBean {
	int suggestionid, userid, houseid;
	String membername, date, suggestion, reason, acknowledgement;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getHouseid() {
		return houseid;
	}

	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}

	public int getSuggestionid() {
		return suggestionid;
	}

	public void setSuggestionid(int suggestionid) {
		this.suggestionid = suggestionid;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAcknowledgement() {
		return acknowledgement;
	}

	public void setAcknowledgement(String acknowledgement) {
		this.acknowledgement = acknowledgement;
	}

}