package com.jhb0430.blastagram.like.service;

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
	
}
