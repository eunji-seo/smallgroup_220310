package com.smallgroup.like.model;

import java.util.Date;

public class Like {

	private int userId;
	private int meetId;
	private int meetPostId;
	private Date createdAt;
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
	public int getMeetPostId() {
		return meetPostId;
	}
	public void setMeetPostId(int meetPostId) {
		this.meetPostId = meetPostId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Like [userId=" + userId + ", meetId=" + meetId + ", meetPostId=" + meetPostId + ", createdAt="
				+ createdAt + "]";
	}
	
	
}
