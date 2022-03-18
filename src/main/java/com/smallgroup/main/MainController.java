package com.smallgroup.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/main")
@Controller
public class MainController {

	@RequestMapping("/main_view")
	public String mainView(
			Model model) {
		model.addAttribute("viewName", "main/main");
		return "template/layout";
	}
	@RequestMapping("/mypage_view")
	public String mypageView(
			Model model) {
		model.addAttribute("viewName", "main/mypage");
		return "template/layout";
	}
}
