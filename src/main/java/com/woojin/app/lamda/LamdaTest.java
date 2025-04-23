package com.woojin.app.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class LamdaTest {
	
	public void test3() {
		
		Supplier<List<String>> t = ()->{
			String [] m = {"a", "b", "c"};
			List<String> ar = Arrays.asList(m);
			
			return ar;
		};
	}
	
	public void test2() {
		
		Test3Interface t3 = (List<Object> ar)->{
			System.out.println("test");
		};
		
		t3.t1(null);
		
		//interface에 두개 이상의 메서드가 있는 경우,
		//Lamda 사용 불가능
//		Test2Interface t = (int n1)->{
//
//		};
		
	}
	
	public void test() {
		TestInterface t = new Plus();
		t.cal(10, 20);
		
		t = new Minus();
		t.cal(20, 10);
		
		t = (int n1, int n2) -> n1+n2;
		
		int result=t.cal(10, 20);
		
		t = (int n1, int n2) -> {
			return n1*n2;
		};
		result = t.cal(1, 2);
	}
	
}
