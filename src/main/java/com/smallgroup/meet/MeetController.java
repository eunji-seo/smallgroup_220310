package com.smallgroup.meet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/meet")
@Controller
public class MeetController {
	
	@RequestMapping("/main_view")
	public String mainView(
			Model model) {
		model.addAttribute("viewName", "meet/main");
		return "template/layout";
	}

}
