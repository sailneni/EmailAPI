package com.sai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.utils.EmailUtils;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public boolean sendContact(String email) {
			String to= email;
			String subject="Sai Ailneni || Thank you for your interest in contacting me";
			StringBuffer body= new StringBuffer("");
			body.append("<h3>Here are my contact details:</h3>");
			body.append("Call: +1 226-946-6087");
			body.append("<br/>");
			body.append("Email: sailneni44@gmail.com");
			body.append("<br/>");
			body.append("<a href=\"https://www.linkedin.com/in/sai-ailneni-5b7417269/\r\n"
					+ "\">Click here for LinkedIn</a>");
			//body.append("<br/>");
			//body.append("<a href=\"http://localhost:8080/login\">Click here to unlock</a>");
			
			emailUtils.sendEmail(subject, body.toString(), to);
			return true;
	}
}
