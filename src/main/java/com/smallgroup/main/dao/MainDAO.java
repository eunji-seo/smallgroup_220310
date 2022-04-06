package com.smallgroup.main.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.smallgroup.main.model.FavoriteDto;
import com.smallgroup.user.model.User;
import com.smallgroup.user.model.UserFavorite;
@Repository
public interface MainDAO {

	public User selectMemberCreateById(String loginId);
	
	public int memberUpdate(User user);
	
	public List<FavoriteDto> getCategoryList();
	
	public List<UserFavorite> getCategoryItemList();

	

	
}
