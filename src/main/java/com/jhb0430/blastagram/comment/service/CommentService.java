package com.jhb0430.blastagram.comment.service;

import org.springframework.stereotype.Service;

import com.jhb0430.blastagram.comment.domain.Comment;
import com.jhb0430.blastagram.comment.repository.CommentRepository;

@Service
public class CommentService {


	private CommentRepository commentRepository;
	
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
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
		
		

}
