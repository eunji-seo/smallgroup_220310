package com.smallgroup.commnet.model;

import java.util.Date;

public class Comment {

	private int id;
	private int meetId;
	private int userId;
	private int meetPostId;
	private String content;
	private Date createdAt;
	private Date updatedAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMeetId() {
		return meetId;
	}
	public void setMeetId(int meetId) {
		this.meetId = meetId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMeetPostId() {
		return meetPostId;
	}
	public void setMeetPostId(int meetPostId) {
		this.meetPostId = meetPostId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
		return "Comment [id=" + id + ", meetId=" + meetId + ", userId=" + userId + ", meetPostId=" + meetPostId
				+ ", content=" + content + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
}
