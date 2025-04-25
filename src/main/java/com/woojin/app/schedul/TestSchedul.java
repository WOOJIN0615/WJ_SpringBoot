package com.woojin.app.schedul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.woojin.app.user.UserDAO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestSchedul {
	
	@Autowired
	private UserDAO userDAO;
	
	//@Scheduled(fixedRateString = "1000")
	public void useFixRate() {
		log.info("use FixRate");
	}
	
	//@Scheduled(fixedDelay = 1000)
	public void usrFixDelay() {
		log.info("use FixDelay");
	}
	
	//"초 분 시 일 월 요일"
	//@Scheduled(cron = "0 0 17 * * *")
	public void userCron() {
		log.info("use Cron");
	}
}
