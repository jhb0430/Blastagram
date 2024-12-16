package com.jhb0430.blastagram.comment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jhb0430.blastagram.comment.service.CommentService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/comment")
@RestController
public class CommentRestController {

	
	private CommentService commentService;
	
	public CommentRestController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	
	
	// 코멘트 남겨서 저장하는 기능 
		@PostMapping("/create")
		public Map<String, String> createComments(
				@RequestParam("postId") int postId
				,@RequestParam("comments") String comments
				, HttpSession session
				) {
			
			int userId = (Integer)session.getAttribute("userId");
			
			
			Map<String, String> resultMap = new HashMap<>();
			
			if(commentService.addComments(postId, userId, comments)) {
				resultMap.put("result", "success");
			} else {
				resultMap.put("result", "fail");
			}
			return resultMap;
			
		}
		
		// 코멘트 삭제하는 기능 
		
		@DeleteMapping("/delete")
		public void deleteComment(
				@RequestParam("postId") int postId){
			
			commentService.deleteComment(postId);
		}
		
	
}
