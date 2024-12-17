package com.jhb0430.blastagram.interceptor;

import java.io.IOException;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class PermissionInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(
			HttpServletRequest request
			,HttpServletResponse response
			, Object handler
			) throws IOException{
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		String uri = request.getRequestURI();
		
		if(userId == null) {
			// ???아니... 반대로 생각하자....
			// //login-view sign-up-view가 아니면 아~~ 큰일났다 
			if(uri.startsWith("/");
		}
		
	}
	
	
}
