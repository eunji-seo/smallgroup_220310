package com.smallgroup.meet.model;

import java.util.Date;

public class Meeting {

	private int id;
	private int userId;
	private int meetId;
	private String meetingName;
	private String meetingDay;
	private String place;
	private String cost;
	private int personnel;
	private Date createdAt;
	private Date updatedAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMeetId() {
		return meetId;
	}
	public void setMeetId(int meetId) {
		this.meetId = meetId;
	}
	public String getMeetingName() {
		return meetingName;
	}
	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}
	public String getMeetingDay() {
		return meetingDay;
	}
	public void setMeetingDay(String meetingDay) {
		this.meetingDay = meetingDay;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public int getPersonnel() {
		return personnel;
	}
	public void setPersonnel(int personnel) {
		this.personnel = personnel;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "Meeting [id=" + id + ", userId=" + userId + ", meetId=" + meetId + ", meetingName=" + meetingName
				+ ", meetingDay=" + meetingDay + ", place=" + place + ", cost=" + cost + ", personnel=" + personnel
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	


	
}
