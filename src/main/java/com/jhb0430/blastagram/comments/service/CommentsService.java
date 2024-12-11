package com.jhb0430.blastagram.comments.service;

import com.jhb0430.blastagram.comments.domain.Comments;
import com.jhb0430.blastagram.comments.repository.CommentsRepository;

public class CommentsService {

	private CommentsRepository commentsRepository;
	public CommentsService(CommentsRepository commentsRepository) {
		this.commentsRepository = commentsRepository;
	}
	
	
	
	// 코멘트 저장하는 기능 
	
		public boolean addComments(String comments) {
			// 저장 했으면 못했으면 
			
		Comments comment = Comments.builder()
							.comments(comments)
							.build();
			
		try {
			
			commentsRepository.save(comment);
			return true;
		} catch(Exception e) {
			return false;
		}
			
		}
		

}
