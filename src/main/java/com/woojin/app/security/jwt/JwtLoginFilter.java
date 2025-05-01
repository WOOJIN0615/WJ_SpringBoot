package com.woojin.app.security.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {
	

	private JwtTokenManager jwtTokenManager;
	private AuthenticationManager authenticationManager;
	
	public JwtLoginFilter(AuthenticationManager authenticationManager, JwtTokenManager jwtTokenManager) {
		this.authenticationManager=authenticationManager;
		this.jwtTokenManager=jwtTokenManager;
		this.setFilterProcessesUrl("/users/login");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
			log.info("로그인 시도");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			UsernamePasswordAuthenticationToken authenticationToken;
			authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
			
			Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
			System.out.println(authentication);
		return authentication;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("authResult : {}", authResult);
		
		String token = jwtTokenManager.createToken(authResult);
		log.info("Token : {}", token);
		
		Cookie cookie = new Cookie("accessToken", token);
		cookie.setMaxAge(120);
		cookie.setPath("/");
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
		
		response.sendRedirect("/");
		
		super.successfulAuthentication(request, response, chain, authResult);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("Fail : {}", failed);
		
		response.sendRedirect("/user/login");
	}
	
	
	
	
	
	
}
