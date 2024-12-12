package com.jhb0430.blastagram.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhb0430.blastagram.comment.domain.Comment;


public interface CommentRepository extends JpaRepository<Comment,Integer> {

	// WHERE `postId` = #{}
	public List<Comment> findByPostId(int postId);
	
	// 코멘트 갯수 출력
	// select count(*) from `comment` where `id`; ?? 포스트 별 코멘트 갯수...
		public int countByPostId(int postId);
	
}
