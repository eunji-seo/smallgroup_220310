package com.smallgroup.comment.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smallgroup.comment.dao.CommentDAO;
import com.smallgroup.comment.model.Comment;
import com.smallgroup.comment.model.CommentView;
import com.smallgroup.user.bo.UserBO;
import com.smallgroup.user.model.User;

@Service
public class CommentBO {
	@Autowired
	private CommentDAO commentDAO; // BO는 남의 DAO 을 부르지 않고BO 을 부른다
	
	@Autowired
	private UserBO userBO;  // userBO 가 커먼트비오를 또 부르면 상호참조 에러 발생됨

	
	public int insertComment(Comment comment) {
		return commentDAO.insertComment(comment);
	}
	
	public List<Comment> getCommentListByPostId(int meetPostId){
		return commentDAO.selectCommentListByPostId(meetPostId);
	}
	
	public List<CommentView> generateCommentViewByPostId(int meetPostId){ // generate data 의 가공
		List<CommentView> resultList = new ArrayList<>();
		List<Comment> commentList = getCommentListByPostId(meetPostId);
		
		for(Comment comment : commentList) { // Comment -> CommentView 
			CommentView commentView = new CommentView();
			// 댓글
			commentView.setComment(comment);
			
			// 댓글쓴이
			User user = userBO.getUserById(comment.getUserId()); // 댓글쓴이 객체를 통으로 넣어준다
			commentView.setUser(user); // 추가적으로 넣을 수있겝
			
			resultList.add(commentView); // 마지막으로 댓글을 넣어 준다.
			
		}
		
		return resultList;
		 
	}
		
	public void deleteCommentsByPostId(int meetPostId) {
		commentDAO.deleteCommentsByPostId(meetPostId);
	}
	
	public void deleteCommentByCommentIdAndUserId(Comment comment) {
		commentDAO.deleteCommentByCommentIdAndUserId(comment);
	}
}
