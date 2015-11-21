package com.gen.serve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.HashMap;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Request_authorise
 */
@WebServlet("/RequestAuthorise")
public class RequestAuthorise extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestAuthorise() {
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
		PrintWriter out = response.getWriter();
		out.print("Hello there.....");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HashMap<String, String> update_cmd = new HashMap<>();
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost/world";
				String username = "root";
				String password = "1415";
				java.sql.Connection conn = DriverManager.getConnection(url,
						username, password);
				java.sql.Statement stmt = conn.createStatement();

				String query = "update shipment_creation set status=" + '"'
						+ "%s" + '"' + " where TrackingID='%s'";
				String[] paramValues = request.getParameterValues(paramName);
				for (int i = 0; i < paramValues.length; i++) {
					String paramValue = paramValues[i];
					update_cmd.put(paramName, paramValue);
					String updated_query = String.format(query, paramValue,
							paramName);

					stmt.executeUpdate(updated_query);
					SendEmail mail = new SendEmail();
					
					if(paramValue.equals("Approved") || paramValue.equalsIgnoreCase("Rejected")){
					int ID = Integer.parseInt(paramName.toString());
					mail.sendconfirmation(ID);
					}

				}
			

				RequestDispatcher RequetsDispatcherObj = request
						.getRequestDispatcher("/pending_requests.jsp");
				RequetsDispatcherObj.forward(request, response);
				
			

			} catch (Exception e) {

			}
		}
	}
}
