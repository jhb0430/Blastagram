package com.jhb0430.blastagram.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhb0430.blastagram.post.domain.Post;

public interface PostRepository extends JpaRepository<Post,Integer> {

	 public List<Post> findByUserIdOrderByIdDesc(int userId);
	 
	 public List<Post> findAllByOrderByIdDesc();
	 
	 
}
