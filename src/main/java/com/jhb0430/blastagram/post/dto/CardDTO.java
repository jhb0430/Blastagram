package com.jhb0430.blastagram.post.dto;

import java.util.List;

import com.jhb0430.blastagram.comment.domain.Comment;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class CardDTO {

	
	private int postId;
	private int userId;
	
	// 게시글 정보, 내용
	private String contents;
	private String imagePath;
	
	// 화면에 표시될 사용자 정보. 로그인 아이디
	private String userName;
	
	private int likeCount;
	private boolean isLike;
	private List<Comment> commentList;
	
	private int commentCount;
}
