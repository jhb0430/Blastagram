package com.jhb0430.blastagram.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/blastagram")
@Controller
public class PostController {

	@GetMapping("/main-view")
	 public String timelinePost() {
		 return "post/timeline";
	 }
	
	@GetMapping("/comment-view")
	public String comment() {
		return "post/comment";
	}
	
	
	@GetMapping("/post-view")
	public String post() {
		return "post/post";
	}
	
	
	
}
