package com.smallgroup.like.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeDAO {

	public int selectExsistLikePostIdUserId(
			@Param("meetPostId") int meetPostId, 
			@Param("userId") Integer userId);

	public void insertLike (
			@Param("meetPostId") int meetPostId , 
			@Param("userId") int userId);
	
	public void deleteLikeByPostIdUserId(
			@Param("commentId") int commentId , 
			@Param("userId") int userId);
	
	public void deleteLikeByPostId(int meetPostId);
}
