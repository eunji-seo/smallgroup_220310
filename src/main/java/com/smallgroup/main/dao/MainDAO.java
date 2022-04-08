package com.smallgroup.main.dao;

import org.springframework.stereotype.Repository;

import com.smallgroup.user.model.User;
@Repository
public interface MainDAO {

	public User selectMemberCreateById(String loginId);
	
	public int memberUpdate(User user);	

	
}
