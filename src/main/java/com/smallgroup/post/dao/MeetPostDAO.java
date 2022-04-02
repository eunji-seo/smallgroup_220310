package com.smallgroup.post.dao;

import org.springframework.stereotype.Repository;

import com.smallgroup.post.model.MeetPost;

@Repository
public interface MeetPostDAO {

	public int insertPost(MeetPost meetPost); 
}
