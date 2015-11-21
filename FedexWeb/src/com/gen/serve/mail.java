package com.gen.serve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class mail {
	
	static String[] details = new String[100];
	
	public void send() 
	   {    
		
		int a = 80;
		
		System.out.println("reached in sendmail");
		
		final String username = "tojsplash@gmail.com";

		final String password = "tojojoseph001415";
		final String to = "tojojoseph.mec@gmail.com";

		final String host = "smtp.gmail.com";

		final int port = 587;
		
		String sql = "";
		String one = "\n*************************************************************************\n";
		String two = "\nPackage Information";
		String three = "\nTracking Information";
		String message1 = "\t\t\t\t\tYour Package has been delivered at the destination\n\n";

		try {

			// create our mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/world";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "1415");
			Statement st1 = conn.createStatement();
			

			 String[] fedex = {"TrackingID","Item","No_of_Packages","Packaging_type","Package_Declared_Value","SCity","DCity"};
			
			sql = "SELECT * from shipment_creation  WHERE TrackingID = " + a + "";
			
			message1+=two +"\n\n";
			
			
			 ResultSet rs = st1.executeQuery(sql);
			 
			 while (rs.next()) {
			 for (int c = 0; c < 7; c++) {
					
						details[c] = rs.getString(fedex[c]);
						
						message1+=fedex[c]+":   "+details[c];
						message1+="\n";
						
					
					
				}
			 }
			
			 sql = "SELECT * FROM nodes WHERE TrackingID = " + a + "";
			 
			 message1+=three+"\n\n";
			
			  rs = st1.executeQuery(sql);
			 
			 while (rs.next()) {
			 for (int c = 1; c < 12; c++) {
					if (rs.getString("Node" + c) != null) {
						details[c-1] = rs.getString("Node" + c);
						message1+=details[c-1];
						message1+="\n";
						
					}
				}
			 }
			 System.out.println("reached before conn close");
			conn.close();
			System.out.println("reached after conn close");
		

			Properties properties = new Properties();

			properties.put("mail.smtp.auth", "true");

			properties.put("mail.smtp.starttls.enable", "true");

			properties.put("mail.smtp.auth", "smtp.gmail.com");

			properties.put("mail.smtp.port", 587);

			Session session = Session.getInstance(properties

			, new javax.mail.Authenticator() {

				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {

					return new javax.mail.PasswordAuthentication(username,
							password);

				}

			});
			System.out.println("reached above mini");

			// session.setDebug(true);

			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(username));

			message.setRecipient(Message.RecipientType.TO, new InternetAddress(
					to));

			message.setSubject("Tracking number # "+ a);

			message.setText(message1);


			Transport transport = session.getTransport("smtp");

			System.out.println("connecting to mail server");

			transport.connect(host, port, username, password);

			transport.sendMessage(message, message.getAllRecipients());

			transport.close();
			
			System.out.println("reached at the end");

		}

		catch (MessagingException mex)

		{

			throw new RuntimeException(mex);

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		
	   }
	
	public static void main(String args[]){
		
		mail mail1 = new mail();
		mail1.send();
		
	}
}


		

