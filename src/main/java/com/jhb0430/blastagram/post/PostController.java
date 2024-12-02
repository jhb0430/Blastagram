package com.jhb0430.blastagram.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/blastagram")
@Controller
public class PostController {

	@GetMapping("/timeline")
	 public String timelinePost() {
		 return "post/timeline";
	 }
	
	@GetMapping("/comment")
	public String comment() {
		return "post/comment";
	}
	
	
	
}
