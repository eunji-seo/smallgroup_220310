package com.smallgroup.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smallgroup.post.bo.MeetPostBO;
import com.smallgroup.post.model.MeetPost;

@RestController
@RequestMapping("/post")
public class MeetPostRestController {
	private Logger logger = LoggerFactory.getLogger(this.getClass()); // import slf4j 확인 
	@Autowired
	private MeetPostBO meetPostBO;
	
	@PostMapping("/post_create")
	public Map<String, Object> postCreate(
			@ModelAttribute MeetPost meetPost,
			@RequestParam("meetId") int meetId,
			HttpSession session){
		
		int userId = (int) session.getAttribute("id");
		String loginId = (String) session.getAttribute("loginId");
		meetPost.setMeetId(meetId);
		meetPost.setUserId(userId);
	
		Map<String, Object> result = new HashMap<>();
		
		result.put("result", "success");
		int row = meetPostBO.addpost(loginId, meetPost);
		if(row < 1) {
			result.put("result", "error");
			result.put("errorMessage", "다시 시도해주세요");
		}
		return result;
		
	}
	
	@DeleteMapping("/delete")
	public Map<String, Object> delete(
			@RequestBody MeetPost meetPost,
			HttpSession session){
		int meetPostId = meetPost.getMeetId();
		Map<String, Object> result = new HashMap<>();
		
		Integer userId = (Integer) session.getAttribute("id"); // 직접 권한 검사함
		if(userId == null) {
			result.put("result", "error");
			result.put("errorMessage", "로그인후 사용가능합니다.");
			logger.error("[post delete] 로그인 세션이 없습니다. userId:{}, postId{}", userId , meetPostId); // 데이터 베이스 검증 > 로거에서 요청 주소 찾고 , 로거가 요청했던 단서를 남겨 놓는다.
			return result;
		}
		//postBO;
		meetPostBO.deletePostByPostIdANDUserId(meetPostId, userId);
		result.put("result", "success");
		return result;
	}
}
