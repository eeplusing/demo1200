package com.eplusing.spring.springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public String errorHandler(Exception e){
		return "global error " + e.getClass().getName();
	}
	
}
