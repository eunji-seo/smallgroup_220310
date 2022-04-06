package com.smallgroup.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smallgroup.post.bo.MeetPostBO;
import com.smallgroup.post.model.MeetPost;

@RestController
@RequestMapping("/meet")
public class MeetPostRestController {

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
}
