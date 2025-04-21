package com.woojin.app.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@GetMapping("/")
	public String home() {
		//log.warn("home");
		return "home";
	}
	
	@GetMapping("login")
	public String login() throws Exception{
		return "/login";
	}
	
	@GetMapping("join")
	public String join() throws Exception{
		return "/join";
	}
}