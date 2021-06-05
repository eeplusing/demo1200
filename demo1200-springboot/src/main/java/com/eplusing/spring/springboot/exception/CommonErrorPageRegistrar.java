package com.eplusing.spring.springboot.exception;

import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

//@Component
public class CommonErrorPageRegistrar implements ErrorPageRegistrar{
	public void registerErrorPages(ErrorPageRegistry registry) {
		ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
		ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
		ErrorPage eargs = new ErrorPage(IllegalArgumentException.class, "/args.html");
		
		registry.addErrorPages(e404, e500, eargs);
	}

}
