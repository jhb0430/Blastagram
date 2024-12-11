package com.jhb0430.blastagram.comments;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommentsController {

	
	@GetMapping("/comment-view")
	public String comment(Model model ) {
		return "post/comment";
	}
	
}
