package com.smallgroup.meet.model;

import java.util.Date;

public class MeetJoin {

	private int id;
	private int userId;
	private int meetId;
	private String JoinName;
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
	public String getJoinName() {
		return JoinName;
	}
	public void setJoinName(String joinName) {
		JoinName = joinName;
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
		return "MeetJoin [id=" + id + ", userId=" + userId + ", meetId=" + meetId + ", JoinName=" + JoinName
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
}
