package com.jhb0430.blastagram.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhb0430.blastagram.common.MD5HashingEncoder;
import com.jhb0430.blastagram.common.SHA256HashingEncoder;
import com.jhb0430.blastagram.user.domain.User;
import com.jhb0430.blastagram.user.repository.UserRepository;

@Service
public class UserService {

	
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	// 행 삽입
	
	public boolean addUser(
//			String email
//			,String phoneNumber
			String loginId 
			,String password
			,String name
			,String userId
			){
		
		//  패스워드 암호화과정
		String encodingPassword = SHA256HashingEncoder.encode(password);
		
		int count =  userRepository.insertUser(email, phoneNumber, encodingPassword, name, userId);
		
		if(count == 1) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	// 로그인 (일치)
	public User selectLoginUser(
//			String email
//			,String phoneNumber
			String loginId
			,String userId
			,String password
			) {
		User user = userRepository.selectLoginUser(email, phoneNumber, userId, password);
	
		return user;
	}
	
			
	// 중복확인
			
	public boolean isDuplicateId(String email
								,String phoneNumber
								) {
		
		int count = userRepository.selectCountId(email, phoneNumber);
		
		/*
		 *  if(count > 0){
		 * 	 	return true;
		 *  } else {
		 *  	return false;
		 *  }
		 * 
		 * */
		return count >= 1;
		}
	
	
	
}
