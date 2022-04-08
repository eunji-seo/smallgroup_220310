package com.smallgroup.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smallgroup.like.dao.LikeDAO;

@Service
public class LikeBO {

	@Autowired
	private LikeDAO likeDAO;
	
	public void addLike (int meetPostId , int userId){
		boolean exsistLike = exsistLike(meetPostId, userId);
		if(exsistLike) {
			likeDAO.deleteLikeByPostIdUserId(meetPostId, userId);		
		}else {
			likeDAO.insertLike(meetPostId, userId);		
			
		}	
	}
	public boolean exsistLike(int meetPostId, Integer userId) {
		if(userId == null) {
			return false;
		}
		int count = likeDAO.selectExsistLikePostIdUserId(meetPostId, userId);
		return count > 0? true : false;
	}
	public int countLikeByPostId(int meetPostId) {
		return likeDAO.selectExsistLikePostIdUserId(meetPostId, null);
	}
	
	public void deleteLikeByPostIdUserId(int meetPostId, int userId) {
		likeDAO.deleteLikeByPostIdUserId(meetPostId, userId);
	}
	public void deleteLikeByPostId(int meetPostId) {
		likeDAO.deleteLikeByPostId(meetPostId);
	}

}
