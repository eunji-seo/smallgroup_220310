package com.smallgroup.meet;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smallgroup.meet.bo.MeetBO;
import com.smallgroup.meet.model.Meet;
import com.smallgroup.meet.model.MeetFavorite;
@RequestMapping("/meet")
@RestController
public class MeetRestController {

	@Autowired
	private MeetBO meetBO;
	

	/*
	 * 
	 */
	@PostMapping("/create")
	public Map<String, Object> MeetCreate(
			@ModelAttribute Meet meet,
			HttpSession session){
		int userId = (int) session.getAttribute("id");
		
		Map<String,Object> result = new HashMap<>();
		result.put("result", "success");
		
		
		String loginId = (String) session.getAttribute("loginId");
		
		
	    int row = meetBO.addMeet(loginId, meet);
		
		if(row < 1) {
			result.put("result", "error");
			result.put("errorMessage", "모임 만들기를 다시 시도해 주세요.");
		}
		return result;
		
	}
	
	@PostMapping("/detail")
	public Map<String, Object> detailJoin(
			@RequestParam("meetId") int meetId,
			@RequestParam("leader") String leader,
			@RequestParam("joinName") String joinName,			
			HttpServletRequest request){
		
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("id");
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		int row = meetBO.addJoin(meetId, userId, leader, joinName);
		
		if(row < 1) {
			result.put("result", "fail");
			result.put("errorMessage", "모임 가입을 다시 시도하여주세요.");
			
		}
		
		return result;
		
	}
}
