package com.smallgroup.meet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.smallgroup.meet.model.Meet;
import com.smallgroup.meet.model.MeetJoin;
import com.smallgroup.meet.model.Meeting;
import com.smallgroup.meet.model.MeetingAttend;
import com.smallgroup.post.model.MeetPost;
import com.smallgroup.user.model.Favorite;
import com.smallgroup.user.model.User;

@Repository
public interface MeetDAO {

	public List<Favorite> selectFavoriteById();
	
	public int insertMeetFavorite(
			@Param("userId") int userId,  
			@Param("favoriteId") int favoriteId); 
	
	
	public int insertMeet(Meet meet);
	
	public Meet selectMeetById(int meetId);

	public List<Meet> selectMeetList(Integer meetFavoriteId);
	
	public int insertJoin(MeetJoin meetJoin);
	
	public int insertAttend(MeetingAttend meetingAttend);
	
	public User getRederName(int meetId);
	
	public List<MeetJoin> getJoinName(int meetId);
	
	public int getJoinNameByName(@Param("meetId")int meetId, @Param("userId")int userId);
	
	public int insertMeeting(Meeting meeting);
	
	public List<Meeting> selectMeetingList(int meetId);
	
	public Meeting selectMeeting (
			@Param("id") int meetingId, 
			@Param("meetId") int meetId);
	
	public List<MeetingAttend> getMeetingAttendList(int meetingId);

}
