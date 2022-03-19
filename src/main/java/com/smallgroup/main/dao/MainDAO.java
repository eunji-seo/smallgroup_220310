package com.smallgroup.main.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.smallgroup.user.model.User;
@Repository
public interface MainDAO {

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
