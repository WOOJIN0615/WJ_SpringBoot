package com.woojin.app.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SecurityLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
			log.info("Login Success : {}", authentication);
			
			//request.setAttribute("", "");
		//	RequestDispatcher view=request.getRequestDispatcher("/WEB-INF/views/home.jsp");
			//view.forward(request, response);
			
			response.sendRedirect("/");
		
	}
	
}
