package com.woojin.app.user;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class UserDAOTest {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserDAO userDAO;

	@Test
	void testJoin() throws Exception {
		UserVO userVO = new UserVO();
		String pw = "testtest";
		
		userVO.setUsername("admin2");
		userVO.setPassword(encoder.encode(pw));
		userVO.setName("admin");
		userVO.setEmail("admin@admin.com");
		userVO.setAccountNonExpired(true);
		userVO.setAccountNonLocked(true);
		userVO.setCredentialsNonExpired(true);
		userVO.setEnabled(true);
		
		userDAO.join(userVO);
		
	}

}
