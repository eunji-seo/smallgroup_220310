package com.smallgroup.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.smallgroup.post.model.ContentView;
import com.smallgroup.post.model.MeetPost;

@Repository
public interface MeetPostDAO {

	public int insertPost(MeetPost meetPost); 
	
	public List<MeetPost> getMeetPostList(@Param("meetId") int meetId, @Param("id") int meetPostId);
	
	public MeetPost selectPostByPostIdAndUserId(
			@Param("id") int meetPostId, 
			@Param("userId") int userId);
	
	public List<ContentView> selectCommentList(Integer userId);
	
	public void deletePost(
			@Param("id") int meetPostId, 
			@Param("userId") int userId);
	
}
