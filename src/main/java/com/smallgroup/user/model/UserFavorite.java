package com.smallgroup.user.model;

import java.util.Date;

public class UserFavorite {

	private int id;
	private int favoriteId;
	private Date createdAt;
	private Date updatedAt;
	private int userId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "UserFavorite [id=" + id + ", favoriteId=" + favoriteId + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", userId=" + userId + "]";
	}
	
	
}
