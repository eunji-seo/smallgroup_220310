package com.smallgroup.meet.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smallgroup.common.FileManagerService;
import com.smallgroup.meet.dao.MeetDAO;
import com.smallgroup.meet.model.Meet;
import com.smallgroup.meet.model.MeetJoin;
import com.smallgroup.meet.model.Meeting;
import com.smallgroup.meet.model.MeetingAttend;
import com.smallgroup.user.model.Favorite;
import com.smallgroup.user.model.User;

@Service
public class MeetBO {

	@Autowired
	private MeetDAO meetDAO;
	
	@Autowired
	private FileManagerService fileManger;
	
	
	public List<Favorite> getFavoriteById() {
		return meetDAO.selectFavoriteById();
	}
	
	public int addMeetFavorite(int userId ,int favoriteIds) {
		return 	meetDAO.insertMeetFavorite(userId, favoriteIds);
		
	}
	
	
	public int addMeet(String loginId, Meet meet) {
		
		String imagePath = null;
		if( meet.getFile() != null) {
			imagePath = fileManger.saveFile(loginId,meet.getFile());
						meet.setMeetImagePath(imagePath);	
		}
				
		return meetDAO.insertMeet(meet);
	}
	
	public Meet getMeetById(int meetId) {
		return meetDAO.selectMeetById(meetId);
	}

	public List<Meet> getMeetList() {
		return meetDAO.selectMeetList();
	}
	
	public int addJoin(MeetJoin meetJoin) {
		return meetDAO.insertJoin(meetJoin);
	}
	
	public int addAttend(MeetingAttend meetingAttend) {
		return meetDAO.insertAttend(meetingAttend);
	}
	
	public	User getRederName(int meetId){ 
		return meetDAO.getRederName(meetId);
	}
	
	public List<MeetJoin> getJoinName(int meetId) {
		return meetDAO.getJoinName(meetId);
	}
	
	public int getJoinNameByName(int meetId, int userId) {
		
		
		return meetDAO.getJoinNameByName(meetId,userId);
	}

	public int addMeeting(Meeting meeting) {
		return meetDAO.insertMeeting(meeting);
	}
	
	public List<Meeting> getMeetingList(int meetId){
		return meetDAO.selectMeetingList(meetId);
	}
	
	public Meeting getMeeting(int meetingId, int meetId){
		return meetDAO.selectMeeting(meetingId, meetId);
	}
	
	public List<MeetingAttend> getMeetingAttendList(int meetingId){
		return meetDAO.getMeetingAttendList(meetingId);
	
	
	}
}