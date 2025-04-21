package com.woojin.app.aoptest;

import org.springframework.stereotype.Component;

@Component
public class Transport {
	
	public String getBus(int num) {
		System.out.println("버스");
		
		return "9707";
	}
	
	public String getSubway(String name) {
		System.out.println("지하철");
		
		return "경의중앙선";
	}
	
	public String bicycle(int money) {
		System.out.println("따릉따릉");
		
		return "비켜~";
	}
	
	public void walk() {
		System.out.println("뚜벅뚜벅");
	}
}
