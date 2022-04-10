package com.smallgroup.chat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smallgroup.meet.bo.MeetBO;
import com.smallgroup.meet.model.Meet;
import com.smallgroup.meet.model.MeetJoin;
@RequestMapping("/chat")
@Controller
public class ChatController {

	@Autowired
	private MeetBO meetBO;
	
	@RequestMapping("/chat_view")
	public String chat(
			@RequestParam("meetId") int meetId
			,Model model) {
		
		List<MeetJoin> joinList = meetBO.getJoinName(meetId);
		Meet meet = meetBO.getMeetById(meetId);
		model.addAttribute("viewName", "chat/chat");
		model.addAttribute("meet", meet);
		model.addAttribute("joinList", joinList);
		return "template/layout";
	}
}
