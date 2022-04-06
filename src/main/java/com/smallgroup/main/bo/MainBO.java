package com.smallgroup.main.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smallgroup.main.dao.MainDAO;
import com.smallgroup.main.model.FavoriteDto;
import com.smallgroup.user.model.User;
import com.smallgroup.user.model.UserFavorite;
@Service
public class MainBO {
	
	@Autowired
	private MainDAO mainDAO;

	public User getMemberCreateById(String loginId) {
		return mainDAO.selectMemberCreateById(loginId);
	}

	public int memberUpdate(User user) {
		return mainDAO.memberUpdate(user);
	}

	public List<FavoriteDto> getCategory(){
		List<FavoriteDto> categoryList = mainDAO.getCategoryList();
		List<UserFavorite> categoryitemList = mainDAO.getCategoryItemList();
		
		for(FavoriteDto category : categoryList) {
			List<UserFavorite> categoryTemp = new ArrayList<>();
			for(UserFavorite item : categoryitemList) {
				if(category.getId() == item.getFavoriteId()) {
					categoryTemp.add(item);
				}
			}
			category.setUserfavoriteItems(categoryTemp);
		}
		return categoryList;
	}
}
