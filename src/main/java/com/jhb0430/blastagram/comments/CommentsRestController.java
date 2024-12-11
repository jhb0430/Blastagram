package com.jhb0430.blastagram.comments;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jhb0430.blastagram.comments.service.CommentsService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/comment")
@RestController
public class CommentsRestController {

	
	private CommentsService commentsService;
	
	public CommentsRestController(CommentsService commentsService) {
		this.commentsService = commentsService;
	}
	
	
	
	// 코멘트 남겨서 저장하는 기능 
		@PostMapping("/create")
		public Map<String, String> createComments(
				@RequestParam("comments") String comments
				, HttpSession session
				) {
			
			int userId = (Integer)session.getAttribute("userId");
			
			
			Map<String, String> resultMap = new HashMap<>();
			
			if(commentsService.addComments(comments)) {
				resultMap.put("result", "success");
			} else {
				resultMap.put("result", "success");
			}
			return resultMap;
			
		}
	
}
