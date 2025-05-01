package com.woojin.app.websocket;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woojin.app.user.UserDAO;
import com.woojin.app.user.UserVO;

@Service
public class ChatService {
	
	@Autowired
	private ChatDAO chatDAO;
	
	public List<UserVO> getList(MessageVO messageVO)throws Exception{
		List<UserVO> list = chatDAO.getList();
		
		list.forEach(vo ->{
			if(LoginUsers.USERNAMES.contains(vo.getUsername())) {
				vo.setStatus(true);
			}
		});
		
		return chatDAO.getList();
	}
	
	public List<MessageVO> getChat(MessageVO messageVO) throws Exception{
		List<MessageVO> list = chatDAO.getChat(messageVO);
		if (list.size()==0) {
			Calendar ca = Calendar.getInstance();
			messageVO.setStatus("1");
			chatDAO.addChat(messageVO);
			list = chatDAO.getChat(messageVO);
		}
		
		return list;
	}

}