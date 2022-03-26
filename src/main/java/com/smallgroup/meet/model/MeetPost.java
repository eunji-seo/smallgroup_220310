package com.smallgroup.meet.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class MeetPost {
	
	private int id;
	private int userId;
	private int meetId;
	private String subject;
	private String contentText;
	private String postImagePath;
	private MultipartFile postImage;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContentText() {
		return contentText;
	}
	public void setContentText(String contentText) {
		this.contentText = contentText;
	}
	public String getPostImagePath() {
		return postImagePath;
	}
	public void setPostImagePath(String postImagePath) {
		this.postImagePath = postImagePath;
	}
	public MultipartFile getPostImage() {
		return postImage;
	}
	public void setPostImage(MultipartFile postImage) {
		this.postImage = postImage;
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
		return "MeetPost [id=" + id + ", userId=" + userId + ", meetId=" + meetId + ", subject=" + subject
				+ ", contentText=" + contentText + ", postImagePath=" + postImagePath + ", postImage=" + postImage
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	
}
