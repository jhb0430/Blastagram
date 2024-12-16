package com.jhb0430.blastagram.like.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jhb0430.blastagram.like.domain.Like;
import com.jhb0430.blastagram.like.repository.LikeRepository;

@Service
public class LikeService {

	private LikeRepository likeRepository;
	
	public LikeService(LikeRepository likeRepository) {
		this.likeRepository = likeRepository;
	}
	
	public boolean addLike(int postId, int userId){
		
		Like like = Like.builder()
						.postId(postId)
						.userId(userId)
						.build();
		
		try {
			likeRepository.save(like);
			return true;
		} catch(Exception e) {
			return false;
		}
			
	}
	
	
		// 좋아요 개수 count 기능
	public int getLikeCount(int postId){
			
		return  likeRepository.countByPostId(postId);
	}

	
	// 어떤 게시글에 누가 좋아요를 했냐 안했냐
	
	public boolean isLike(int postId, int userId) {
		
		int count = likeRepository.countByPostIdAndUserId(postId, userId);
		
		if(count > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	// 좋아요 삭제 
	public boolean deleteLike(int postId, int userId) {
		
		Optional<Like> optionalLike = likeRepository.findByPostIdAndUserId(postId, userId);
		
		if(optionalLike.isPresent()) {
			Like like = optionalLike.get();
			
			likeRepository.delete(like);
			
			return true;
		} else {
			return false;
		}
		
		
		
	
	
	}
	
}


