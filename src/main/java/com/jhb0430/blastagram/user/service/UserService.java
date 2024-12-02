package com.jhb0430.blastagram.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhb0430.blastagram.common.MD5HashingEncoder;
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
			String loginId
			,String password
			,String name
			,String userId
			){
		
		//  패스워드 암호화과정
		String encodingPassword = MD5HashingEncoder.encode(password);
		
		int count = userRepository.insertUser(loginId, encodingPassword, name, userId);
		
		if(count == 1) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	// 로그인 (일치)
	public User selectLoginUser(
			String loginId
			,String password
			) {
		User user = userRepository.selectLoginUser(loginId, password);
	
		return user;
	}
	
			
	// 중복확인
			
	public boolean isDuplicateId(String loginId) {
		
		int count = userRepository.selectCountId(loginId);
		
		return count >= 1;
	}
	
	
	
}
