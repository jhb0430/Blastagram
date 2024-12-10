package com.jhb0430.blastagram.post.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jhb0430.blastagram.common.FileManager;
import com.jhb0430.blastagram.post.domain.Post;
import com.jhb0430.blastagram.post.dto.CardDTO;
import com.jhb0430.blastagram.post.repository.PostRepository;
import com.jhb0430.blastagram.user.domain.User;
import com.jhb0430.blastagram.user.service.UserService;

@Service
public class PostService {

private PostRepository postRepository;
private UserService userService;
	
	public PostService(PostRepository postRepository,UserService userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}
	
	
	
	
	public boolean addPost(int userId, String contents , MultipartFile file) {
	
		// 로그인 되어있다면 session.userId에 정보가 저장되어 있다.
		// 파일매니절... 
		// 클라이언트가 접근할 수 있는 경로 리턴
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
	
	public List<CardDTO> getPostList(){
		
		// 조회된 게시글 마다 작성자의 로그인 아이디 얻어오기
		List<Post> postList = postRepository.findAllByOrderByIdDesc();
		
		List<CardDTO> cardList = new ArrayList<>();
		
		for(Post post:postList) {
			int userId = post.getUserId();
			// userService를 통해 사용자 정보 join
			User user = userService.getUserById(userId);
			
			CardDTO card = CardDTO.builder()
									.postId(post.getId())
									.userId(userId)
									.contents(post.getContents())
									.imagePath(post.getImagePath())
									.userName(user.getUserName())
									.build();
							
			cardList.add(card);
		}
		
		
//		return postRepository.findAllByOrderByIdDesc();
		return cardList;
	}
	
	
	
	
}
