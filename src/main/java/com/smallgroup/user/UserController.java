package com.smallgroup.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smallgroup.user.bo.UserBO;
import com.smallgroup.user.model.Favorite;
import com.smallgroup.user.model.User;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserBO userBO;
	
	@RequestMapping("/join_view")
	public String joinView(
			Model model) {
		model.addAttribute("viewName", "user/join");
		return "template/layout";
	}
	
	@RequestMapping("/login_view")
	public String loginView(
			Model model) {
		model.addAttribute("viewName", "user/login");
		return "template/layout";
	}
	
	@RequestMapping("/favorite_view")
	public String favoriteView(
			//HttpServletRequest request,
			Model model) {
		 
		//HttpSession session = request.getSession();
		//int id = (int) session.getAttribute("id");
		
		List<Favorite> favoriteList = userBO.getFavoriteById();
		model.addAttribute("viewName", "user/user_favorite");
		model.addAttribute("favoriteList", favoriteList);
		return "template/layout";
	}
	
	@RequestMapping("/member_update_view")
	public String memberCreateView(
			Model model,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("loginId");
		
		
		User user = userBO.getMemberCreateById(loginId);
		
		model.addAttribute("viewName", "user/member_create");
		model.addAttribute("user", user);
		return "template/layout";
	}
	
	

}
