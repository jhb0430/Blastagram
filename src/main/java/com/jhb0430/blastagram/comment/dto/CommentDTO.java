package com.jhb0430.blastagram.comment.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentDTO {

	private int postId;
	private int userId;
	
	// 게시글 정보, 내용
	private String comments;
	
	// 화면에 표시될 사용자 정보. 로그인 아이디
	private String userName;
	private String contents;
	private String imagePath;;
	
	
}
