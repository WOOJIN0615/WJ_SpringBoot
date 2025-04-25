package com.woojin.app.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;

import com.woojin.app.user.UserVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class SecurityLogoutSuccessHandler implements LogoutSuccessHandler {
	
	@Value("${spring.security.oauth2.client.registration.kakao.client-secret}")
	private String adminKey;
	@Value("${spring.security.oauth2.client.registration.kakao.client-id}")
	private String restKey;
	@Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
	private String redirect;
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		if (authentication instanceof OAuth2AuthenticationToken) {
			UserVO userVO = (UserVO)authentication.getPrincipal();
			
			if (userVO.getSns().toUpperCase().equals("KAKAO")) {
				this.kakaoLogout(userVO);
			}
		}
	}
	
	private void kakaoLogout(UserVO userVO) {
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("target_id_type", "user_id");
		map.put("target_id", userVO.getAttributes().get("id"));
		
		WebClient webClient = WebClient.create();
		
		Mono<String> res = webClient
				.get()
				.uri("https://kauth.kakao.com/oauth/logout?client_id=18ba35566fcc3014ad5fc5488b4f152d&logout_redirect_uri=http://localhost")
				.retrieve()
				.bodyToMono(String.class)	
				;
		
	}
	

	
	
}
