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
	
	public int join(UserVO userVO, MultipartFile attach) throws Exception{
				String fileName = fileManager.fileSave(attach, path.concat("user"));
				userVO.setFileName(fileName);
				userVO.setOriName(attach.getOriginalFilename());
				System.out.println(userVO.getFileName());
			return userDAO.join(userVO);
	}
	
	public UserVO login(UserVO userVO) throws Exception{
		System.out.println(userVO.getFileName());
		return userDAO.login(userVO);
	}
	
}
