package com.smallgroup.user.dao;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smallgroup.user.model.User;

@Repository
public interface UserDAO {
	
	public boolean selectDuplicatedId(String loginId); 
	
	public int insertJoin(User user); 
	
	public User selectLoginIdAndPassword(User user); 
	
	public User selectMemberCreateById(String loginId);
	
	public int memberUpdate(
			@Param("id") int id, 
			@Param("loginId") String loginId, 
			@Param("password") String password, 
			@Param("name") String name, 
			@Param("birth") String birth, 
			@Param("address") String address, 
			@Param("email") String email);
	
}
