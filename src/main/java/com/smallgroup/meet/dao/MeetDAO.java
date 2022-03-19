package com.smallgroup.meet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.smallgroup.user.model.Favorite;

@Repository
public interface MeetDAO {

	public List<Favorite> selectFavoriteById();
	
	public int insertMeetFavorite(
			@Param("userId") int userId, 
			@Param("favoriteId") int favoriteId);
	
}
