package com.eplusing.spring.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController2 {
	
	@Autowired
	private CounterService counterService;
	
	
	@Autowired
	private GaugeService gaugeService;
	
	
	
	@RequestMapping(value="/user/home/actuatortest", method=RequestMethod.GET) 
	public String home(@RequestParam("error") String error){
		if("true".equals(error)){
			throw new NullPointerException();
		}
		counterService.increment("user.home.actuatortest.count");
		return "user home";
	}
	
	@GetMapping(value="/gauge/price")
	public String help(@RequestParam("price") double price){
		gaugeService.submit("produect.mp3.price", price);
		return "price";
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
