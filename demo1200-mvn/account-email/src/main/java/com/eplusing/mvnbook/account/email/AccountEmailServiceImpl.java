package com.eplusing.mvnbook.account.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class AccountEmailServiceImpl implements AccountEmailService {

	private JavaMailSender javaMailSender;
	private String systemEmail;
	public void sendMail(String to, String subject, String html) throws MessagingException {
		try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper msgHelper = new MimeMessageHelper(msg);
			msgHelper.setFrom(systemEmail);
			msgHelper.setTo(to);
			msgHelper.setSubject(subject);
			msgHelper.setText(html);
			
			javaMailSender.send(msg);
		} catch (MessagingException e) {
			throw new MessagingException("Fail to send mail.", e);
		}
		
	}
	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	public String getSystemEmail() {
		return systemEmail;
	}
	public void setSystemEmail(String systemEmail) {
		this.systemEmail = systemEmail;
	}

}
