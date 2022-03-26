package com.smallgroup.meet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smallgroup.meet.bo.MeetBO;
import com.smallgroup.meet.model.Meet;
import com.smallgroup.user.model.Favorite;

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
	@RequestMapping("/meet_view")
	public String meetDetail(
			@RequestParam("meetId") int meetId,
			Model model) {
		 
		Meet meet = meetBO.getMeetById(meetId);
		model.addAttribute("viewName", "meet/detail");
		model.addAttribute("meet", meet);
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
	@RequestMapping("/post_view")
	public String postView(
			@RequestParam("meetId") int meetId,
			Model model) {
		
		
		Meet meets = meetBO.getMeetById(meetId);
		model.addAttribute("viewName", "meet/meeting");
		model.addAttribute("meet", meets);
		return "template/layout";
	}
	
	
}
