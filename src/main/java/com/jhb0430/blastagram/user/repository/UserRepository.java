package com.jhb0430.blastagram.user.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jhb0430.blastagram.user.domain.User;

@Mapper
public interface UserRepository {

	
	public int insertUser(
			@Param("loginId")String loginId
			,@Param("password")String password
			,@Param("name")String name
			,@Param("userId")String userId
			);
	
	public User selectLoginUser(
			@Param("loginId")String loginId
			,@Param("password")String password
			);
	// domain 만들어줘야하지 않남 
	
	// 중복 조회 = 있으면 1 카운트
	public int selectCountId(@Param("loginId")String loginId);
	
	
}
