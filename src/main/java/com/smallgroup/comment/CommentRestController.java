package com.smallgroup.comment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smallgroup.comment.bo.CommentBO;
@RequestMapping("/comment")
@RestController
public class CommentRestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommentBO commentBO;
	
	
	
}
