package com.smallgroup.main;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smallgroup.main.bo.MainBO;
import com.smallgroup.meet.bo.MeetBO;
import com.smallgroup.meet.model.Meet;
import com.smallgroup.user.bo.UserBO;
import com.smallgroup.user.model.Favorite;
import com.smallgroup.user.model.User;
@RequestMapping("/main")
@Controller
public class MainController {

	@Autowired
	private MainBO mainBO; 
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private MeetBO meetBO;
	
	@RequestMapping("/main_view")
	public String mainView(
			Model model
			) {
		
		List<Meet> meet = meetBO.getMeetList();
		model.addAttribute("meet", meet);
		model.addAttribute("viewName", "main/main");
		return "template/layout";
	}
	
	@RequestMapping("/member_update_view")
	public String memberCreateView(
			Model model,
			HttpSession session) {
		
		String loginId = (String) session.getAttribute("loginId");
		
		
		User user = mainBO.getMemberCreateById(loginId);
		
		model.addAttribute("viewName", "main/member_update");
		model.addAttribute("user", user);
		return "template/layout";
	}
	
	@RequestMapping("/favorite_update_view")
	public String favoriteUpdate(
			Model model) {
		 
		List<Favorite> favoriteList = userBO.getFavoriteById();
		model.addAttribute("viewName", "main/favorite_update");
		model.addAttribute("favoriteList", favoriteList);
		return "template/layout";
	}
	



}
