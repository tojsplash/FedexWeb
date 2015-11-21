
package com.gen.serve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;
import java.util.Calendar;
import java.util.Date;

class ReturnTable {

	static int row = 0;
	static String[][] city = new String[20000][100];

	public void getDetails(int count) {

		String sql = "";

		try {
			// create our mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/world";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "1415");
			Statement st1 = conn.createStatement();

			//String sql1 = "SELECT * FROM nodes WHERE TrackingID = "+ID+"";
			String sql1 = "SELECT * FROM nodes WHERE Processed = 0 LIMIT 0,"+count+"";
			//String sql1 = "SELECT * FROM nodes WHERE 'Processed' = 0";


			ResultSet rs = st1.executeQuery(sql1);

			row = 0;
			while (rs.next()) {

				city[row][0] = rs.getString("TrackingID");
				//System.out.println(city[row][0]);

				for (int c = 1; c <= 12; c++) {
					
					if (rs.getString("Node" + c) == null) {
						
						break;
					}
					
					if (rs.getString("Node" + c) != null) {
						city[row][c] = rs.getString("Node" + c);
						//System.out.println(city[row][c]);
					}
				}

				for (int k = 13, m = 1; k <= 23; k++, m++) {
					
					if (rs.getString("Dist" + m) == null) {
						
						break;
					}	

					if (rs.getString("Dist" + m) != null) {
						city[row][k] = rs.getString("Dist" + m);
						//System.out.println(city[row][k]);
					}
				}

				city[row][24] = "0";

				row++;

			}
			conn.close();
		}

		catch (Exception e) {
			System.err.println("Got an exception in Dijstra in Thread assignment! ");
			System.err.println(e.getMessage());
		}

	}

}

public class MultithreadingDemo extends Thread {

	private final Lock lock = new ReentrantLock();
	int dist=0;
	int dist1=0;
	String sql = "";
	String sql1 = "";
	private static int ThreadCount = 0;
	private static int ThreadCount1 = 0;

	public void run() {
		

		//System.out.println("My thread is in running state.");

/*		lock.lock();
		
		String[] onerow = new String[33];
		try

		{

			for (int row1 = 0; row1 < ReturnTable.row; row1++) {

				if (ReturnTable.city[row1][24].equals("0")) {

					ReturnTable.city[row1][24] = "1";

					for (int col = 0; col < 24; col++) {

						onerow[col] = ReturnTable.city[row1][col];

					}
					
					
					break;

				}

			}

		} // End of try 
		finally {
			lock.unlock();
		}
	*/	
		
		boolean acquired = false;
		try {
			acquired = lock.tryLock(600, TimeUnit.SECONDS);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String[] onerow = new String[33];
		if(acquired){
		try

		{

			for (int row1 = 0; row1 < ReturnTable.row; row1++) {

				if (ReturnTable.city[row1][24].equals("0")) {

					ReturnTable.city[row1][24] = "1";

					for (int col = 0; col < 24; col++) {

						onerow[col] = ReturnTable.city[row1][col];

					}
					
					
					break;

				}

			}

		} // End of try 
		finally {
			lock.unlock();
		}
		}
		
		
		
		int count = 0;

		for (int k = 13; k <= 23; k++) {

			if (onerow[k] == null) {
				
				try {
					// create our mysql database connection
					String myDriver = "org.gjt.mm.mysql.Driver";
					String myUrl = "jdbc:mysql://localhost/world";
					Class.forName(myDriver);
					Connection conn = DriverManager.getConnection(myUrl, "root", "1415");
					Statement st1 = conn.createStatement();
				sql = "UPDATE nodes SET Processed = '1' WHERE TrackingID = " + onerow[0] + "";
				sql1 = "UPDATE nodes SET Status = 'Delivered' WHERE TrackingID = " + onerow[0] + "";
				//String sql2 = "UPDATE fedex SET Delivered = '1' WHERE TrackingID = " + onerow[0] + "";
				st1.executeUpdate(sql);
				st1.executeUpdate(sql1);
				//st1.executeUpdate(sql2);
				
				
				/*Sending mail to customer once delivered*/
				
				//sql1 = "SELECT * FROM fedex WHERE TrackingID = " + onerow[0] + "";;
				//ResultSet rs = st1.executeQuery(sql1);
				
				//while (rs.next()) {

				//	int mail1 = (rs.getInt(13));
					
				//if(mail1 == 1){	
				SendEmail mail = new SendEmail();
				mail.send(Integer.parseInt(onerow[0]));
				System.out.println("reached in mail");
				//}
				//}
				
				conn.close();
				}

				catch (Exception e) {
					System.err.println("Got an exception in Dijstra if packet delivered/mail! ");
					System.err.println(e.getMessage());
				}
				break; 
				
			}
		
			
			else{
				
				// Put the Processed status here.
				
				double value = Double.parseDouble(onerow[k]);
				dist = (int) value;
				
				if (onerow[k+1] != null){
					
					double value1 = Double.parseDouble(onerow[k+1]);
					dist1 = (int) value1;	
					
				}
				
			}

		
					//Date date = new Date();
					Calendar calendar = Calendar.getInstance(); // gets a calendar using the default time zone and locale.
					
					
					//Thread.sleep(dist*10);
					
					//dist/=100;
					//calendar.add(Calendar.SECOND, dist);
					//String time = String.valueOf(calendar.getTime());
					//time = ":" + time;
					//System.out.println(time);
					
					
					try {
						// create our mysql database connection
						String myDriver = "org.gjt.mm.mysql.Driver";
						String myUrl = "jdbc:mysql://localhost/world";
						Class.forName(myDriver);
						Connection conn = DriverManager.getConnection(myUrl, "root", "1415");
						Statement st1 = conn.createStatement();
						
						
						String[] Nodes = { "Node1", "Node2", "Node3", "Node4", "Node5",
								"Node6", "Node7", "Node8", "Node9", "Node10", "Node11",
								"Node12", "Node13", "Node14", "Node15", "Node16", "Node17",
								"Node18", "Node19", "Node20", "Node21", "Node22", "Node23",
								"Node24", "Node25" };
						
						
						count++ ;
						
						calendar.add(Calendar.SECOND, dist/10);
						String time = String.valueOf(calendar.getTime());
						time = " : Started Shipment at - " + time;
						//System.out.println(Thread.currentThread().getId() + " : " + time);
						
						
                        sql = "UPDATE nodes SET Node" + count + " = CONCAT(Node" + count + ",'" + time + "') WHERE TrackingID = " + onerow[0] + "";							
						
						st1.executeUpdate(sql);
						
						try{
						Thread.sleep(dist*100);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						
						
						calendar.add(Calendar.SECOND, dist1/10);
						 time = String.valueOf(calendar.getTime());
						//time = String.valueOf(calendar.getTime());
						time = " : Shipment Reached at - " + time;
						//System.out.println(Thread.currentThread().getId() + " : " + time);
						
						count++ ;
						
                        sql = "UPDATE nodes SET Node" + count + " = CONCAT(Node" + count + ",'" + time + "') WHERE TrackingID = " + onerow[0] + "";							
						
						st1.executeUpdate(sql);
						count--;
						
						
						
						try{
							Thread.sleep(dist1*100);
							}catch(InterruptedException e){
								e.printStackTrace();
						}
						
					//	calendar.add(Calendar.SECOND, 5);
					//	 time = String.valueOf(calendar.getTime());

						conn.close();
					}

					catch (Exception e) {
						System.err.println("Got an exception in Dijstra in packet moving! ");
						System.err.println(e.getMessage());
					}

					
					
					





			}
		
		lock.lock();
		
		ThreadCount++;
		System.out.println(ThreadCount);
		//System.out.println(Thread.activeCount());
		
		lock.unlock();
/*		
	if(ThreadCount == 1000){
			

			ThreadCount = 0;
			ThreadCount1++;
			
			if(ThreadCount1 == 5){
				
				return;
			}
			
			thread();
	}
	*/	

	}   // End of run function

	public  void move(int count) {
		//MultithreadingDemo obj = new MultithreadingDemo();
		

		ReturnTable ret = new ReturnTable();
		ret.getDetails(count);
		
		thread(count);

		/*
		
		for(int i = 0;i<10;i++){
			//Thread tobj = new Thread(obj);
			//tobj.start();
			MultithreadingDemo obj = new MultithreadingDemo();
			obj.start();
	
		
 	}
 	
 	*/
	}
	
	
	public  static void thread(int count){
		
		for(int i = 0;i<count;i++){
			MultithreadingDemo obj = new MultithreadingDemo();
			obj.start();
	
 	}
		
	}

}