package com.jhb0430.blastagram.comment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jhb0430.blastagram.post.service.PostService;

@Controller
public class CommentController {

	
	private PostService postService;
	public CommentController(PostService postService) {
		this.postService = postService;
	}
	
	
	@GetMapping("/comment-view")
	public String comment(Model model ) {
		
//		List<CardDTO> card = postService.getPostList();
		
		return "post/comment";
	}
	
}
