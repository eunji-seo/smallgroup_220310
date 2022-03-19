package com.smallgroup.meet.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smallgroup.meet.dao.MeetDAO;
import com.smallgroup.user.model.Favorite;

@Service
public class MeetBO {

	@Autowired
	private MeetDAO meetDAO;
	public List<Favorite> getFavoriteById() {
		return meetDAO.selectFavoriteById();
	}
	
	public int addMeetFavorite(int userId ,int favoriteIds) {
			return 	meetDAO.insertMeetFavorite(userId, favoriteIds);
		
	}
}
