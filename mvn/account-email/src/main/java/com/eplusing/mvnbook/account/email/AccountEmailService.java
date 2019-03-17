package com.eplusing.mvnbook.account.email;

import javax.mail.MessagingException;

public interface AccountEmailService {
	void sendMail(String to, String subject, String html) throws MessagingException;
}
