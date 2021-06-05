package com.eplusing.spring.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/***
 * FreeMarkerProperties默认模板路径DEFAULT_TEMPLATE_LOADER_PATH = "classpath:/templates/"， 默认后缀DEFAULT_SUFFIX = ".ftl";
 * @author admin
 *
 */
//@Controller
public class AccountController {
	
	@GetMapping("/reg")
	public String reg(){
		return "reg";
	}
	@GetMapping("/logout")
	public String reg(Model model){
		model.addAttribute("username", "admin");
		return "logout";
	}
}
