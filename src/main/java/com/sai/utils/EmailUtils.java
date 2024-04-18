package com.sai.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {
	
	@Autowired
	private JavaMailSender mailSender;
	
	private Logger logger = LoggerFactory.getLogger(EmailUtils.class);
	
	public boolean sendEmail(String subject, String body, String to) {
		
		boolean isSent=false;
		
		try {
			
			MimeMessage mineMsg =mailSender.createMimeMessage();
			
			MimeMessageHelper helper = new MimeMessageHelper(mineMsg, true);
			helper.setSubject(subject);
			helper.setText(body, true);
			helper.setTo(to);
			//helper.addAttachment("Plans", file);
			
			mailSender.send(mineMsg);
			isSent=true;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return isSent;
	}

}
