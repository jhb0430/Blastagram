package com.jhb0430.blastagram.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/blastagram")
@Controller
public class UserController {

	
	@GetMapping("/sign-up-view")
	 public String signUp() {
		 return "user/join";
	 }
	
	@GetMapping("/login-view")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		
		
		return "redirect:/blastagram/login-view";
		
	}
	
	
	
}
