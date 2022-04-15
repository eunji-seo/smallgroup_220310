package com.smallgroup.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smallgroup.common.SHA256;
import com.smallgroup.main.bo.MainBO;
import com.smallgroup.user.bo.UserBO;
import com.smallgroup.user.model.User;
@RequestMapping("/main")
@RestController
public class MainRestController {
	@Autowired 
	private SHA256 sha256;
	@Autowired
	private MainBO mainBO;
	
	@Autowired
	private UserBO userBO;
	
	@PutMapping("/member_update")
	public Map<String, Object> update(
			@ModelAttribute User user,
			HttpSession session 
			){
		String encryptUtils = sha256.encrypt(user.getPassword());
		user.setPassword(encryptUtils);
		
		int id = (int) session.getAttribute("id");
		String loginId = (String) session.getAttribute("loginId");
		user.setLoginId(loginId);
		user.setId(id);
		
		Map<String, Object> result = new HashMap<>();
		int row = mainBO.memberUpdate(user);
		result.put("result", "success");
	
		if(row < 1) {
			result.put("result", "error");
			result.put("errorMessage", "회원수정을 다시 시도해주세요.");
		} else {
			session.setAttribute("user", user);
		}
		
		return result;
		
	}
	
//	@PutMapping("/update_favorite")
//	public Map<String, Object> updateFavorite(
//			@RequestParam(required = false, value = "favoriteIds") List<Integer> favoriteIds,
//			HttpSession session){
//		
//		int userId = (int) session.getAttribute("id");
//		
//		Map<String, Object> result = new HashMap<>();
//
//		result.put("result", "success");
//		
//		int row = userBO.updateUserFavorite(userId, favoriteIds);
//		if(row < 1) {
//			result.put("result", "error");
//			result.put("errorMessage", "관심사 선택을 다시 시도해 주세요.");
//		}
//		return result;
//		
//	}

	
}
