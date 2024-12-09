package com.jhb0430.blastagram.post.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jhb0430.blastagram.common.FileManager;
import com.jhb0430.blastagram.post.domain.Post;
import com.jhb0430.blastagram.post.repository.PostRepository;

@Service
public class PostService {

private PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public boolean addPost(int userId, String contents , MultipartFile file) {
	
		// 로그인 되어있다면 session.userId에 정보가 저장되어 있다.
		// 파일매니절... 
		
		String imagePath = FileManager.saveFile(userId, file);
		
		
		Post post = Post.builder()
				.userId(userId)
				.contents(contents)
				.imagePath(imagePath)
				.build();
		
		try {
			postRepository.save(post);
			
			return true;
		} catch(Exception e) {
			return false;
		}
		
	}
}
