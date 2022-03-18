package com.smallgroup.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	@RequestMapping({"/*/*_view","/*/*/*_view","/*/*/*/*_view"})
	public String goPage(Model model, HttpServletRequest req) {
		String viewName = req.getRequestURI();
		viewName = viewName.substring(1, viewName.length()-5);
		model.addAttribute("viewName", viewName);
		return "template/layout";
	}
}
