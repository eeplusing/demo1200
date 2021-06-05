package com.eplusing.spring.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@PostMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam(value="password")String password){
		if(username.equals(password)){
			return "ok";
		}
		
		return "fail";
	}
	
	@GetMapping("/login")
	public String loginIndex(Model model){
		model.addAttribute("username", "root");
		
		return "login";
	}
}
