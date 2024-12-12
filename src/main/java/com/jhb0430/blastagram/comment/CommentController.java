package com.jhb0430.blastagram.comment;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhb0430.blastagram.comment.service.CommentService;
import com.jhb0430.blastagram.like.service.LikeService;
import com.jhb0430.blastagram.post.domain.Post;
import com.jhb0430.blastagram.post.dto.CardDTO;
import com.jhb0430.blastagram.post.service.PostService;

@RequestMapping("/blastagram")
@Controller
public class CommentController {

	
	private PostService postService;
	private CommentService commentService;
	private LikeService likeService;
	
	
	public CommentController(PostService postService
			,CommentService commentService
			,LikeService likeService) {
		this.postService = postService;
		this.commentService = commentService;
		this.likeService = likeService;
	}
	
	
	
	
	@GetMapping("/comment-view")
	public String comment(@RequestParam("postId") int postId
			,Model model ) {
		
		Post post = postService.getPostById(postId);
		
		model.addAttribute("post",post);
		
		// 닉네임 받아오기 , 좋아요 받아오기 -> post의 cardList에 있음
		// 코멘트 목록 받아오기 
		
		List<CardDTO> cardList = postService.getPostList();	
		
		model.addAttribute("cardList",cardList);
		
	
		
		return "post/comment";
	}
	
}
