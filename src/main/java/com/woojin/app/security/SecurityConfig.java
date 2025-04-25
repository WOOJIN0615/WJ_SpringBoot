package com.woojin.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.session.SessionManagementFilter;

import com.woojin.app.user.UserService;
import com.woojin.app.user.UserSocialService;
import com.woojin.app.user.UserVO;

@Configuration
@EnableWebSecurity//(debug = true)
public class SecurityConfig {
	
	@Autowired
	private SecurityLogoutHandler logoutHandler;
	@Autowired
	private SecurityLoginSuccessHandler loginHandler;
	@Autowired
	private SecurityLoginFailHandler failureHandler;
	@Autowired
	private UserService userService;
	@Autowired
	private UserSocialService userSocial;
	@Autowired
	private SecurityLogoutSuccessHandler logoutSuccess;
	
	@Bean
	HttpFirewall firewall() {
		return new DefaultHttpFirewall();
	}
	
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
		
		//Form 관련 설정
		.formLogin(formLogin ->{
			formLogin
			.loginPage("/user/login")
			//파라미터 이름을 지정할 수 있음.
			//.usernameParameter("userID")
			//.passwordParameter("pw")
			//.defaultSuccessUrl("/")
			.successHandler(loginHandler)
			.failureHandler(failureHandler)
			//.failureUrl("/user/login")
			.permitAll();
		})
		
		//Logout 관련 설정
		.logout(logout ->{
			logout
			.logoutUrl("/user/logout")
			.logoutSuccessHandler(logoutSuccess)
			.addLogoutHandler(logoutHandler)
			.invalidateHttpSession(true)
			.permitAll();
		})
		
		.rememberMe(rememberMe ->{
			rememberMe
			.rememberMeParameter("remember-me")
			.tokenValiditySeconds(60) //사용자 쿠키에 얼마동안 저장할 것인가
			.key("rememberKey")
			.userDetailsService(userService)
			.authenticationSuccessHandler(loginHandler)
			.useSecureCookie(false);
		})
		
		.sessionManagement(s->{
			s.invalidSessionUrl("/")
			.maximumSessions(1)
			.maxSessionsPreventsLogin(true)
			.expiredUrl("/");
			s.sessionFixation().changeSessionId();
		})
		
		.oauth2Login(oauth2Login ->{
			oauth2Login
			.userInfoEndpoint(use->{
				use.userService(userSocial);
			});
		})
		
		
		
		;
		return security.build();
	}
	

}
