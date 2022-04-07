package com.smallgroup.comment.dao;

import org.springframework.stereotype.Repository;

import com.smallgroup.comment.model.Comment;

@Repository
public interface CommentDAO {

	public int insertComment(Comment comment);
	
}
