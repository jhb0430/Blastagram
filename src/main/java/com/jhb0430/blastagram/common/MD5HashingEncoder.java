package com.jhb0430.blastagram.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

public class MD5HashingEncoder {

	
	// md5를 통한 암호화 기능 
	
	public static String encode(String message) {
		
		String result="";
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("md5");
		
			byte[] bytes = message.getBytes();
		
			byte[] digest = messageDigest.digest();
			
			for (int i = 0; i < digest.length; i++) {
				
				result += Integer.toHexString(digest[i] & 0xff);
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			
			return null;
		}
		return result;
	}
	
}
