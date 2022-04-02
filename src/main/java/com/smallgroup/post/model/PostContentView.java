package com.smallgroup.post.model;

import java.util.List;

import com.smallgroup.commnet.model.CommentView;
import com.smallgroup.user.model.User;

public class PostContentView {

	private User user; // 글쓴이 정보
	private MeetPost meetPost; // 글정보
	
	private List<CommentView> commentView; // 댓글 정보
	
	private int likeCount;// 좋아요 갯수
	private boolean filledLike; // 좋아요를 눌렀는지의 여부
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public MeetPost getMeetPost() {
		return meetPost;
	}
	public void setMeetPost(MeetPost meetPost) {
		this.meetPost = meetPost;
	}
	public List<CommentView> getCommentView() {
		return commentView;
	}
	public void setCommentView(List<CommentView> commentView) {
		this.commentView = commentView;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public boolean isFilledLike() {
		return filledLike;
	}
	public void setFilledLike(boolean filledLike) {
		this.filledLike = filledLike;
	}
	@Override
	public String toString() {
		return "PostContentView [user=" + user + ", meetPost=" + meetPost + ", commentView=" + commentView
				+ ", likeCount=" + likeCount + ", filledLike=" + filledLike + "]";
	}
	
	
	
	
	
	
}
