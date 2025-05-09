package com.woojin.app.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(exception = Throwable.class)
	public String ex1() {
		
		return "error/error";
	}
}
