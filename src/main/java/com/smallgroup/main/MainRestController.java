package com.smallgroup.main;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smallgroup.main.bo.MainBO;
@RequestMapping("/main")
@RestController
public class MainRestController {

	@Autowired
	private MainBO mainBO;
	
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
		int row = mainBO.memberUpdate(id, loginId, password, name, birth, address, email);
		result.put("result", "success");
		
		if(row < 1) {
			result.put("result", "error");
			result.put("errorMessage", "회원수정을 다시 시도해주세요.");
		}
		
		return result;
		
	}
}
