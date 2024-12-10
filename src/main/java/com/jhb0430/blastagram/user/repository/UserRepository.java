package com.jhb0430.blastagram.user.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jhb0430.blastagram.user.domain.User;

@Mapper
public interface UserRepository {

	public int insertUser(
//			@Param("loginId")String loginId
			@Param("email")String email
			,@Param("phoneNumber")String phoneNumber
			,@Param("password")String password
			,@Param("name")String name
			,@Param("userName")String userName
			);
	
	// domain 만들어줘야하지 않남 
	public User selectLoginUser(
			@Param("email")String email
			,@Param("phoneNumber")String phoneNumber
			,@Param("userName")String userName
			,@Param("password")String password
			);
	
	// 중복 조회 = 있으면 1 카운트
	public int selectCountId(
			@Param("email")String email
			,@Param("phoneNumber")String phoneNumber
			);

	
	
	public User selectUserById(@Param("id") int id);
	
	
}

