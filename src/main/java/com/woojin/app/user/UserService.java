package com.woojin.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.woojin.app.files.FileManager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService implements UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			UserVO userVO = new UserVO();
			userVO.setUsername(username);
			try {
				userVO = userDAO.detail(userVO);
				log.info("{}", userVO);
			} catch (Exception e) {
				e.printStackTrace();
				userVO = null;
			}
		return userVO;
	}
	
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private FileManager fileManager;
	@Value("${app.files.base}")
	private String path;
	@Value("${menu.user.name}")
	private String kind;
	
	public boolean errorCheck(UserVO userVO, BindingResult result) throws Exception{
		boolean check = false;
		
		check = result.hasErrors();
		
		if (!userVO.getPassword().equals(userVO.getPasswordCheck())) {
			check=true;
			result.rejectValue("passwordCheck", "NotEqual.password");
		}
		
		UserVO checkVO = userDAO.detail(userVO);
		if (checkVO != null) {
			check=true;
			result.rejectValue("username", "NotEqual.username");
		}
		
		return check;
	}
	
	public int join(UserVO userVO, MultipartFile attach) throws Exception{
				String fileName = fileManager.fileSave(attach, path.concat(kind));
				userVO.setFileName(fileName);
				userVO.setOriName(attach.getOriginalFilename());
				userVO.setPassword(encoder.encode(userVO.getPassword()));
			return userDAO.join(userVO);
	}
	
	public UserVO login(UserVO userVO) throws Exception{
		userVO = userDAO.detail(userVO);
		if(userVO != null) {
			if(userVO.getPassword().equals(userVO.getPassword())) {
				log.info("{}", userVO);
				return userVO;
			}
			userVO = null;
		}
		return userVO;
	}
	
	public UserVO myPage(UserVO userVO) throws Exception{
		userVO = userDAO.detail(userVO);
		
		return userVO;
	}
	
}
