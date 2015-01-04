package com.Servlwt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Hello World!</title></head>");
	    out.println("<body>");
       out.println("<h2><center>Hello World!</center></h2></body></html>");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {

                           doPost(req, res);

            }

}
