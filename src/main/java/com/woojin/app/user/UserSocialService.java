package com.woojin.app.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.model.Model;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserSocialService extends DefaultOAuth2UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		// TODO Auto-generated method stub
		
		
//		log.info("Token : {}", userRequest.getAccessToken());
//		log.info("ID : {}", userRequest.getClientRegistration().getRegistrationId());
		
		String sns = userRequest.getClientRegistration().getRegistrationId();
		
		if (sns.toUpperCase().equals("KAKAO")) {
			return this.useKakao(userRequest);
		}
		
		return null;
	}
	
	private OAuth2User useKakao(OAuth2UserRequest request) throws OAuth2AuthenticationException {
		
		OAuth2User user=super.loadUser(request);
		Map<String, Object> map=(Map<String, Object>)user.getAttributes().get("properties");
		
		UserVO userVO = new UserVO();
		userVO.setAttributes(user.getAttributes());
		userVO.setUsername(user.getAttribute("id").toString());
		userVO.setFileName(map.get("thumbnail_image").toString());
		userVO.setName(map.get("nickname").toString());
		userVO.setAccessToken(request.getAccessToken().toString());
		userVO.setSns(request.getClientRegistration().getRegistrationId());
		
		
		List<RoleVO> list = new ArrayList<>();
		RoleVO roleVO = new RoleVO();
		list.add(roleVO);
		roleVO.setRoleName("ROLE_MEMBER");				
		
		userVO.setList(list);
		
		try {
			if (userDAO.detail(userVO)==null) {
				userDAO.join(userVO);
			}else {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userVO;
	}
	
	
}
