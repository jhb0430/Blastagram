package com.jhb0430.blastagram.post.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jhb0430.blastagram.comment.domain.Comment;
import com.jhb0430.blastagram.comment.dto.CommentDTO;
import com.jhb0430.blastagram.comment.service.CommentService;
import com.jhb0430.blastagram.common.FileManager;
import com.jhb0430.blastagram.like.service.LikeService;
import com.jhb0430.blastagram.post.domain.Post;
import com.jhb0430.blastagram.post.dto.CardDTO;
import com.jhb0430.blastagram.post.repository.PostRepository;
import com.jhb0430.blastagram.user.domain.User;
import com.jhb0430.blastagram.user.service.UserService;

@Service
public class PostService {

private PostRepository postRepository;
private UserService userService;
private LikeService likeService;
private CommentService commentService;
	
	public PostService(PostRepository postRepository
			,UserService userService
			,LikeService likeService
			,CommentService commentService) {
		
		this.postRepository = postRepository;
		this.userService = userService;
		this.likeService = likeService;
		this.commentService = commentService;
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
	
	public List<CardDTO> getPostList(int loginUserId){
		
		// 조회된 게시글 마다 작성자의 로그인 아이디 얻어오기
		List<Post> postList = postRepository.findAllByOrderByIdDesc();
		
		List<CardDTO> cardList = new ArrayList<>();
		
		for(Post post:postList) {
			int userId = post.getUserId();
			// userService를 통해 사용자 정보 join
			User user = userService.getUserById(userId);
			
			int commentCount = commentService.getCommentCount(post.getId());
			
			int likeCount = likeService.getLikeCount(post.getId());
													// userId= 로그인한 사용자 정보.
			
			boolean isLike = likeService.isLike(post.getId(),loginUserId );		
			
			List<CommentDTO> commentList = commentService.getCommentList(post.getId());
			
			CardDTO card = CardDTO.builder()
									.postId(post.getId())
									.userId(userId)
									.contents(post.getContents())
									.imagePath(post.getImagePath())
									.userName(user.getUserName())
									.likeCount(likeCount)
									.isLike(isLike)
									.commentDTOList(commentList)
									.commentCount(commentCount)
									.build();
							
			cardList.add(card);
		}
		
		
//		return postRepository.findAllByOrderByIdDesc();
		return cardList;
	}
	
	// id를 입력하면  정보 찾아오는 ... 
		 public CardDTO getPostById(int id) {
		        
			 Optional<Post> optionalPost = postRepository.findById(id);
			 // DTO...기능 만들어준다 -> 꼭 리스트 형태가 아니어도 됨...!!! 
//			 return postList;
			 Post post = optionalPost.orElse(null);
			 
				int userId = post.getUserId();
				User user = userService.getUserById(userId);
				int likeCount = likeService.getLikeCount(post.getId());
				boolean isLike = likeService.isLike(post.getId(), id); 
				List<CommentDTO> commentList = commentService.getCommentList(post.getId());
				int commentCount = commentService.getCommentCount(post.getId());
			
				CardDTO card = CardDTO.builder().postId(post.getId())
						 .userId(userId)
						 .contents(post.getContents())
						 .imagePath(post.getImagePath())
						 .userName(user.getUserName())
						 .likeCount(likeCount)
						 .isLike(isLike)
						 .commentDTOList(commentList)
						 .commentCount(commentCount)
						 .build();
			 
				return card;
				
				
		    }
		
		 // 로그인 한 사용자만 지울 수 있게 
		 // 사진, 게시물 삭제 
		 public boolean deletePost(int id, int userId) {
			
			 Optional<Post> optionalPost = postRepository.findById(id);
			 
			 if(optionalPost.isPresent()) {
				 Post post = optionalPost.get();
				 
				 if(post.getUserId() == userId) {
					 postRepository.delete(post);
				 }
				 
				 return true;
			 } else {
				 return false;
			 }
		 }
	
	
	
}
