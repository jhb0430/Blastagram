package com.jhb0430.blastagram.comments;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/comment")
@RestController
public class CommentsRestController {

	
	// 코멘트 남겨서 저장하는 기능 
		@PostMapping("/create")
		public Map<String, String> commentPost(
				@RequestParam("comments") String comments
				, HttpSession session
				) {
			
			Map<String, String> resultMap = new HashMap<>();
			
		}
	
}
