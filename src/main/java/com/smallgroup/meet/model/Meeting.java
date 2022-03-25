package com.smallgroup.meet.model;

import java.util.Date;

public class Meeting {

	private int id;
	private int userId;
	private int meetId;
	private String meetingName;
	private String meetingDay;
	private String Place;
	private String Cost;
	private int Personnel;
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
		return Place;
	}
	public void setPlace(String place) {
		Place = place;
	}
	public String getCost() {
		return Cost;
	}
	public void setCost(String cost) {
		Cost = cost;
	}
	public int getPersonnel() {
		return Personnel;
	}
	public void setPersonnel(int personnel) {
		Personnel = personnel;
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
				+ ", meetingDay=" + meetingDay + ", Place=" + Place + ", Cost=" + Cost + ", Personnel=" + Personnel
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	


	
}
