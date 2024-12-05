package com.jhb0430.blastagram.user.domain;

import java.time.LocalDateTime;

public class User {

//	`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,			
//	`loginId` VARCHAR(64) NOT NULL,				
//	`password` VARCHAR(64) NOT NULL,	
//    `email` VARCHAR(64) NOT NULL,
//	`name` VARCHAR(64) NOT NULL,				
//	`phoneNumber` VARCHAR(64) NOT NULL,					
//	`createdAt` timestamp DEFAULT CURRENT_TIMESTAMP,				
//	`updatedAt` timestamp DEFAULT CURRENT_TIMESTAMP	
	
	private int id;
//	private String loginId;
	private String password;
	private String email;
	private String name;
	private String phoneNumber;
	private String userId;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public String getLoginId() {
//		return loginId;
//	}
//	public void setLoginId(String loginId) {
//		this.loginId = loginId;
//	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
	
}
