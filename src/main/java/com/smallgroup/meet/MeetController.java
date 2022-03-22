package com.smallgroup.meet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smallgroup.meet.bo.MeetBO;
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

	@RequestMapping("/create_view")
	public String createView(
			Model model) {
		 
		MeetFavorite favoriteName = meetBO.getMeetFavorite();
		model.addAttribute("favoriteName", favoriteName.getFavoriteName());
		model.addAttribute("viewName", "meet/meet_create");
		return "template/layout";
	}
	
	

}
