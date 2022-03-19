package com.smallgroup.user.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smallgroup.main.dao.MainDAO;
import com.smallgroup.user.dao.UserDAO;
import com.smallgroup.user.model.Favorite;
import com.smallgroup.user.model.User;

@Service
public class UserBO {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private MainDAO mainDAO;

	public boolean getDuplicatedId(String loginId) {
		return userDAO.selectDuplicatedId(loginId);
	}

	public User addJoin(String loginId, String password,  String name,String birth,String address, String email) {
		if(userDAO.insertJoin(loginId, password, name, birth, address, email) == 1) {
			return mainDAO.selectMemberCreateById(loginId);
		}
		return null;
	}
	
	public User getLoginIdAndPassword(String loginId, String password) {
		return userDAO.selectLoginIdAndPassword(loginId, password);
	}
	
		
	public List<Favorite> getFavoriteById() {
		return userDAO.selectFavoriteById();
	}
	
	public int addUserFavorite(int userId ,List<Integer> favoriteIds) {
		for( int favoriteId : favoriteIds ) {
			return 	userDAO.insertUserFavorite(userId, favoriteId);
		}
		return userId;
		
	}
	
}
