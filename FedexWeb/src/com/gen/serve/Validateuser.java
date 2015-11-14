package com.gen.serve;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Validateuser
 */
@WebServlet("/Validateuser")
public class Validateuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validateuser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "world";
		String driver = "com.mysql.jdbc.Driver";
		String username = "";
		String password = "";
		int agent = 0;

		try {
			String userid = request.getParameter("userid");
			String pswrd = request.getParameter("pswrd");

	 
							Class.forName(driver).newInstance();
							conn = (Connection) DriverManager.getConnection(url
									+ dbName, "root", "1415");

							String sql1 = "SELECT * from users where username = '"+userid+"'";
							Statement st = conn.createStatement();
							ResultSet rs = st.executeQuery(sql1);
							
							while(rs.next()) {
								
							     username = rs.getString(3);
							     password = rs.getString(6);
							     agent = rs.getInt(8);
							     
							    
							}
							    if(userid.equals(username)  && pswrd.equals(password)){
							    	request.setAttribute("name", username);
							    	
							    	if(agent == 1){
							    	RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/agenthome.jsp");
							    	RequetsDispatcherObj.forward(request, response);
							    	}
							    	else{
							    	RequestDispatcher RequetsDispatcherObj1 =request.getRequestDispatcher("/userhome.jsp");
							    	RequetsDispatcherObj1.forward(request, response);
							    	}
								
							    }
							    else{
							    	  
							    	RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/homeinvalid.jsp");
							    	RequetsDispatcherObj.forward(request, response);
								
							    }
		} // try end

		catch (Exception e) {
			pw.println(e);
		}

	}

}
