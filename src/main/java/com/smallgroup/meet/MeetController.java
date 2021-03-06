package com.smallgroup.meet;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smallgroup.meet.bo.MeetBO;
import com.smallgroup.meet.model.Meet;
import com.smallgroup.meet.model.MeetJoin;
import com.smallgroup.meet.model.Meeting;
import com.smallgroup.meet.model.MeetingAttend;
import com.smallgroup.user.model.Favorite;
import com.smallgroup.user.model.User;

@RequestMapping("/meet")
@Controller
public class MeetController {
	
	@Autowired
	private MeetBO meetBO;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	
	@RequestMapping("/favorite_view")
	public String favoriteView(
			Model model) {
		
		List<Favorite> favoriteList = meetBO.getFavoriteById();
		model.addAttribute("viewName", "meet/favorite");
		model.addAttribute("favoriteList", favoriteList);
		return "template/layout";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/meet_create_view")
	public String createView(
			Model model) {
		 
//		model.addAttribute("favoriteName", meetBO.getMeetFavorite().getFavoriteName());
		model.addAttribute("viewName", "meet/meet_create");
		model.addAttribute("favoriteList", meetBO.getFavoriteById());
		return "template/layout";
	}
	
	/**										
	 * 
	 * @param meetId
	 * @param model
	 * @return
	 */
	@RequestMapping("/detail_view")
	public String meetDetail(
			@RequestParam("meetId") int meetId, 
			HttpSession session, Model model) {
		int userId = (int)session.getAttribute("id");
		
		
		
		List<MeetJoin> join = meetBO.getJoinName(meetId);
		int cnt = meetBO.getJoinNameByName(meetId, userId);
		User memberName =meetBO.getRederName(meetId);
		
		List<Meeting> meetingList = meetBO.getMeetingList(meetId); 
		
		Meet meet = meetBO.getMeetById(meetId);
		
		
		model.addAttribute("viewName", "meet/detail");
		model.addAttribute("meet", meet);
		model.addAttribute("meetingList", meetingList);
		model.addAttribute("memberName", memberName);
		model.addAttribute("join", join);
		model.addAttribute("cnt", cnt);
		
		return "template/layout";
	}
	/**
	 * 
	 * @param meetId
	 * @param model
	 * @return
	 */
	@RequestMapping("/meeting_view")
	public String meetingView(
			@RequestParam("meetId") int meetId,
			Model model) {
		 
		
		Meet meets = meetBO.getMeetById(meetId);
		model.addAttribute("viewName", "meet/meeting");
		model.addAttribute("meet", meets);
		return "template/layout";
	}
	
	
	
	
	
}
