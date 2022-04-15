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

	public User addJoin(User user) {
		if (userDAO.insertJoin(user) == 1) {
			return mainDAO.selectMemberCreateById(user.getLoginId());
		}
		return null;
	}

	public User getLoginIdAndPassword(String loginId, String password) {
		return userDAO.selectLoginIdAndPassword(loginId, password);
	}

	public List<Favorite> getFavoriteById() {
		return userDAO.selectFavoriteById();
	}

	public int addUserFavorite(int userId, List<Integer> favoriteIds) {
		int cnt = 0;
		userDAO.deleteUserFavorite(userId);
		for (int favoriteId : favoriteIds) {
			cnt += userDAO.insertUserFavorite(userId, favoriteId);
		}
		return cnt;

	}
//	public int updateUserFavorite(int userId, List<Integer> favoriteIds) {
//		int cnt = 0;
//		for (int favoriteId : favoriteIds) {
//			cnt += userDAO.updateUserFavorite(userId, favoriteId);
//		}
//		return cnt;
//		
//	}

	public List<Favorite> selectUserFavorites(int userId) {
		return userDAO.selectUserFavorites(userId);
	}
	
	public User getUserById(int userId) {
		return userDAO.selectUserById(userId);
	}
}
