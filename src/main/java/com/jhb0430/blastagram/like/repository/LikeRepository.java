package com.jhb0430.blastagram.like.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhb0430.blastagram.like.domain.Like;

import jakarta.transaction.Transactional;

public interface LikeRepository extends JpaRepository<Like, Integer>{

	
	// select count(*) from `like` where `postId`;
	public int countByPostId(int postId);
	
//	SELECT count(*) FROM `like` WHERE `postId`= #{} AND `userId` = #{};
	
	public int countByPostIdAndUserId(int postId, int userId);

	
	public Optional<Like> findByPostIdAndUserId(int postId, int userId);
	
	// SELECT * FROM `like `WHERE `postId` = #{};` 
	// DELETE FROM `like `WHERE `postId` = #{};` 
	// 두개의 쿼리가 하나의 묶음으로 수행될 수 있도록 transaction 
	@Transactional
	public void deleteByPostId(int postId);
}
