package com.jhb0430.blastagram.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/blastagram")
@Controller
public class UserController {

	
	@GetMapping("/sign-up")
	 public String input() {
		 return "user/join";
	 }
}
