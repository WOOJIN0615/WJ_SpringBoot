package com.woojin.app.files;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Component
public class FileManager {
	
	
	public String fileSave(MultipartFile attach, String path) throws Exception{
		
		File file = new File(path);
		
		if (!file.exists()) {
			file.mkdirs();
		}
		
		//1. 어떤 이름으로 저장할 것인가
		String fileName=UUID.randomUUID().toString();
		
		//2. fileName에 확장자 추가
		fileName=fileName.concat("_").concat(attach.getOriginalFilename());
		
		//3. HDD에 저장
		file = new File(file, fileName);
		//FileCopyUtils.copy(attach.getBytes(), file);
		attach.transferTo(file);
		
		return fileName;
	}
	
	public void fileDelete() throws Exception{
		
	}

}
