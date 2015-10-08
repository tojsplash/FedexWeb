package dijkstra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Track {

	
	static String[] details = new String[100];
	
	public static void main(String[] args) {
	
		Scanner reader = new Scanner(System.in);
		
		String headline = "WELCOME TO FEDEX PACKAGE TRACKING SYSTEM";
		
		System.out.println("\n\t\t\t\t\t" + headline);
		System.out.printf("\n\nPlease Enter the Tracking number of Package:");
		int a;
		a = reader.nextInt();
		
		String sql = "";
		
		try {
			// create our mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/world";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "1415");
			Statement st1 = conn.createStatement();
			
			System.out.println("\n*************************************************************************");
			
			System.out.println("\n\t\tPackage Information\n");
			System.out.println("\n*************************************************************************");
			
			 String[] fedex = {"TrackingID","Item","TotalPieces","Weight","Service","Packaging","Dimensions","SCity","DCity"};
			
			sql = "SELECT * FROM fedex WHERE TrackingID = " + a + "";
			
			 ResultSet rs = st1.executeQuery(sql);
			 
			 while (rs.next()) {
			 for (int c = 0; c < 9; c++) {
					
						details[c] = rs.getString(fedex[c]);
						System.out.println(fedex[c] + ":\t" + details[c]);
						
						if(details[c].equals("Brownsugar") || details[c].equals("Ak47") ){
							
							System.out.println("\n\n\n Oh Bwoyyy !!! Its    " + details[c].toUpperCase() );
							
							System.out.println("\n\n");
						}
					
				}
			 }
			 System.out.println("\n*************************************************************************");
			 
			 System.out.println("\n\t\tTracking Information\n");
			 System.out.println("\n*************************************************************************");
				
			 
			 sql = "SELECT * FROM nodes WHERE TrackingID = " + a + "";
			
			  rs = st1.executeQuery(sql);
			 
			 while (rs.next()) {
			 for (int c = 1; c < 12; c++) {
					if (rs.getString("Node" + c) != null) {
						details[c-1] = rs.getString("Node" + c);
						System.out.println(details[c-1]);
						//System.out.println();
					}
				}
			 }

			conn.close();
		}

		catch (Exception e) {
			System.err.println("Got an exception in Dijstra! ");
			System.err.println(e.getMessage());
		}
		
		
	}
	
	

}
