package com.jhb0430.blastagram.comments;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentsController {

	
	@GetMapping("/comment-view")
	public String comment() {
		return "post/comment";
	}
	
}
