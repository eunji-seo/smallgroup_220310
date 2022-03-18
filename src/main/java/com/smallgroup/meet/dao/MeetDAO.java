package com.smallgroup.meet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.smallgroup.user.model.Favorite;

@Repository
public interface MeetDAO {

	public List<Favorite> selectFavoriteById();
	
}
