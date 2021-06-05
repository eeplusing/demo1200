package com.eplusing.spring.springboot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import junit.framework.Assert;
@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
//@EnableAspectJAutoProxy(exposeProxy=true)

@WebMvcTest(controllers=BookController.class)
public class BookControllerTest {

	/*@Autowired
	private TestRestTemplate restTemplate;
	*/

/*	@Test
	public void testHome() {
		
		String content = restTemplate.getForObject("/book/home", String.class);
		Assert.assertEquals("bookhome", content);
	}*/
	
	@Autowired
	private MockMvc mvc;
	@Test
	public void testHome2() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/book/home")).andExpect(MockMvcResultMatchers.status().isOk());
		mvc.perform(MockMvcRequestBuilders.get("/book/home")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("bookhome"));
	}

}
