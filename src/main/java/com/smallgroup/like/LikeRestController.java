package com.smallgroup.like;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smallgroup.like.bo.LikeBO;

@RestController
public class LikeRestController {

	@Autowired
	private LikeBO likeBO;
	
	// /like/{postId} // 와일드카드
	@PostMapping("/like/{meetPostId}") //pathVariable
	public Map<String, Object> like(
			@PathVariable int meetPostId, 
			HttpSession session 
			){
		
		Integer userId = (Integer) session.getAttribute("userId");
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		if(userId == null) {
			result.put("result", "error");
			result.put("errorMassage", "로그인 후 사용가능합니다.");
			return result;
		}
		
		
		// TODO 좋아요 갯수 BO 
		likeBO.countLikeByPostId(meetPostId);
		// TODO 사용자의 좋아요 여부 
		likeBO.addLike(meetPostId, userId);
		
		return result;
		
	}
}
