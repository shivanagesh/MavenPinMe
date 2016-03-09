package com.pinme.mail;
//File Name SendHTMLEmail.java

import java.util.Date;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;


public class Mail {

	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;


	public static void sendMail(String toAdress, String messageText, String subjectMessage)  {

		try {
			String senderemail = "pinmecustomercare@gmail.com";
			String receiveremail = toAdress;
			String textMessage = messageText;
			String subject = subjectMessage;
		

			// email starts

			@SuppressWarnings("unused")
			final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
			// Get a Properties object
			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp");
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.auth", "true");
			props.put("mail.debug", "true");
			props.setProperty("mail.smtp.socketFactory.port", "465");
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.smtp.socketFactory.fallback", "false");
			props.setProperty("mail.smtp.port", "465");

			props.put("mail.store.protocol", "pop3");

			final String username = "pinmecustomercare@gmail.com";
			final String password = "2016pinme";

			Session sessionuser = Session.getDefaultInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			// -- Create a new message --
			Message message = new MimeMessage(sessionuser);

			// -- Set the FROM and TO fields --
			message.setFrom(new InternetAddress(senderemail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiveremail, false));
			message.setSubject(subject);
			message.setText(textMessage);
			message.setSentDate(new Date());

			@SuppressWarnings("static-access")
			Session session_mail = sessionuser.getInstance(props, null);
			Transport transport = session_mail.getTransport("smtps");
			transport.connect("smtp.gmail.com", 465, username, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();

			//Transport.send(message);
			System.out.println("Message sent.");
		} catch (MessagingException e) {
			System.out.println("ERROR: " + e);
		}

	}
}