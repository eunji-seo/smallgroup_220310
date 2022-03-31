package com.smallgroup.meet.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Meet {
	private int id;
	private int userId;
	private String JoinName;
	private int meetFavoriteId;
	private String meetAddress;
	private String meetName;
	private String desc;
	private String meetImagePath;
	private MultipartFile file;
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
	public String getJoinName() {
		return JoinName;
	}
	public void setJoinName(String joinName) {
		JoinName = joinName;
	}
	public int getMeetFavoriteId() {
		return meetFavoriteId;
	}
	public void setMeetFavoriteId(int meetFavoriteId) {
		this.meetFavoriteId = meetFavoriteId;
	}
	public String getMeetAddress() {
		return meetAddress;
	}
	public void setMeetAddress(String meetAddress) {
		this.meetAddress = meetAddress;
	}
	public String getMeetName() {
		return meetName;
	}
	public void setMeetName(String meetName) {
		this.meetName = meetName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getMeetImagePath() {
		return meetImagePath;
	}
	public void setMeetImagePath(String meetImagePath) {
		this.meetImagePath = meetImagePath;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
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
		return "Meet [id=" + id + ", userId=" + userId + ", JoinName=" + JoinName + ", meetFavoriteId=" + meetFavoriteId
				+ ", meetAddress=" + meetAddress + ", meetName=" + meetName + ", desc=" + desc + ", meetImagePath="
				+ meetImagePath + ", file=" + file + ", personnel=" + personnel + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
	
	
	
	
	
}
