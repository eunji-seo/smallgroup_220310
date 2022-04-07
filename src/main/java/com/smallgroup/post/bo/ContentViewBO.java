package com.smallgroup.post.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smallgroup.comment.bo.CommentBO;
import com.smallgroup.comment.model.CommentView;
import com.smallgroup.post.model.ContentView;
import com.smallgroup.post.model.MeetPost;
import com.smallgroup.user.bo.UserBO;
import com.smallgroup.user.model.User;

@Service
public class ContentViewBO {

	@Autowired
	private UserBO	userBO;
	@Autowired
	private MeetPostBO MeetpostBO;
	
	@Autowired
	private CommentBO commentBO;
	
//	@Autowired
//	private LikeBO likeBO;

}
