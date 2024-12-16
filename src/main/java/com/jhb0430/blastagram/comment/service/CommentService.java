package com.jhb0430.blastagram.comment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jhb0430.blastagram.comment.domain.Comment;
import com.jhb0430.blastagram.comment.dto.CommentDTO;
import com.jhb0430.blastagram.comment.repository.CommentRepository;
import com.jhb0430.blastagram.like.service.LikeService;
import com.jhb0430.blastagram.user.domain.User;
import com.jhb0430.blastagram.user.service.UserService;

@Service
public class CommentService {


	private CommentRepository commentRepository;
	
	private UserService userService;
	private LikeService likeService;
	
	public CommentService(CommentRepository commentRepository 
			, UserService userService
			,LikeService likeService) {
		this.commentRepository = commentRepository;
		this.userService = userService;
		this.likeService = likeService;
	}
	
	
	
	// 코멘트 저장하는 기능 
	
		public boolean addComments(int postId, int userId, String comments) {
			// 저장 했으면 못했으면 
			
		Comment comment = Comment.builder()
							.postId(postId)
							.userId(userId)
							.comments(comments)
							.build();
			
		try {
			
			commentRepository.save(comment);
			return true;
		} catch(Exception e) {
			return false;
		}
			
		}
		
		
	
		// 
		public List<CommentDTO> getCommentList(int postId){
//			public List<Comment>getCommentList(int postId){
			
			List<Comment> commentList =  commentRepository.findByPostId(postId);
			
			List<CommentDTO> commentDTOList = new ArrayList<>();
			
			for(Comment comment:commentList) {
				
				int userId= comment.getUserId();
				User user = userService.getUserById(userId);
				int commentCount = commentRepository.countByPostId(postId);
				int likeCount = likeService.getLikeCount(postId);
				
				
				CommentDTO commentDTO = CommentDTO.builder()
												.commentId(comment.getId())
												.userId(userId)
												.userName(user.getUserName())
												.comments(comment.getComments())
												.commentCount(commentCount)
												.likeCount(likeCount)
												.build();
				
				commentDTOList.add(commentDTO);
				
			}
			return commentDTOList;
			
//			return commentRepository.findByPostId(postId);
		}
		
		
		
		
		// 댓글 갯수 
		public int getCommentCount(int postId){
			
			return  commentRepository.countByPostId(postId);
		}
		
		
		// 댓글 삭제
		// 있을수도 없을수도... 있다... 
		public void deleteComment(int postId) {
			
			commentRepository.deleteByPostId(postId);
			
		}

}
