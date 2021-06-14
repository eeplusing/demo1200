package com.eplusing.demo1200.springboot.controller;

import java.io.FileNotFoundException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	//@ExceptionHandler(value=Exception.class)
	public String error(Exception e){
		return " found exception " + e.getMessage();
	}
	
	//@GetMapping("/book/error1")
	public String error1() throws FileNotFoundException{
		throw new FileNotFoundException("FileNotFoundException");
	}
	
	//@GetMapping("/book/error2")
	public String error2() throws ClassNotFoundException{
		throw new ClassNotFoundException("ClassNotFoundException");
	}
	
	@GetMapping("/book/home")
	public String home() throws ClassNotFoundException{
		System.out.println("/book/home invoke");
		return "bookhome";
	}
	
}
