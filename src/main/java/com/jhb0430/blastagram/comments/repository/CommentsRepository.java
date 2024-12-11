package com.jhb0430.blastagram.comments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhb0430.blastagram.comments.domain.Comments;


public interface CommentsRepository extends JpaRepository<Comments,Integer> {

	public List<Comments> findAllByOrderById();
	
}
