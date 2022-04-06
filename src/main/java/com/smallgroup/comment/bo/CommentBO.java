package com.smallgroup.comment.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smallgroup.comment.dao.CommentDAO;
import com.smallgroup.user.bo.UserBO;

@Service
public class CommentBO {
	@Autowired
	private CommentDAO commentDAO; // BO는 남의 DAO 을 부르지 않고BO 을 부른다
	
	@Autowired
	private UserBO userBO;  // userBO 가 커먼트비오를 또 부르면 상호참조 에러 발생됨

}
