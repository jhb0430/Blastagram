package com.jhb0430.blastagram.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jhb0430.blastagram.user.domain.User;
import com.jhb0430.blastagram.user.service.UserService;

@RequestMapping("/blastagram")
@RestController
public class UserRestController {

	private UserService userService;
	
//	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	
	// 회원가입
	@PostMapping("/sign-up")
	public Map<String, String> signUp(
			@RequestParam("loginId") String loginId
//			 @RequestParam("email") String eamil
//			,@RequestParam("phoneNumber") String phoneNumber
			,@RequestParam("password") String password
			,@RequestParam("name") String name
			,@RequestParam("userId") String userId
			){
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(userService.addUser(loginId, password, name, userId)) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
			
		}
		return resultMap;
		
	}
	
	// 로그인
	// 입력한 아이디와 패스워드가 일치하면 로그인 성공하도록 
	@PostMapping("/login")
	public Map<String, String> login(
			@RequestParam("loginId") String loginId
//			 @RequestParam("email") String eamil
//			,@RequestParam("phoneNumber") String phoneNumber
//			,@RequestParam("userId") String userId
			,@RequestParam("password") String password
			){
		
		// result : success  
		Map<String, String> resultMap = new HashMap<>();
		
		User user = userService.selectLoginUser(loginId, password);
		
		if(user != null) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
			
		}
		return resultMap;
	}
	
	
	//중복확인 
	@GetMapping("/duplicate-id")
	public Map<String, Boolean> isDuplicateId(
			@RequestParam("loginId") String loginId
//			 @RequestParam("email") String eamil
//			,@RequestParam("phoneNumber") String phoneNumber
			){
		
		//			boolean isDuplicate = userService.isDuplicateId(loginId);
		
		// 중복 : {"isDuplicate":true}
		// 중복 아님 : {"isDuplicate":false}
		Map<String, Boolean> resultMap = new HashMap<>();
		
//		if(userService.isDuplicateId(loginId)) {
//			resultMap.put("isDuplicate", true);
//		} else {
//			resultMap.put("isDuplicate", false);
//			
//		}
		
		//		if(isDuplicate) {
		//			resultMap.put("isDuplicate", true);
		//		} else {
		//			resultMap.put("isDuplicate", false);
		//		}
		
		//		resultMap.put("isDuplicate", isDuplicate);
		resultMap.put("isDuplicate", userService.isDuplicateId(loginId));
		
		return resultMap;
	}
	
}
