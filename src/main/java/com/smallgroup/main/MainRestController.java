package com.smallgroup.main;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smallgroup.common.EncryptUtils;
import com.smallgroup.common.SHA256;
import com.smallgroup.main.bo.MainBO;
import com.smallgroup.user.model.User;
@RequestMapping("/main")
@RestController
public class MainRestController {
	SHA256 sha256 = new SHA256();
	
	@Autowired
	private MainBO mainBO;
	
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
		}
		
		return result;
		
	}
	
	
	
}
