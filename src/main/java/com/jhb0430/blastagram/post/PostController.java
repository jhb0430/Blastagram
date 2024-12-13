package com.jhb0430.blastagram.post;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhb0430.blastagram.post.dto.CardDTO;
import com.jhb0430.blastagram.post.service.PostService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/blastagram")
@Controller
public class PostController {

	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	
	
	@GetMapping("/main-view")
	 public String timeLine(Model model
			 , HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
//		List<Post> postList = postService.getPostList();
		List<CardDTO> cardList = postService.getPostList(userId);
		
		model.addAttribute("cardList",cardList);
		
		 return "post/timeline";
	 }

	
	
	
	
	@GetMapping("/post-view")
	public String post(Model model
			 , HttpSession session
			 ) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		List<CardDTO> cardList = postService.getPostList(userId);
		
		model.addAttribute("cardList",cardList);
		
		return "post/post";
	}
	
	
	
}
