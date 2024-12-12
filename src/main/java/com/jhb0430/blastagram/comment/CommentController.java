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
	public String comment(@RequestParam int postId
			,Model model ) {
		
		Post post = postService.getPostById(postId);
		
		model.addAttribute("post",post);
		
		// 닉네임 받아오기 , 좋아요 받아오기 -> post의 cardList에 있음
		// 코멘트 목록 받아오기 
		
		List<CardDTO> cardList = postService.getPostList(postId);	
		// 전체 리스트에서 유저 정보 매칭되는거... 
		// 여기서는 하나의 게시글에 대한 cardDTO 단독으로 얻어오는 기능 만들어줘야함...  코멘트뷰용 데이터
		model.addAttribute("cardList",cardList);
		
	
		
		return "post/comment";
	}
	
}
