package com.woojin.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.woojin.app.files.FileManager;


import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user/*")
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
	public String join() throws Exception{
		return "user/join";
	}
	
	@PostMapping("join")
	public String join(UserVO userVO, @RequestParam("attach") MultipartFile attach) throws Exception{
		int result = userService.join(userVO, attach);
		
		return "redirect:/";
	}
	
	@GetMapping("login")
	public void login() throws Exception{
	}
	
	@PostMapping("login")
	public String login(HttpSession session, UserVO userVO, Model model) throws Exception {
		userVO = userService.login(userVO);
		session.setAttribute("user", userVO);
		model.addAttribute("user", userVO);
		return "redirect:/";	
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) throws Exception{
		session.setAttribute("user", null);
		session.removeAttribute("user");
		session.invalidate();
		return "redirect:/";
	}
}
