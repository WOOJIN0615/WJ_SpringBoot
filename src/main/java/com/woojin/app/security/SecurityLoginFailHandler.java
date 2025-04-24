package com.woojin.app.security;

import java.io.IOException;
import java.net.URLEncoder;

import javax.security.auth.login.AccountExpiredException;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SecurityLoginFailHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
			String message="";
			log.info("Failure : {}", exception);
			
			if (exception instanceof BadCredentialsException) {
				
			}//else if(exception instanceof AccountExpiredException) {
				
			else if (exception instanceof DisabledException) {
				
			}else if(exception instanceof LockedException) {
				
			}else if (exception instanceof CredentialsExpiredException) {
				
			}
			
			message=exception.getMessage();
			message="user.login.password";
			message = URLEncoder.encode(message, "UTF-8");
			
			//response.sendRedirect("/user/login?message=".concat(message));
			
			request.setAttribute("code", message);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/user/login.jsp");
			view.forward(request, response);
			
			
	}
	
	
}
