package com.smallgroup.post.bo;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smallgroup.comment.bo.CommentBO;
import com.smallgroup.common.FileManagerService;
import com.smallgroup.like.bo.LikeBO;
import com.smallgroup.post.dao.MeetPostDAO;
import com.smallgroup.post.model.MeetPost;

@Service
public class MeetPostBO {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MeetPostDAO meetPostDAO;
	
	@Autowired
	private CommentBO commentBO;
	
	@Autowired
	private LikeBO likeBO;
	

	@Autowired
	private FileManagerService fileManger;
	
	
	public int addpost(String loginId, MeetPost meetPost) {
		
		String imagePath = null;
		if( meetPost.getFile()!= null) {
			imagePath = fileManger.saveFile(loginId, meetPost.getFile());
						meetPost.setPostImagePath(imagePath);	
		}
				
		return meetPostDAO.insertPost(meetPost);
	}

	
	public List<MeetPost> getMeetPostList(int meetId, int meetPostId){
		return meetPostDAO.getMeetPostList(meetId, meetPostId);
	}
	
	public MeetPost getPostByPostIdAndUserId(int postId, int userId) {
		return meetPostDAO.selectPostByPostIdAndUserId(postId, userId);
	}
	
	
	public void deletePostByPostIdANDUserId(int meetPostId, int userId) {
		// postId로 select post //로깅에 남겨두는것이 좋다 if문으로 logger 처리
		MeetPost post = getPostByPostIdAndUserId(meetPostId, userId);  
	
		if(post == null) {
			logger.warn("[post delete] 삭제할 게시물이 없습니다. ");
			return;
		}
		
		// 이미지가 있으면 이미지 삭제 
		if(post.getPostImagePath() != null) {
			try {
				fileManger.deleteFile(post.getPostImagePath());
			} catch (IOException e) {
				logger.error("[delete post] 이미지 삭제 실패, postId{}, path:{} ",meetPostId, post.getPostImagePath());
			}
		}
		// 글 삭제 byPostIdUserId 종속(좋아요, 댓글)
		meetPostDAO.deletePost(meetPostId, userId);
		// 댓글들 삭제 byPostId 다른 테이블에 postId를 넣어 삭제된 글 표시함 (Batch System(spring Batch) 일정시간에 수행(job) 1000행씩 지운다)
		commentBO.deleteCommentsByPostId(meetPostId);
		// 좋아요들 삭제 byPostId 
		likeBO.deleteLikeByPostId(meetPostId);
		
	}
	
}
