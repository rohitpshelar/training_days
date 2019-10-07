


	import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
	
	for(int i=1;i<1000;i++){
		e.execute();	
	}
	
}
	public String execute() {
		 
	      String to = "rohit.shelar@riomed.com";
	      final String username = "Niteen.dhobale3@gmail.Com";
	      final String password = "sexyvboabrgkjngx";
	 
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");
	 
			Session session = Session.getInstance(properties,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}});
	      //............................................................
	      
	      try{
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(to));
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
	         message.setSubject("Your Password : "+subject);
	         message.setText("hello");
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	         return "success";
	      }catch (MessagingException mex) {
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


