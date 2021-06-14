package com.eplusing.demo1200.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class UserController {
	
	//限制仅支持GET，默认不限制请求方式
	//@RequestMapping(value="/user/home", method=RequestMethod.GET) 
	//@ResponseBody
	public String home(){
		return "user home";
	}
	
	//@ResponseBody
	//@GetMapping(value="/user/help")
	public String help(){
		throw new IllegalArgumentException("args is empty");
	}
	
	//@ResponseBody
	//@GetMapping(value="/user/show")
	public String show(){
		return "user show";
	}
	
	//@ResponseBody
	//@GetMapping(value="/user/display/{id}")
	public String display(@PathVariable("id")String id){
		return "user display " + id;
	}
	
	//@ResponseBody
	//@GetMapping(value="/user/ip")
	public String edit(HttpServletRequest req){
		return "user edit " + req.getRemoteHost();
	}
	
	//@ResponseBody
	//@PostMapping(value="/user/create")
	public String create(@RequestParam("username") String username, @RequestParam(value="password", required=false, defaultValue="000000")String password){
		
		System.out.println("user create username=" + username + ",password=" + password);
		return "user create username=" + username + ",password=" + password;
	}

}
