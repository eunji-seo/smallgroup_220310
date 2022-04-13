package com.smallgroup.comment;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smallgroup.comment.bo.CommentBO;
import com.smallgroup.comment.model.Comment;
@RequestMapping("/comment")
@RestController
public class CommentRestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommentBO commentBO;
	
	
	@PostMapping("/create")
	public Map<String, Object> commentCreate(
			@ModelAttribute Comment comment,
			HttpSession session
			){
		
		int userId = (int) session.getAttribute("id");
		comment.setUserId(userId);
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		//logger.debug("{}==>", comment.getMeetPostId());
		
		
		int row = commentBO.insertComment(comment);
		if(row < 1) {
			result.put("errorMessage", "error");
		}
		
		return result;
	}
	@DeleteMapping("/delete")
	public Map<String, Object> deleteComment(
			@ModelAttribute Comment comment,
			HttpSession session){
		
		Map<String, Object> result = new HashMap<>();
		
		Integer userId = (Integer) session.getAttribute("id");
		
		if(userId == null ) {
			result.put("result", "error");
			result.put("errorMessage", "로그인을 다시 시도해 주세요.");
			logger.error("[comment error]  로그인 세션이 없습니다. userId:{}, commentId:{} ",userId, comment.getId() );
			return result;
		}
		comment.setUserId(userId);
		commentBO.deleteCommentByCommentIdAndUserId(comment);
		
		
		result.put("result", "success");
		return result;
	}
}
