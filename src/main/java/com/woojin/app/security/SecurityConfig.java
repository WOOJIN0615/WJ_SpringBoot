package com.woojin.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.session.SessionManagementFilter;

import com.woojin.app.security.jwt.JwtAuthenticationFilter;
import com.woojin.app.security.jwt.JwtLoginFilter;
import com.woojin.app.security.jwt.JwtTokenManager;
import com.woojin.app.user.UserService;
import com.woojin.app.user.UserSocialService;
import com.woojin.app.user.UserVO;

@Configuration
@EnableWebSecurity//(debug = true)
public class SecurityConfig {
	
	@Autowired
	private AuthenticationConfiguration authenticationConfiguration;
	
	@Autowired
	private JwtTokenManager jwtTokenManager;

	
	//정적 자원들을 Securuty에서 제외
	@Bean
	WebSecurityCustomizer custom() {
		
		return (web)->{
			web.ignoring().requestMatchers("/css/**", "/js/**", "/images/**", "/vendor/**", "/img/**");
		};
	}
	
	//인증과 권한의 관한 설정
	@Bean
	SecurityFilterChain filter(HttpSecurity security) throws Exception {
		
		//다른 서버에서 오는 것을 허용
		//CORS 허용, Filter에서 사용 가능
		security.cors(cors-> cors.disable())
		.csrf(csrf-> csrf.disable())
		//권한 적용
		.authorizeHttpRequests(authorizeRequest->{
			authorizeRequest
			.requestMatchers("/notice/add", "/notice/update", "/notice/delete").hasRole("ADMIN")
			.requestMatchers("/user/myPage", "/user/update", "/user/logout").authenticated()
			.requestMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER")
			.anyRequest().permitAll();
		})
		
		.sessionManagement(session ->{
			session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		})
		
		//Form 관련 설정
		.formLogin(formLogin -> formLogin.disable())
		
		.httpBasic(httpBasic -> httpBasic.disable())
		
		.addFilter(new JwtLoginFilter(authenticationConfiguration.getAuthenticationManager(), jwtTokenManager))
		
		.addFilter(new JwtAuthenticationFilter(authenticationConfiguration.getAuthenticationManager(), jwtTokenManager))
		
		
		;
		return security.build();
	}
	

}
