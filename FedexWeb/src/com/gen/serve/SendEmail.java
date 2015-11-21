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

public class SendEmail {
	

	static String[] details = new String[100];

	public static void main(String[] args) {

		final String username = "tojsplash@gmail.com";

		final String password = "tojojoseph001415";

		final String host = "smtp.gmail.com";

		final int port = 587;

		Connection conn = null;

		String url = "jdbc:mysql://localhost:3306/";

		String dbName = "world";

		String driver = "com.mysql.jdbc.Driver";

		try {

			Class.forName(driver).newInstance();

			conn = DriverManager.getConnection(url + dbName, "root", "1415");

			System.out.println("DB connected");

			String Emailids = null;

			int TrackingID = 0;

			String sql1 = "SELECT Max(TrackingID) as TrackingID from Shipment_Creation";

			String sql2 = "SELECT from_Email from Shipment_Creation where TrackingID in (SELECT Max(TrackingID) as TrackingID from Shipment_Creation)";

			Statement st = null;

			st = conn.createStatement();

			ResultSet resultSet1 = st.executeQuery(sql1);

			while (resultSet1.next()) {

				TrackingID = resultSet1.getInt(1);

				System.out.println(TrackingID);

			}

			ResultSet resultSet2 = st.executeQuery(sql2);

			while (resultSet2.next()) {

				Emailids = resultSet2.getString("from_Email");

				System.out.println(Emailids);

			}

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

			// session.setDebug(true);

			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(username));

			message.setRecipient(Message.RecipientType.TO, new InternetAddress(
					Emailids));

			message.setSubject("Tracking number # "+ TrackingID);

			message.setText("Dear Customer,\n\nYour shipment Tracking Tracking number is "
					+ TrackingID);

			Transport transport = session.getTransport("smtp");

			System.out.println("connecting to mail server");

			transport.connect(host, port, username, password);

			transport.sendMessage(message, message.getAllRecipients());

			transport.close();

			System.out.println("message sent successfully");

			message.setRecipient(Message.RecipientType.TO, new InternetAddress(
					"tojsplash@gmail.com"));

			message.setSubject("Tracking number");

			message.setText("Dear Agent,\n\nA shipment with TrackingID "
					+ TrackingID
					+ " has been created for your approval.\nPlease do the needful");

			transport.connect(host, port, username, password);

			transport.sendMessage(message, message.getAllRecipients());

			transport.close();

		}

		catch (MessagingException mex)

		{

			throw new RuntimeException(mex);

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (InstantiationException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (IllegalAccessException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}
	
	public void sendconfirmation(int ID){
		
		final String username = "tojsplash@gmail.com";

		final String password = "tojojoseph001415";

		final String host = "smtp.gmail.com";

		final int port = 587;

		Connection conn = null;

		String url = "jdbc:mysql://localhost:3306/";

		String dbName = "world";

		String driver = "com.mysql.jdbc.Driver";

		try {

			Class.forName(driver).newInstance();

			conn = DriverManager.getConnection(url + dbName, "root", "1415");

			System.out.println("DB connected");

			String Emailids = null;

			String Emailid ="";
			String Status = "";

			String sql1 = "SELECT * from shipment_creation where TrackingID='"+ID+"'";
			

			Statement st = null;

			st = conn.createStatement();

			ResultSet resultSet1 = st.executeQuery(sql1);

			while (resultSet1.next()) {

				Emailid = resultSet1.getString("from_Email");
				Status =  resultSet1.getString("status");
			}

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

			// session.setDebug(true);

			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(username));

			message.setRecipient(Message.RecipientType.TO, new InternetAddress(
					Emailid));

			message.setSubject("Tracking number # "+ ID);

			message.setText("Dear Customer,\n\nYour shipment has been " +Status + " by the agent. Please "
					+ "contact for any queries");


			Transport transport = session.getTransport("smtp");

			System.out.println("connecting to mail server");

			transport.connect(host, port, username, password);

			transport.sendMessage(message, message.getAllRecipients());

			transport.close();

		}

		catch (MessagingException mex)

		{

			throw new RuntimeException(mex);

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (InstantiationException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (IllegalAccessException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}
	
	public void send(int a) 
	   {    
		

		
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
			
			conn.close();
			
		

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
}


		

