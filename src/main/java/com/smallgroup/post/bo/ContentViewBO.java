package com.smallgroup.post.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smallgroup.comment.bo.CommentBO;
import com.smallgroup.comment.model.CommentView;
import com.smallgroup.like.bo.LikeBO;
import com.smallgroup.post.model.ContentView;
import com.smallgroup.post.model.MeetPost;
import com.smallgroup.user.bo.UserBO;
import com.smallgroup.user.model.User;

@Service
public class ContentViewBO {

	@Autowired
	private UserBO	userBO;
	@Autowired
	private MeetPostBO MeetpostBO;
	
	@Autowired
	private CommentBO commentBO;
	
	@Autowired
	private LikeBO likeBO;
	
	public List<ContentView> generateContentViewList(int meetId, int userId){
		List<ContentView> contentViewList = new ArrayList<>();
		
		
		// post 목록
		List<MeetPost> postList = MeetpostBO.getMeetPostList(meetId);
		for(MeetPost post: postList) {
			ContentView content = new ContentView();
			// 글 정보
			content.setMeetPost(post);
			
			// 글쓴이 정보
			User user = userBO.getUserById(post.getUserId());
			content.setUser(user);
			// 댓글 정보
			
			List<CommentView> commentList =  commentBO.generateCommentViewByPostId(post.getId());
			content.setCommentList(commentList);
			
			// 좋아요 갯수 세팅
			
			content.setLikeCount(post.getLikeCnt());
			
			// 로그인됨 사용자의 좋아요 여부 세팅
			boolean filledLike = likeBO.exsistLike(post.getId(), userId);
			content.setFilledLike(filledLike);
			
			contentViewList.add(content);
		}
		
		return contentViewList;
	}

}
