package com.woojin.app.aoptest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransportTest {
	
	@Autowired
	private Transport transport;

	@Test
	void test() {
		String res=transport.getBus(1);
		
		String res2=transport.getSubway("red");
		
		String res3=transport.bicycle(0);
		
		transport.walk();
		
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(res);
		System.out.println(res2);
		System.out.println(res3);
		System.out.println("finish");
	}

}
