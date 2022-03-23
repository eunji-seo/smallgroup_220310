package com.smallgroup.meet.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smallgroup.meet.model.Meet;
import com.smallgroup.meet.model.MeetFavorite;
import com.smallgroup.user.model.Favorite;

@Repository
public interface MeetDAO {

	public List<Favorite> selectFavoriteById();
	
	public int insertMeetFavorite(
			@Param("userId") int userId, 
			@Param("favoriteId") int favoriteId,
			@Param("favoriteName") String favoriteName);
	
	
	public MeetFavorite selectMeetFavorite();
	
	public int insertMeet(Meet meet);
	
	public Meet selectMeetById();
	
	public List<Meet> selectMeetList();
	
	public int insertJoin(
			@Param("meetId") int meetId, 
			@Param("userId") int userId, 
			@Param("leader") String leader, 
			@Param("joinName") String joinName);
}
