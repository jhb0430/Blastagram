package com.jhb0430.blastagram.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhb0430.blastagram.comment.domain.Comment;


public interface CommentRepository extends JpaRepository<Comment,Integer> {

	public List<Comment> findAllByOrderById();
	
}
