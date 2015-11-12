package com.gen.serve;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@WebServlet(name="GenServlet",urlPatterns={"/GenServlet"})
public class GenServlet extends GenericServlet {


	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = res.getWriter();
		ServletConfig sc = getServletConfig();
		String name = sc.getInitParameter("Name");
		out.println("Welcome ");
		
		ServletContext context = sc.getServletContext();
		String channel = context.getInitParameter("channelName");
		out.println("Channelname is" +channel);
		out.close(); 
	}
	
	
}
