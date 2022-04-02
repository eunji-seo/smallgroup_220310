package com.smallgroup.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smallgroup.meet.bo.MeetBO;
import com.smallgroup.meet.model.Meet;

@RequestMapping("/meet")
@Controller
public class MeetPostController {
	@Autowired
	private MeetBO meetBO;
	/**
	 * 
	 * @param meetId
	 * @param model
	 * @return
	 */
	
	@RequestMapping("/post_create_view")
	public String postView(
			//@RequestParam("meetId") int meetId,
			Model model) {
		
		
		Meet meet = meetBO.getMeetById(meetId);
		model.addAttribute("viewName", "post/meet_create");
		model.addAttribute("meet", meet);
		return "template/layout";
	}
	
}
