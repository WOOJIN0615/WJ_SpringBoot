package com.woojin.app.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.woojin.app.user.UserVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class SecurityLogoutHandler implements LogoutHandler {
	
	@Value("${spring.security.oauth2.client.registration.kakao.client-secret}")
	private String adminKey;
	@Value("${spring.security.oauth2.client.registration.kakao.client-id}")
	private String restKey;
	@Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
	private String redirect;
	
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		log.info("Auth : {}", authentication);
		if (authentication instanceof OAuth2AuthenticationToken) {
			UserVO userVO = (UserVO)authentication.getPrincipal();
			
			if (userVO.getSns().toUpperCase().equals("KAKAO")) {
				this.kakaoLogout(userVO);
			}
		}
	}
	
	
	private void kakaoLogout(UserVO userVO) {
		log.info("user : {}", adminKey);
		log.info("id {}", userVO.getAttributes().get("id"));
		
		Map<String, Object> map = new HashMap<>();
		map.put("target_id_type", "user_id");
		map.put("target_id", userVO.getAttributes().get("id"));
		
		WebClient webClient = WebClient.create();
		log.info("token : {}", userVO.getAccessToken());
		Mono<String> res = webClient
				.post()
				.uri("https://kapi.kakao.com/v1/user/logout")
				.header("Authorization", "Bearer "+userVO.getAccessToken())
//				.header("Authorization", "KakaoAK "+adminKey)
				.bodyValue(map)
				.retrieve()
				.bodyToMono(String.class)
				;
		log.info("Result : {}", res.block());
		
	}

}
