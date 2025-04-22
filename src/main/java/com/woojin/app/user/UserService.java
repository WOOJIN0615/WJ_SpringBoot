package com.woojin.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.woojin.app.files.FileManager;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private FileManager fileManager;
	@Value("${app.files.base}")
	private String path;
	@Value("${menu.user.name}")
	private String kind;
	
	public int join(UserVO userVO, MultipartFile attach) throws Exception{
				String fileName = fileManager.fileSave(attach, path.concat(kind));
				userVO.setFileName(fileName);
				userVO.setOriName(attach.getOriginalFilename());
			return userDAO.join(userVO);
	}
	
	public UserVO login(UserVO userVO) throws Exception{
		userVO = userDAO.login(userVO);
		if(userVO != null) {
			if(userVO.getPassword().equals(userVO.getPassword())) {
				return userVO;
			}
			userVO = null;
		}
		return userVO;
	}
	
}
