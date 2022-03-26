package com.smallgroup.meet.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smallgroup.common.FileMangerService;
import com.smallgroup.meet.dao.MeetDAO;
import com.smallgroup.meet.model.Meet;
import com.smallgroup.meet.model.Meeting;
import com.smallgroup.user.model.Favorite;

@Service
public class MeetBO {

	@Autowired
	private MeetDAO meetDAO;
	
	@Autowired
	private FileMangerService fileManger;
	
	
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
//	public Meet getMeetId() {
//		return meetDAO.selectMeetId();
//	}
//	
	
	public List<Meet> getMeetList() {
		return meetDAO.selectMeetList();
	}
	
	public int addJoin(int meetId, int userId, String leader, String joinName) {
		return meetDAO.insertJoin(meetId, userId, leader, joinName);
	}
	/*
	 * 
	 */
	public int addMeeting(Meeting meeting) {
		return meetDAO.insertMeeting(meeting);
	}
}
