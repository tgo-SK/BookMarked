package utils;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message.RecipientType;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.MessagingException;

public class EmailSenderClient{
	public static class MailPasswordAuthenticator extends Authenticator{
		public static String senderEmailClient;
		public static String senderEmailPasswordClient;
         
		public PasswordAuthentication getPasswordAuthentication(){
			return new PasswordAuthentication(senderEmailClient,senderEmailPasswordClient);
		}
	}
	
	public static void sendEmail(String email,String subject,String msg){
      
		Properties props = new Properties();
	
		props.put("mail.transport.protocol","smtp");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.port","587");
		props.put("mail.smtp.starttls.enable","true");

		Session mailSession = Session.getInstance(props,new MailPasswordAuthenticator());

		MimeMessage message = new MimeMessage(mailSession);

	
		try{
			message.setFrom(MailPasswordAuthenticator.senderEmailClient);
			message.setRecipients(Message.RecipientType.TO,email);
			message.setSubject(subject);
			message.setContent(msg,"text/html");
			Transport.send(message);
		}catch(MessagingException e){
			e.printStackTrace();	
		}
	}
}