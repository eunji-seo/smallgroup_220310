package com.smallgroup.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smallgroup.user.bo.UserBO;
import com.smallgroup.user.model.User;

@RequestMapping("/user")
@RestController
public class UserRestController {

	@Autowired
	private UserBO userBO;
	
	@RequestMapping("/is_duplicated_id")
	public Map<String, Object> isDuplicatedId(
			@RequestParam("loginId") String loginId
			){

		Map<String, Object> result = new HashMap<>();
		
		boolean exsit = userBO.getDuplicatedId(loginId);
		result.put("result", exsit);
		
		return result;
	}
	
	@PostMapping("/join")
	public Map<String, Object> join(
			@ModelAttribute  User user //@Valid
			){
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		int row = userBO.addJoin(user);
		
		if(row < 1) {
			result.put("result", "error");
			result.put("errorMessage", "회원가입을 다시 시도해주세요.");
		}
		
		return result;
		
	}
	

	@PostMapping("/login")
	public Map<String, Object> login(
			@ModelAttribute  User user,			
			HttpServletRequest request){
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		User memberUser = userBO.getLoginIdAndPassword(user);
		
		if(memberUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginId", user.getLoginId());
			session.setAttribute("id", user.getId());
			session.setAttribute("name", user.getName());
		} else {
			result.put("result", "error");
			result.put("errorMessage", "로그인을 다시 시도해주세요.");
		}
		
		return result;
	}
	
	@PutMapping("/member_update")
	public Map<String, Object> update(
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("birth") String birth,
			@RequestParam("address") String address,
			@RequestParam("email") String email,			
			HttpServletRequest request
			){
		
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		String loginId = (String) session.getAttribute("loginId");
		
		
		Map<String, Object> result = new HashMap<>();
		int row = userBO.memberUpdate(id, loginId, password, name, birth, address, email);
		result.put("result", "success");
		
		if(row < 1) {
			result.put("result", "error");
			result.put("errorMessage", "회원수정을 다시 시도해주세요.");
		}
		
		return result;
		
	}
}
