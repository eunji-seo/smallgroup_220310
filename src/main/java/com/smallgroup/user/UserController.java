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
<<<<<<< HEAD
=======
import com.smallgroup.user.model.UserFavorite;
>>>>>>> f7ef43383f3190d9dbe0dc53f295ae401bbfef00

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserBO userBO;
	
	
	@RequestMapping("/favorite_view")
	public String favoriteView(	Model model, HttpSession session) {
		List<Favorite> favoriteList = userBO.getFavoriteById();
		model.addAttribute("viewName", "user/user_favorite");
		model.addAttribute("favoriteList", favoriteList);
		return "template/layout";
	}
	
	
	@RequestMapping("log_out")
	public String logOut(
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("loginId");
		session.removeAttribute("id");
		session.removeAttribute("name");
		
		return "redirect:/user/login_view";
	}

}
