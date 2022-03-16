package com.smallgroup.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smallgroup.user.dao.UserDAO;
import com.smallgroup.user.model.User;

@Service
public class UserBO {

	@Autowired
	private UserDAO userDAO;

	public boolean getDuplicatedId(String loginId) {
		return userDAO.selectDuplicatedId(loginId);
	}
	
	public int addJoin(User user) {
		return userDAO.insertJoin(user);
	}
	
	public User getLoginIdAndPassword(User user) {
		return userDAO.selectLoginIdAndPassword(user);
	}
	
	public User getMemberCreateById(String loginId) {
		return userDAO.selectMemberCreateById(loginId);
	}

	public int memberUpdate(int id, String loginId, String password, String name, String birth, String address, String email) {
		return userDAO.memberUpdate(id, loginId, password, name, birth, address, email);
	}
}
