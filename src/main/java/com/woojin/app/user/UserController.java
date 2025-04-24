package com.woojin.app.user;

import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.woojin.app.files.FileManager;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/user/*")
@Slf4j
public class UserController {
	
	@Value("${menu.user.name}")
	private String name;
	
	@ModelAttribute("kind")
	private String getName() throws Exception{
		return this.name;
	}
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FileManager fileManager;
	
	@GetMapping("join")
	public String join(@ModelAttribute UserVO userVO) throws Exception{
		return "user/join";
	}
	
	@PostMapping("join")
	public String join(@Validated(JoinGroup.class) UserVO userVO, BindingResult result, MultipartFile attach) throws Exception{
		log.info("{}", userVO);
		log.info("Count : {}", result.getErrorCount());
		
		if (userService.errorCheck(userVO, result)) {
			return "user/join";
		}else {
			int join = userService.join(userVO, attach);
		}
		
		return "redirect:/";
	}
	
	@GetMapping("login")
	public String login(@AuthenticationPrincipal UserVO userVO) throws Exception{
		if (userVO != null) {
			return "redirect:/";
		}
		
		return "user/login";
	}
	
	@GetMapping("update")
	public void update(UserVO userVO, HttpSession session) throws Exception{
//		Enumeration<String> e = session.getAttributeNames();
//		while(e.hasMoreElements()) {
//		}
//		Object obj=session.getAttribute("SPRING_SECURITY_CONTEXT");
//		SecurityContextImpl impl = (SecurityContextImpl)obj;
//		
//		Authentication authen = impl.getAuthentication();
		//log.info("{}", authen);
	}
	
	@PostMapping("update")
	public void update(@Validated(UpdateGroup.class) UserVO userVO, Model model) throws Exception{
	}
	
	@GetMapping("myPage")
	public void myPage() {
		
	}
	
}
