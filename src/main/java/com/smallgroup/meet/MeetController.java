package com.smallgroup.meet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smallgroup.meet.bo.MeetBO;
import com.smallgroup.meet.model.Meet;
import com.smallgroup.meet.model.MeetFavorite;
import com.smallgroup.user.model.Favorite;

@RequestMapping("/meet")
@Controller
public class MeetController {
	
	@Autowired
	private MeetBO meetBO;
	
	@RequestMapping("/favorite_view")
	public String favoriteView(
			Model model) {
		 
		
		List<Favorite> favoriteList = meetBO.getFavoriteById();
		model.addAttribute("viewName", "meet/favorite");
		model.addAttribute("favoriteList", favoriteList);
		return "template/layout";
	}

	@RequestMapping("/meet_create_view")
	public String createView(
			Model model) {
		 
//		model.addAttribute("favoriteName", meetBO.getMeetFavorite().getFavoriteName());
		model.addAttribute("viewName", "meet/meet_create");
		model.addAttribute("favoriteList", meetBO.getFavoriteById());
		return "template/layout";
	}
	
	
	@RequestMapping("/meet_view")
	public String meetDetail(
			Model model) {
		 
		Meet meet = meetBO.getMeetById();
		model.addAttribute("viewName", "meet/detail");
		model.addAttribute("meet", meet);
		return "template/layout";
	}
}
