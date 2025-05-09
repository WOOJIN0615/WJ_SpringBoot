package com.woojin.app.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.woojin.app.user.UserVO;
import com.woojin.app.websocket.ChatDAO;
import com.woojin.app.websocket.MessageVO;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@Autowired
	private ChatDAO chatDAO;

	@GetMapping("/")
	public String home(@AuthenticationPrincipal UserVO userVO, HttpSession session) throws Exception {
		if (userVO != null) {
			MessageVO messageVO =  new MessageVO();
			messageVO.setReceiver(userVO.getUsername());
			List<MessageVO> list = chatDAO.getMemoList(messageVO);
			session.setAttribute("memoList", list);
		}
		//log.warn("home");
		if (userVO == null) {
			throw new NullPointerException();
		}
		return "home";
	}

}