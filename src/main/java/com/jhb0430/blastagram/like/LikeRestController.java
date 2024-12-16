package com.jhb0430.blastagram.like;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jhb0430.blastagram.like.service.LikeService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@RestController
public class LikeRestController {

	private LikeService likeService;
		
		public LikeRestController(LikeService likeService) {
			this.likeService = likeService;
		}
	
	
	// 좋아요 저장 기능 
	
	@PostMapping("/like")
	public Map<String, String>like(
			@RequestParam("postId") int postId
			, HttpSession session
			){
		
		int userId = (Integer)session.getAttribute("userId");
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(likeService.addLike(postId, userId)) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
		
		
	}
	
	// 좋아요 삭제 기능 
	public Map<String, String> deleteLike(
			@RequestParam("postId") int postId
			,@RequestParam("userId") int userId
			,HttpSession session){
		
		int userUd = (Integer)session.getAttribute("userId");
		
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(likeService.deleteLike(postId, userId)) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
			
		}
		
		return resultMap;
	}
	
	
	
	
	
}
