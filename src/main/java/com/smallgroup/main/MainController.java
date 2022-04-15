package com.smallgroup.main;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String mainView(Model model, @RequestParam(name = "FavoriteId", required = false) Integer FavoriteId) {
		
		List<Meet> meet = meetBO.getMeetListByMeetFavoriteId(FavoriteId);
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
	
	@RequestMapping("/mypage_view")
	public String mypageView(Model model
			,HttpSession session) {
		
		int userId = (int) session.getAttribute("id");
		
		List<Meet> meetUser = meetBO.getMeetListByMeetAndUserId(userId);
		List<Meet> meetJoin = meetBO.getMeetListByJoinAndUserId(userId);
		List<Favorite> userFavoriteList = userBO.selectUserFavorites(userId);
		User user = userBO.getUserById(userId);
		
		model.addAttribute("viewName", "main/mypage");
		model.addAttribute("meetUser", meetUser);
		model.addAttribute("meetJoin", meetJoin);
		model.addAttribute("userFavoriteList", userFavoriteList);
		model.addAttribute("user", user);
		return "template/layout";
	}



}
