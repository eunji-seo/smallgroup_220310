package com.smallgroup.meet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smallgroup.meet.bo.MeetBO;
import com.smallgroup.meet.model.Meet;
import com.smallgroup.meet.model.MeetJoin;
import com.smallgroup.meet.model.Meeting;
import com.smallgroup.meet.model.MeetingAttend;
@RequestMapping("/meet")
@RestController
public class MeetRestController {

	@Autowired
	private MeetBO meetBO;
	
	
	@GetMapping("/attends/{meetingId}")
	public List<MeetingAttend> getAttends(@PathVariable int meetingId){
		
		return meetBO.getMeetingAttendList(meetingId);
	}
	@PostMapping("/create")
	public Map<String, Object> MeetCreate(
			@ModelAttribute Meet meet,
			HttpSession session){
		
		
		int userId = (int) session.getAttribute("id");
		String loginId = (String) session.getAttribute("loginId");
		meet.setUserId(userId);
		
		Map<String,Object> result = new HashMap<>();
		result.put("result", "success");
		
		
	    int row = meetBO.addMeet(loginId, meet);
		
		if(row < 1) {
			result.put("result", "error");
			result.put("errorMessage", "모임 만들기를 다시 시도해 주세요.");
		}
		return result;
		
	}
	
	@PostMapping("/detail_join")
	public Map<String, Object> detailJoin(
			@ModelAttribute MeetJoin meetJoin,
			@RequestParam("meetId") int meetId,
			HttpSession session){
		
		
		int userId = (int) session.getAttribute("id");
		meetJoin.setUserId(userId);
		meetJoin.setMeetId(meetId);
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		int row = meetBO.addJoin(meetJoin);
		
		
		if(row < 1) {
			result.put("result", "fail");
			result.put("errorMessage", "모임 가입을 다시 시도하여주세요.");
			
		}
		
		return result;
		
	}
	
	@PostMapping("/detail_attend")
	public Map<String, Object> detailAttend(
			@ModelAttribute MeetingAttend meetingAttend,
			@RequestParam("meetId") int meetId,
			HttpSession session){
		
		
		int userId = (int) session.getAttribute("id");
		meetingAttend.setUserId(userId);
		meetingAttend.setMeetId(meetId);
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		int	rowcount = meetBO.addAttend(meetingAttend);
		
		
		if(rowcount < 1) {
			result.put("result", "fail");
			result.put("errorMessage", "참석을 다시 시도하여주세요.");
			
		}
		return result;
		
	}
	
	
	@PostMapping("/meeting")
	public Map<String, Object> meeting(
			@ModelAttribute Meeting meeting,
			HttpSession session){
		
		int userId = (int) session.getAttribute("id");
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		meeting.setUserId(userId);
		
		int row = meetBO.addMeeting(meeting);
		
		if(row < 1) {
			result.put("result", "error");
			result.put("errorMessage", "모임등록을 다시 시도해주세요.");
		}
		return result;
		
	}
	
	
	
}

