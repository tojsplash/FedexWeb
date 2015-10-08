import java.sql.*;
import java.util.Random;
public class Demo {
	

	
	public static void main(String[] args)
	  {
		
		Dijkstra D1 = new Dijkstra();
		
	    try
	    {
	      // create our mysql database connection
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/world";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "1415");	      
	   
	
	 
	   String []City = { "Northborough MA",
			   "Edison NJ",
			   "Allentown PA",
			   "Martinsburg WV",
			   "Charlotte NC",
			   "Atlanta GA",
			   "Orlando FL",
			   "Memphis TN"     ,
			   "Baltimore MD",
			   "Grove City OH"  ,
			   "Indianapolis IN",
			   "Detroit MI"     ,
			   "New Berlin WI"  ,
			   "Minneapolis MN" ,
			   "St. Louis MO"   ,
			   "Kansas KS"      ,
			   "Dallas TX"      ,
			   "Houston TX"     ,
			   "Denver CO"      ,
			   "Salt Lake City U",
			   "Phoenix AZ",
			   "Los Angeles CA",
			   "Chino CA",
			   "Sacramento CA",
			   "Seattle WA"
	   };
	   
	   String []Package = {"Bag","Shirt","Brownsugar","Ak47","Shoes","Certificates","Bottles",
			   "Ipad","Ipod","Watch","Sunglass","Books","Household items","Crockeries"};
	   
	   String [] Dimensions = {"3.5*4.5 in","4.5*6.5 in","10.5*12.5 in"};
	   
	   String [] Services = {"Pickup","HomeDelivery","DropBox"};
	   
	   String [] Packagings = {"Package","Envelope","Express Freight"};
	   
	   
	   for (int k1=0;k1<5000;k1++)
	   {
		   
	   int idx1 = new Random().nextInt(15);
	   String Source = (City[idx1]);
	   
	   int idx2 = new Random().nextInt(15);
	   String Destination = (City[idx2]);
	   
	   while(Source == Destination){
		   
		idx2 = new Random().nextInt(City.length); 
		Destination = (City[idx2]);
	   }
	    
	   int idx3 = new Random().nextInt(Package.length);
	   String Packet = (Package[idx3]);
	    
	   int Pieces = (1+new Random().nextInt(10));
	   
	   
	   double start = 1;
	   double end = 10;
	   double random = new Random().nextDouble();
	   double Weight = start + (random * (end - start));
	   
	   
		int idx4 = new Random().nextInt(Dimensions.length); 
		String Dimension = (Dimensions[idx4]);
	   
	   
		int idx5 = new Random().nextInt(Services.length); 
		String Service = (Services[idx5]);
	  
	   
		int idx6 = new Random().nextInt(Packagings.length); 
		String Packaging = (Packagings[idx6]);
		
		String sql1 = "INSERT INTO fedex(Item,TotalPieces,Weight,Service,Packaging,Dimensions,SCity,DCity)" ;
		String sql2 =  "VALUES('"+Packet+"','"+Pieces+"','"+Weight+"','"+Service+"','"+Packaging+"','"+Dimension+"','"+Source+"','"+Destination+"');" ;
		
		String sql = sql1 + sql2;
		
		// create the java statement
	    Statement st = conn.createStatement();
	       
	      // execute the query, and get a java resultset
	    st.executeUpdate(sql);
	    
	    sql = "SELECT * FROM fedex ORDER BY TrackingID DESC LIMIT 1";
	    ResultSet rs = st.executeQuery(sql);
	    
	    
	    String TrackingID ="";
	    
	    
	    while (rs.next()) {

			TrackingID = rs.getString("TrackingID");
			System.out.println(TrackingID);
	    
	    }
	    
	  //  int ID= Integer.parseInt(TrackingID);
	    
	
	    
	    
	    D1.shortestPath(Source,Destination,Integer.parseInt(TrackingID));
	    
	//    System.out.println("Reached");
	//	   conn.close(); 
	    
		}
	   
	   System.out.println("Reached");
	   conn.close(); 
 }
	    
	    
	    catch (Exception e)
	    {
	      System.err.println("Got an exception in demo! ");
	      System.err.println(e.getMessage());
	    }

	  }	

}
