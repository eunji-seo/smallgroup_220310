package com.smallgroup.meet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smallgroup.meet.bo.MeetBO;
import com.smallgroup.user.model.Favorite;

@RequestMapping("/meet")
@Controller
public class MeetController {
	
	@Autowired
	private MeetBO meetBO;
	
	@RequestMapping("/favorite_view")
	public String favoriteView(
			//HttpServletRequest request,
			Model model) {
		 
		//HttpSession session = request.getSession();
		//int id = (int) session.getAttribute("id");
		
		List<Favorite> favoriteList = meetBO.getFavoriteById();
		model.addAttribute("viewName", "meet/meet_favorite");
		model.addAttribute("favoriteList", favoriteList);
		return "template/layout";
	}

}
