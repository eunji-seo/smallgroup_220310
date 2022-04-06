package com.smallgroup.main.model;

import java.util.List;

import com.smallgroup.user.model.UserFavorite;

public class FavoriteDto {

	private int id;
	private String favoriteName;
	private List<UserFavorite> UserfavoriteItems;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFavoriteName() {
		return favoriteName;
	}
	public void setFavoriteName(String favoriteName) {
		this.favoriteName = favoriteName;
	}
	public List<UserFavorite> getUserfavoriteItems() {
		return UserfavoriteItems;
	}
	public void setUserfavoriteItems(List<UserFavorite> userfavoriteItems) {
		UserfavoriteItems = userfavoriteItems;
	}
	
	
}
