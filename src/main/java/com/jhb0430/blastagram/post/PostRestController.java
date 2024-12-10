package com.jhb0430.blastagram.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jhb0430.blastagram.post.repository.PostRepository;
import com.jhb0430.blastagram.post.service.PostService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/blastagram")
@RestController
public class PostRestController {


	private PostService postService;
	
	public PostRestController(PostService postService) {
		this.postService = postService;
	}
	
	
	@PostMapping("/post")
	public Map<String, String> createPost(
			@RequestParam("contents") String contents
			,@RequestParam("imageFile") MultipartFile file
			, HttpSession session
			){
		
		int userId = (Integer)session.getAttribute("userId");
/*
성공	{"result" : "success"}
실패	{"result" : "fail"}
  */
		Map<String, String> resultMap = new HashMap<>();
		
		if(postService.addPost(userId, contents, file)) {
			// true면
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
			
		}
		return resultMap;
		
		
	}
	
	
	
	
	
	
}
