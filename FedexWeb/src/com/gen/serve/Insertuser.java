package com.gen.serve;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.jdbc.Connection;



/**
 * Servlet implementation class Insertuser
 */
@WebServlet("/Insertuser")
public class Insertuser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Insertuser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		// String connectionURL = "jdbc:mysql://127.0.0.1:3306/newData";//
		// newData is the database
		// Connection connection;
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "world";
		String driver = "com.mysql.jdbc.Driver";
		// String dbUserName="root";
		// String dbPassword="root";

		try {
			String Fname = request.getParameter("fname");
			String Lname = request.getParameter("lname");
			String Uname = request.getParameter("username");
			String Emailid = request.getParameter("emailid");
			String Mobno = request.getParameter("mobno");
			String Password1 = request.getParameter("password1");
			String Password2 = request.getParameter("password2");

			if (Uname == "" || Fname == "" || Lname == "" || Emailid == ""
					|| Mobno == "") {
				//pw.println("Please fill all fields");
				RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/signup.jsp");
				RequetsDispatcherObj.forward(request, response);
			}
			
			
		

			else {

				if (Emailid.contains("@") && ( Emailid.contains(".com") ||  Emailid.contains(".net")  
						|| Emailid.contains(".in") || Emailid.contains(".edu"))){
					
					if (Password1 != "" && Password2 != "") {

						if (!Password1.equals(Password2)) {
						//	pw.println("Your password and confirmation password do not match.");
						} else {

						Class.forName(driver).newInstance();
							conn =  DriverManager.getConnection(url
									+ dbName, "root", "1415");

							String sql1 = "INSERT INTO users(fname,lname,username,emailid,mobno,password1,password2)";
							String sql2 = "VALUES('" + Fname + "','" + Lname
									+ "','" + Uname + "','" + Emailid + "','"
									+ Mobno + "','" + Password1 + "','"
									+ Password2 + "');";
							String sql = sql1 + sql2;
							Statement st = conn.createStatement();
							st.executeUpdate(sql);
							
							//pw.println("You have been successfully added to the Tracking system !!!" );	
							RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/signupsuccessful.jsp");
							RequetsDispatcherObj.forward(request, response);					} // else end
					}
					else
					//pw.println("Your password fields should be filled ");
					;
					
					
				}
				else {

				//	RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/signupemailerror.jsp");
				//	RequetsDispatcherObj.forward(request, response);
				}
				
			}
		
			

		} // try end

		catch (Exception e) {
			pw.println(e);
		}

	}
}
