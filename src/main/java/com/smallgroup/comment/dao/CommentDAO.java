package com.smallgroup.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.smallgroup.comment.model.Comment;

@Repository
public interface CommentDAO {

	public int insertComment(Comment comment);
	
	public List<Comment> selectCommentListByPostId(int meetPostId);
	
	public void deleteCommentsByPostId(int meetPostId); 
	
	public void deleteCommentByCommentIdAndUserId(
			@Param("commentId") int commentId, 
			@Param("userId") int userId);
	
}
