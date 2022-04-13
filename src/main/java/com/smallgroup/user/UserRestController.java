package com.smallgroup.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smallgroup.common.SHA256;
import com.smallgroup.meet.bo.MeetBO;
import com.smallgroup.meet.model.Meet;
import com.smallgroup.user.bo.UserBO;
import com.smallgroup.user.model.Favorite;
import com.smallgroup.user.model.User;

@RequestMapping("/user")
@RestController
public class UserRestController {

	@Autowired
	private SHA256 sha256;
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private MeetBO meetBO;
	

	/*
	 * 
	 */
	@RequestMapping("/is_duplicated_id")
	public Map<String, Object> isDuplicatedId(
			@RequestParam("loginId") String loginId
			){

		Map<String, Object> result = new HashMap<>();
		
		boolean exsit = userBO.getDuplicatedId(loginId);
		result.put("result", exsit);
		
		return result;
	}
	
	
	@PostMapping("/login")
	public Map<String, Object> login(
			@RequestParam("loginId") String loginId,			
			@RequestParam("password") String password,			
			HttpSession session){
		
		
		String encryptPassword = sha256.encrypt(password);
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		
		User user = userBO.getLoginIdAndPassword(loginId, encryptPassword);
		
		
		
		if(user != null) {			
			session.setAttribute("loginId", user.getLoginId());
			session.setAttribute("user", user);
			session.setAttribute("id", user.getId());
			session.setAttribute("name", user.getName());
			session.setAttribute("address", user.getAddress());
			List<Favorite> userFavorites = userBO.selectUserFavorites(user.getId());
			session.setAttribute("userFavorites", userFavorites);
			List<Meet> meetList = meetBO.getMeetListByMeetFavoriteId(null);
			session.setAttribute("meetList", meetList);
		} else {
			result.put("result", "error");
			result.put("errorMessage", "로그인을 다시 시도해주세요.");
		}
		
		return result;
	}
	
	/*
	 * 
	 */
	@PostMapping("/join")
	public Map<String, Object> join(
			@ModelAttribute User user,//@Valid
			HttpSession session){
		
		String encryptUtils = sha256.encrypt(user.getPassword());
		user.setPassword(encryptUtils);
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		User membersUser  = userBO.addJoin(user);
		
		if(membersUser != null) {
			session.setAttribute("loginId", membersUser.getLoginId());
			session.setAttribute("id", membersUser.getId());
			session.setAttribute("name", membersUser.getName());
			List<Favorite> userFavorites = userBO.selectUserFavorites(membersUser.getId());
			session.setAttribute("userFavorites", userFavorites);
		} else {
			result.put("result", "error");
			result.put("errorMessage", "회원가입을 다시 시도해주세요.");
		}
		return result;
		
	}
	
	/*
	 * 
	 */
	
	@GetMapping("/user_favorite")
	public Map<String, Object> isUserFavorite(
			@RequestParam(required = false, value = "favoriteIds") List<Integer> favoriteIds,
			HttpSession session){
		if(session.getAttribute("id")==null) {
			
		}
		int userId = (int) session.getAttribute("id");
		
		Map<String, Object> result = new HashMap<>();

		result.put("result", "success");
		
		int row = userBO.addUserFavorite(userId, favoriteIds);
		
		if(row < 1) {
			result.put("result", "error");
			result.put("errorMessage", "관심사 선택을 다시 시도해 주세요.");
		}
		return result;
		
	}
}
