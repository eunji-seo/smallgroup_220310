package com.smallgroup.meet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.smallgroup.meet.model.Meet;
import com.smallgroup.meet.model.Meeting;
import com.smallgroup.user.model.Favorite;

@Repository
public interface MeetDAO {

	public List<Favorite> selectFavoriteById();
	
	public int insertMeetFavorite(
			@Param("userId") int userId,  
			@Param("favoriteId") int favoriteId); 
	
	
	public int insertMeet(Meet meet);
	
	public Meet selectMeetById(int meetId);

//	public Meet selectMeetId();
	
	public List<Meet> selectMeetList();
	
	public int insertJoin(
			@Param("meetId") int meetId, 
			@Param("userId") int userId, 
			@Param("leader") String leader, 
			@Param("joinName") String joinName);
	
	public int insertMeeting(Meeting meeting);
	
	public List<Meeting> selectMeetingList();
}
