package com.cjc.action;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import com.opensymphony.xwork2.ActionSupport;

public class EmailSender extends ActionSupport {

	String emailid;
	String email;
	String subject;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public static void main(String[] args) {
		EmailSender e = new EmailSender();
		e.execute("rohitpshelar@gamil.com","abc");
	}

	public String execute(String too,String pwd) {
		String to=too;
		
		final String username = "cjcclass@gmail.com";
		final String password = "jnsgoezsjnvbiqxf";

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		// ............................................................

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(to));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Your Password : " + pwd);
			message.setText("Auto Generated Password");
			message.setText("visit Your Page: http://localhost:8080/ref/");
			message.setText("Sign In with your new Password : "+pwd);
			Transport.send(message);
			System.out.println("Sent message successfully....");
			return "success";
		} catch (MessagingException mex) {
			mex.printStackTrace();
			return "input";
		}

	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
