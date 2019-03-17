package com.eplusing.book.account.email;

import javax.mail.MessagingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eplusing.mvnbook.account.email.AccountEmailService;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;

public class AccountEmailServiceTest {
	private GreenMail greenMail;
	
	@Before
	public void startMailServer(){
		greenMail = new GreenMail(ServerSetup.SMTP);
		greenMail.setUser("eplusing@gmail.com", "150906cpp");
		greenMail.start();
	}
	
	@Test
	public void testSendMail(){
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
		AccountEmailService accountEmailService = (AccountEmailService) ctx.getBean("accountEmailService");

		String subject = "Test subject";
		String html = "<h3>Testh3</h3>";
		try {
			accountEmailService.sendMail("eplusing@qq.com", subject, html);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void stopMailServer(){
		greenMail.stop();
	}
}
