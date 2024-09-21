package vn.iotstar.utils;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import vn.iotstar.models.UserModel;

public class Email {
	//ham random code
	public String getRandom()
	{
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return String.format("%06" ,number);
	}
	public boolean sendEmail(UserModel user)
	{
		boolean test = false;
		String toEmail = user.getEmail();
		String fromEmail = "ledaonhansam001@gmail.com";
		String password ="nhansam123";
		try
		{
			Properties pr =configEmail(new Properties());
			Session session = Session.getInstance(pr, new Authenticator() {
				
				protected PasswordAuthentication getPasswordAuthentication ()
				{
					return new PasswordAuthentication(fromEmail, password);
				}
				
			});
			Message mess = new MimeMessage(session);
			mess.setHeader("Content-Type","text/plain; charset=UTF-8");
			
			mess.setFrom( new InternetAddress(fromEmail));
			
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			
			mess.setSubject("Cofirm code");
			
			mess.setText("Code: " + user.getCode());
			
			Transport.send(mess);
			test = true;
			
		}catch (Exception e) {
			 e.printStackTrace();
		}
		return test;
	}
	public boolean Emailsend(UserModel user)
	{
		boolean test = false;
		String toEmail = user.getEmail();
		String fromEmail = "ledaonhansam001@gmail.com";
		String password ="nhansam123";
		try
		{
			Properties pr =configEmail(new Properties());
			Session session = Session.getInstance(pr, new Authenticator() {
				
				protected PasswordAuthentication getPasswordAuthentication ()
				{
					return new PasswordAuthentication(fromEmail, password);
				}
				
			});
			Message mess = new MimeMessage(session);
			mess.setHeader("Content-Type","text/plain; charset=UTF-8");
			
			mess.setFrom( new InternetAddress(fromEmail));
			
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			
			mess.setSubject("Yours Password");
			
			mess.setText("Password: " + user.getPassword());
			
			Transport.send(mess);
			test = true;
			
		}catch (Exception e) {
			 e.printStackTrace();
		}
		return test;
	}
	public Properties configEmail (Properties pr)
	{
		pr.setProperty("mail.smtp.host","smtp.gmail.com");
		pr.setProperty("mail.smtp.port","587");
		pr.setProperty("mail.sntp.auth","true");
		pr.setProperty("mail.smtp.starttls.enable", "true");
		pr.put("mail.smtp.socketFactory.port","587");
		pr.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		return pr;
		
	}
}
