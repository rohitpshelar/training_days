import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import com.opensymphony.xwork2.ActionSupport;

public class EmailSender extends ActionSupport {
	public static void main(String[] args) {
		EmailSender e = new EmailSender();
	}

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

	@Override
	public String execute() {

		String to = emailid;

		// =====================================
		final String username = "rohitpshelar@gmail.com";
		final String password = "fjnbimsksogkzaiv";

		System.out.println("pass = " + username + password);

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		// ............................................................

		try {
			MimeMessage message = new MimeMessage(session);

			// message.setFrom(new InternetAddress(from));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(email);

			// sending msg
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
