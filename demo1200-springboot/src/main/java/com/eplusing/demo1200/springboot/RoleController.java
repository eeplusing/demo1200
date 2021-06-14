package com.eplusing.demo1200.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //当前controller方法的放回值可直接用于body的输出
public class RoleController {
	

	@GetMapping(value="/role/show")
	public String show(){
		return "role show";
	}
	

}
