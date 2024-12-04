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
		
		String email;
		String phoneNumber;
		
		if (loginId.contains("@")) {
			email = loginId;
			phoneNumber = null;
		} else {
			phoneNumber = loginId;
			email = null;
		}
		
		
		
		
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
//			,String userId
			,String password
			) {
		
		
		
		
		String email;
		String phoneNumber; // matches() 메서드 활용.
		String userId;
		
		boolean isNumeric = loginId.matches("\\d+");
		
		if (loginId.contains("@")) {
			email = loginId;
			phoneNumber = null;
			userId = null;
		} else if (isNumeric) {
			phoneNumber = loginId;
			email = null;;
			userId = null;
		} else {
			phoneNumber = null;
			email = null;;
			userId = loginId;
		}
		
		
		String encodingPassword = SHA256HashingEncoder.encode(password);
		
		
		User user = userRepository.selectLoginUser(email, phoneNumber, userId, encodingPassword);
	
		return user;
	}
	
			
	// 중복확인
			
	public boolean isDuplicateId( String loginId
//								String email
//								,String phoneNumber
								) {
		
		String email;
		String phoneNumber;
		
		if (loginId.contains("@")) {
			email = loginId;
			phoneNumber = null;
		} else {
			phoneNumber = loginId;
			email = null;
		}
		
		int count = userRepository.selectCountId(email, phoneNumber);
		
		/*
		 *  if(count > 0){
		 * 	 	return true;
		 *  } else {
		 *  	return false;
		 *  }
		 * 
		 * */
//		return count >= 1;
			if(count > 0){
				return true;
			 } else {
				return false;
			 }
		
		}
	
	
	
}
