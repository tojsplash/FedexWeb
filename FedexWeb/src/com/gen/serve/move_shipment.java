package com.gen.serve;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class move_shipment
 */
@WebServlet("/move_shipment")
public class move_shipment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public move_shipment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
try{
			
			String number = request.getParameter("count");
			int count = Integer.parseInt(number);
					
	    	RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/move_shipments.jsp");
	    	RequetsDispatcherObj.forward(request, response);
	    	
	    	MultithreadingDemo demo = new MultithreadingDemo();
	    	demo.move(count);
		
		}catch (Exception e) {
			
		}
	}

}
