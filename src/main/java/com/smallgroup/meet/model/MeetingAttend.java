package com.smallgroup.meet.model;

import java.util.Date;

public class MeetingAttend {
    
    private int id;
    private int userId;
    private int meetId;
    private int meetingId;
    private String attendName;
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
	public int getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}
	public String getAttendName() {
		return attendName;
	}
	public void setAttendName(String attendName) {
		this.attendName = attendName;
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
		return "MeetingAttend [id=" + id + ", userId=" + userId + ", meetId=" + meetId + ", meetingId=" + meetingId
				+ ", attendName=" + attendName + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
    
    
}
