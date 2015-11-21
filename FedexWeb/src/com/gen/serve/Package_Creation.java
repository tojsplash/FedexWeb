package com.gen.serve;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Statement;

/**
 * Servlet implementation class Package_Creation
 */
@WebServlet("/Package_Creation")
public class Package_Creation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Package_Creation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/number/html");
		PrintWriter pw = response.getWriter();	
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "world"; 
		String driver = "com.mysql.jdbc.Driver";
		
		try{
			int agent = 0;
			int TrackingID = 0;
			String id ="";
			 id = (String) request.getParameter("name");
			System.out.println(id);
			String Item=request.getParameter("Item");
			String No_of_packages=request.getParameter("NoofPackages");
			String Packaging_type=request.getParameter("Packagingtype");
			String Package_Declared_Value=request.getParameter("PackageDeclaredValue");
			String SCity=request.getParameter("Scity");
			String DCity=request.getParameter("Dcity");
			
			//To address
			String Company_or_name=request.getParameter("CompanyorName");
			String Contact=request.getParameter("Contact");
			String Address_line1=request.getParameter("Addressline1");
			String Address_line2=request.getParameter("Addressline2");
			String zipcode=request.getParameter("Zipcode");
			String Email=request.getParameter("Email");
			String Country=request.getParameter("Country");
			
			//From address
			String from_Company_or_name=request.getParameter("from_CompanyorName");
			String from_Contact=request.getParameter("from_Contact");
			String from_Address_line1=request.getParameter("from_Addressline1");
			String from_Address_line2=request.getParameter("from_Addressline2");
			String from_zipcode=request.getParameter("from_Zipcode");
			String from_Email=request.getParameter("from_Email");
			String from_Country=request.getParameter("from_Country");
			String radio=request.getParameter("radio");
			
				
				Class.forName(driver).newInstance();
				conn=DriverManager.getConnection(url+dbName, "root","1415");
				pw.println("connected");
				String sql1 = "INSERT INTO shipment_creation(Item, No_of_packages, Packaging_type, Package_Declared_Value,SCity,DCity,to_Company_or_name,to_Contact,"
						+ "to_Address_line1,to_Address_line2,to_zipcode,to_Email,to_Country,from_Company_or_name,from_Contact,from_Address_line1,"
						+ "from_Address_line2,from_zipcode,from_Email,from_Country,radio,status,username)";
				String sql2 = "VALUES('"+ Item + "','" + No_of_packages+ "','" + Packaging_type + "','" + Package_Declared_Value + "','"+SCity+"','"+DCity+"',"
						+ "'"+Company_or_name+"','"+Contact+"','"+Address_line1+"','"+Address_line2+"','"+zipcode+"','"+Email+"','"+Country+"',"
						+ "'"+from_Company_or_name+"','"+from_Contact+"','"+from_Address_line1+"','"+from_Address_line2+"','"+from_zipcode+"','"+from_Email+"','"+from_Country+"','"+radio+"','pending_approval','"+id+"')";
				
				String sql = sql1 + sql2;
				Statement st = conn.createStatement();
				st.executeUpdate(sql);
				
			
				String sql3 = "SELECT * from users where username = '"+id+"'";
				Statement st1 = conn.createStatement();
				ResultSet rs = st1.executeQuery(sql3);
				
				while(rs.next()) {
					agent = rs.getInt(8);    
				}
				
				if(agent == 1){
				RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/agenthome1.jsp");
				RequetsDispatcherObj.forward(request, response);
				}
				
				else{
					RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/usehomesuccessfulcreation.jsp");
					RequetsDispatcherObj.forward(request, response);	
					
				}
				
				String sql4 = "SELECT * FROM shipment_creation ORDER BY TrackingID DESC LIMIT 1";
				Statement st2 = conn.createStatement();
				ResultSet rs1 = st2.executeQuery(sql4);
				
				while(rs1.next()) {
					TrackingID = rs1.getInt(1);    
				}
				
				   SendEmail.main(null);
				   Dijkstra D1 = new Dijkstra();
				   D1.shortestPath(SCity,DCity,TrackingID);
				
		}
		catch (Exception e) { 
			pw.println(e);
		}
		}	
	}


