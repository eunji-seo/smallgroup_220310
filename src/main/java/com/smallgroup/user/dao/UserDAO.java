package com.smallgroup.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.smallgroup.user.model.Favorite;
import com.smallgroup.user.model.User;
import com.smallgroup.user.model.UserFavorite;

@Repository
public interface UserDAO {
	
	public boolean selectDuplicatedId(String loginId); 
	
	public int insertJoin(User user);
	
	public User selectLoginIdAndPassword(
			@Param("loginId") String loginId, 
			@Param("password") String password); 
	
	
	public List<Favorite> selectFavoriteById();
	
	public int insertUserFavorite(
			@Param("userId") int userId, 
			@Param("favoriteId") int favoriteId);
	
	public void deleteUserFavorite(int userId);
	
	public List<Favorite> selectUserFavorites(@Param("userId") int userId);
}
