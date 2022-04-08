package com.smallgroup.main.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smallgroup.main.dao.MainDAO;
import com.smallgroup.user.model.User;
@Service
public class MainBO {
	
	@Autowired
	private MainDAO mainDAO;

	public User getMemberCreateById(String loginId) {
		return mainDAO.selectMemberCreateById(loginId);
	}

	public int memberUpdate(User user) {
		return mainDAO.memberUpdate(user);
	}

}
