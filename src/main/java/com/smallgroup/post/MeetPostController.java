package com.smallgroup.post;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smallgroup.meet.bo.MeetBO;
import com.smallgroup.meet.model.Meet;
import com.smallgroup.post.bo.ContentViewBO;
import com.smallgroup.post.bo.MeetPostBO;
import com.smallgroup.post.model.ContentView;
import com.smallgroup.post.model.MeetPost;

@RequestMapping("/post")
@Controller
public class MeetPostController {
	@Autowired
	private MeetBO meetBO;
	
	
	@Autowired
	private MeetPostBO meetPostBO;
	
	@Autowired
	private ContentViewBO contentViewBO;
	/**
	 * 
	 * @param meetId
	 * @param model
	 * @return
	 */
	
	
	@RequestMapping("/post_create_view")
	public String postView(
			@RequestParam("meetId") int meetId,
			Model model) {
		
		System.out.println(meetId);
		Meet meet = meetBO.getMeetById(meetId);
		model.addAttribute("viewName", "post/post_create");
		model.addAttribute("meet", meet);
		return "template/layout";
	}
	
	@RequestMapping("/meet_post_view")
	public String meetPostView(
			@RequestParam("meetId") int meetId
			//,@RequestParam("meetPostId") int meetPostId
			,Model model
			,HttpSession session) {
		
		Integer userId = (Integer) session.getAttribute("id");
		
		System.out.println(meetId);
		
		List<ContentView> contentViewList = contentViewBO.generateContentViewList(meetId, userId);
		
		
		
		Meet meet = meetBO.getMeetById(meetId);
		model.addAttribute("viewName", "post/meetPost");
		model.addAttribute("meet", meet);
		model.addAttribute("contentViewList", contentViewList);
		return "template/layout";
		
	}
	
	
}
