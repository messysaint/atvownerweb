package com.abrstech.obd2.util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;






public class SmtpMailer implements Runnable{

	// santamesa.com mail server
		String host = "localhost";
		String username =  "kali";   
		String password =  "kali";
		
		String from = "noreply@autotalky.com";
		
		String subject = new String(); 
	
		String autotalkyIMG = "<img src=\"http://autotalky.com/wp-content/uploads/2013/05/autotalky_new4.png\" alt=\"Autotalky.com\" >";
		
		// Use
		// HTMLmsgBEGIN + value + HTMLmsgMID + paramname + HTMLmsgEND
		String HTMLBREAK = "<BR>";
		String HTMLmsgVINBEGIN =  "<p> VIN #: ";
		String HTMLmsgVINEND =  "</p>" ;
		String HTMLmsgBEGIN =  "<p style=\"font-size:100px\"> <font face=\"verdana\" color=\"green\">" ; 				  				  
		String HTMLmsgMID = "</font> </p> <p>" ; 
		String HTMLmsgEND = "</p> <BR> <BR> <BR> <BR> <BR>" +
				  "<p>Thank you for using  <a href=\"http://Autotalky.com\">Autotalky.com</a> </p>" +
				  autotalkyIMG ;
				
		// class constructor
		public SmtpMailer() {
			
		}
		
		
		
		
		public boolean sendMessageToAddress(String toAddress, String subject, float value, String paramname, String vin, String comments ) {
			
			boolean success = false;
							
			try {
				
				String content = HTMLmsgVINBEGIN + vin + HTMLBREAK + paramname + HTMLmsgVINEND + HTMLmsgBEGIN + value + HTMLmsgMID + comments + HTMLmsgEND;
				
				//Set the properties
				Properties props = new Properties();
				props.put("mail.smtps.auth", "true");
				props.put( "mail.smtp.starttls.enable", "false" );
				props.put("mail.smtp.port", 25);//Whatever port
				//props.put("mail.debug", "true");
		        //props.put("mail.smtp.debug", "true");
				
				// Set the session here
				Session session = Session.getDefaultInstance( props );
				MimeMessage msg = new MimeMessage( session );
				
				// set the message content here
				msg.setSubject( subject );
				//msg.setText( content ); // simple text email
				msg.setContent(content, "text/html; charset=utf-8"); // for HTML messages
				msg.setFrom( new InternetAddress( from ) );
				msg.addRecipient( Message.RecipientType.TO, new InternetAddress( toAddress ) );
				
				
					// ready to transport
					//Transport t = session.getTransport( "smtps" );
					Transport t = session.getTransport( "smtp" );
					t.connect( host, username, password );
					t.sendMessage( msg, msg.getAllRecipients() );
					t.close();
					
				
				
			} catch ( Exception e ) {
				success = true;
				System.out.println( "Send failed. Will try again later." );
				e.printStackTrace();
			} finally {
				//System.out.println( "Finally cleaning up" );
			}
			
						
			return success;
			
		}



		
		
		public boolean sendMessageToAddress(String toAddress, String subject, String content) {
			
			boolean success = false;
							
			try {
								
				
				//Set the properties
				Properties props = new Properties();
				props.put("mail.smtps.auth", "true");
				props.put( "mail.smtp.starttls.enable", "true" );
				//props.put("mail.debug", "true");
		        //props.put("mail.smtp.debug", "true");
				
				// Set the session here
				Session session = Session.getDefaultInstance( props );
				MimeMessage msg = new MimeMessage( session );
				
				// set the message content here
				msg.setSubject( subject );
				msg.setText( content ); // simple text email
				//msg.setContent(content, "text/html; charset=utf-8"); // for HTML messages
				msg.setFrom( new InternetAddress( from ) );
				msg.addRecipient( Message.RecipientType.TO, new InternetAddress( toAddress ) );
				
				
					// ready to transport
					Transport t = session.getTransport( "smtps" );
					t.connect( host, username, password );
					t.sendMessage( msg, msg.getAllRecipients() );
					t.close();
					
				
				
			} catch ( Exception e ) {
				success = true;
				System.out.println( "Send failed. Will try again later." );
				e.printStackTrace();
			} finally {
				//System.out.println( "Finally cleaning up" );
			}
			
						
			return success;
			
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
				
}
