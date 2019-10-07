package com.cjc.email;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class EmailSender extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public static void main(String[] args) throws IOException, TemplateException {
		EmailSender e = new EmailSender();
		e.execute("niteen.dhobale3@gmail.com","abc");
	}

	public String execute(String too,String pwd) throws IOException, TemplateException {
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


			 BodyPart body = new MimeBodyPart();
			 
	            // freemarker stuff.
	            Configuration cfg = new Configuration();
	            Template template = cfg.getTemplate("html-mail-template.ftl");
	            Map<String, String> rootMap = new HashMap<String, String>();
	            rootMap.put("to", "Bharat Sharma");
	            rootMap.put("body", "Sample html email using freemarker");
	            rootMap.put("from", "Vijaya.");
	            Writer out = new StringWriter();
	            template.process(rootMap, out);
	            // freemarker stuff ends.
	 
	            /* you can add html tags in your text to decorate it. */
	            body.setContent(out.toString(), "text/html");
	 
	            Multipart multipart = new MimeMultipart();
	            multipart.addBodyPart(body);
	 
	            body = new MimeBodyPart();
	 
	            String filename = "hello.txt";
	            DataSource source = new FileDataSource(filename);
	            body.setDataHandler(new DataHandler(source));
	            body.setFileName(filename);
	            multipart.addBodyPart(body);
	 
	            message.setContent(multipart, "text/html");
			
			
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
