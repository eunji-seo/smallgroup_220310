package com.smallgroup.post.model;

import java.util.List;

import com.smallgroup.comment.model.CommentView;
import com.smallgroup.user.model.User;

public class ContentView {

	private User user; // 글쓴이 정보
	private MeetPost meetPost; // 글정보
	
	private List<CommentView> commentlist; // 댓글 정보

//	private int likeCount;// 좋아요 갯수
//	private boolean filledLike; // 좋아요를 눌렀는지의 여부
	

	
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

	public List<CommentView> getCommentlist() {
		return commentlist;
	}

	public void setCommentlist(List<CommentView> commentlist) {
		this.commentlist = commentlist;
	}

	@Override
	public String toString() {
		return "ContentView [user=" + user + ", meetPost=" + meetPost + ", commentlist=" + commentlist + "]";
	}
	
	
	
	
	
}
