package com.jhb0430.blastagram.like.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhb0430.blastagram.like.domain.Like;

public interface LikeRepository extends JpaRepository<Like, Integer>{

	
	// select count(*) from `like` where `postId`;
	public int countByPostId(int postId);
	
//	SELECT count(*) FROM `like` WHERE `postId`= #{} AND `userId` = #{};
	
	public int countByPostIdAndUserId(int postId, int userId);
	
}
