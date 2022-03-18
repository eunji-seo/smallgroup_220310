package com.smallgroup.user.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smallgroup.user.dao.UserDAO;
import com.smallgroup.user.model.Favorite;
import com.smallgroup.user.model.User;

@Service
public class UserBO {

	@Autowired
	private UserDAO userDAO;

	public boolean getDuplicatedId(String loginId) {
		return userDAO.selectDuplicatedId(loginId);
	}

	public User addJoin(String loginId, String password,  String name,String birth,String address, String email) {
		if(userDAO.insertJoin(loginId, password, name, birth, address, email)==1) {
			return userDAO.selectMemberCreateById(loginId);
		}
		return null;
	}
	
	public User getLoginIdAndPassword(String loginId, String password) {
		return userDAO.selectLoginIdAndPassword(loginId, password);
	}
	
	public User getMemberCreateById(String loginId) {
		return userDAO.selectMemberCreateById(loginId);
	}

	public int memberUpdate(int id, String loginId, String password, String name, String birth, String address, String email) {
		return userDAO.memberUpdate(id, loginId, password, name, birth, address, email);
	}
	
	public List<Favorite> getFavoriteById() {
		return userDAO.selectFavoriteById();
	}
	
	public int addUserFavorite(int userId ,List<Integer> favoriteId) {
		
		return 	userDAO.insertUserFavorite(userId, favoriteId);
		
	}
	
}
