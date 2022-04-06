package com.smallgroup.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smallgroup.common.FileManagerService;
import com.smallgroup.post.dao.MeetPostDAO;
import com.smallgroup.post.model.MeetPost;

@Service
public class MeetPostBO {
	
	@Autowired
	private MeetPostDAO meetPostDAO;
	

	@Autowired
	private FileManagerService fileManger;
	
	
	public int addpost(String loginId, MeetPost meetPost) {
		
		String imagePath = null;
		if( meetPost.getFile()!= null) {
			imagePath = fileManger.saveFile(loginId, meetPost.getFile());
						meetPost.setPostImagePath(imagePath);	
		}
				
		return meetPostDAO.insertPost(meetPost);
	}

	
	public List<MeetPost> getMeetPostList(){
		return meetPostDAO.getMeetPostList();
	}
	
	
	
}
